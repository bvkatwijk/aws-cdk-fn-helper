# aws-cdk-fn-helper - default project description

[![Maven Central Version](https://img.shields.io/maven-central/v/nl.bvkatwijk/aws-cdk-fn-helper?versionPrefix=0)](https://mvnrepository.com/artifact/nl.bvkatwijk/aws-cdk-fn-helper)
[![CI](https://github.com/bvkatwijk/aws-cdk-fn-helper/actions/workflows/ci.yml/badge.svg?event=push)](https://github.com/bvkatwijk/aws-cdk-fn-helper/actions/)
[![codecov](https://codecov.io/gh/bvkatwijk/aws-cdk-fn-helper/graph/badge.svg?token=vHhhKxHXlJ)](https://codecov.io/gh/bvkatwijk/aws-cdk-fn-helper)

Test `Fn` functions locally

## About

## Usage

Instead of calling `Fn` statically, inject an instance of 
`FnDelegate` (using `IFn` interface)

Before:
```java
public record YourClass() {
    public String extractLoadBalancerName(String loadBalancerDns) {
        return Fn.select(0, Fn.split(".elb.", loadBalancerDns));
    }
}
```

After:
```java
public record YourClass(IFn fn) {
    public String extractLoadBalancerName(String loadBalancerDns) {
        return fn.select(0, fn.split(".elb.", loadBalancerDns));
    }
}
```

You can now unit test this method:
```java
@Test
void extractLoadBalancerNameTest() {
    var yourClass = new YourClass(new FnLocal());
    assertEquals(
        "myLoadBalancer",
        yourClass.extractLoadBalancerName("myLoadBalancer.elb.region.amazonaws.com")    
    );
}
```

## Build
```shell-script
gradle compileJava
```

## Test
```shell-script
gradle test
```
