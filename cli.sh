#!/bin/bash

set -euo pipefail

set -a; source .env; set +a

MAVEN_CENTRAL_TOKEN=$(printf "$MAVEN_CENTRAL_USERNAME:$MAVEN_CENTRAL_PASSWORD" | base64 )

upload() {
    curl --request POST \
        --verbose \
        --header "Authorization: Bearer $MAVEN_CENTRAL_TOKEN" \
        --form bundle=@aws-cdk-fn-helper.zip \
        https://central.sonatype.com/api/v1/publisher/upload
}

cmdCheck() {
    DEPLOYMENT=$1
    curl --request POST \
        --verbose \
        --header "Authorization: Bearer $MAVEN_CENTRAL_TOKEN" \
        "https://central.sonatype.com/api/v1/publisher/deployment/$DEPLOYMENT" \
        | jq
}

cmdPublish() {
    rm -f ./lib.zip
    ./gradlew clean publish
    pushd ./lib/build/staging-deploy
        pushd ./nl/bvkatwijk/aws-cdk-fn-helper
            VERSION=$(ls -lA | awk '/^d/ {print $9}')
            pushd ./$VERSION
                gpg --verify aws-cdk-fn-helper-$VERSION.jar.asc aws-cdk-fn-helper-$VERSION.jar
            popd
        popd
        zip -r ../../../aws-cdk-fn-helper.zip ./*
    popd
    upload
}

CMD=$1
case "$CMD" in
	"publish") cmdPublish ;;
    "check") cmdCheck $2 ;;
	*) echo "Unknown command $CMD"; exit 1 ;;
esac