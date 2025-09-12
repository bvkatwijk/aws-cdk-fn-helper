package nl.bvkatwijk.awscdkfnhelper;

import lombok.NonNull;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

public class FnLocal implements IFn {

    @Override
    public String base64(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public List<String> cidr(String ipBlock, Number count, String sizeMask) {
        return List.of();
    }

    @Override
    public List<String> cidr(String ipBlock, Number count) {
        return List.of();
    }

    @Override
    public software.amazon.awscdk.ICfnRuleConditionExpression conditionAnd(software.amazon.awscdk.ICfnConditionExpression... conditions) {
        return null;
    }

    @Override
    public software.amazon.awscdk.ICfnRuleConditionExpression conditionContains(List<String> listOfStrings,
        String value) {
        return null;
    }

    @Override
    public software.amazon.awscdk.ICfnRuleConditionExpression conditionEachMemberEquals(List<String> listOfStrings,
        String value) {
        return null;
    }

    @Override
    public software.amazon.awscdk.ICfnRuleConditionExpression conditionEachMemberIn(List<String> stringsToCheck,
        List<String> stringsToMatch) {
        return null;
    }

    @Override
    public software.amazon.awscdk.ICfnRuleConditionExpression conditionEquals(Object lhs, Object rhs) {
        return null;
    }

    @Override
    public software.amazon.awscdk.ICfnRuleConditionExpression conditionIf(String conditionId,
        Object valueIfTrue,
        Object valueIfFalse) {
        return null;
    }

    @Override
    public software.amazon.awscdk.ICfnRuleConditionExpression conditionNot(software.amazon.awscdk.ICfnConditionExpression condition) {
        return null;
    }

    @Override
    public software.amazon.awscdk.ICfnRuleConditionExpression conditionOr(software.amazon.awscdk.ICfnConditionExpression... conditions) {
        return null;
    }

    @Override
    public String findInMap(String mapName, String topLevelKey, String secondLevelKey, String defaultValue) {
        return "";
    }

    @Override
    public String findInMap(String mapName, String topLevelKey, String secondLevelKey) {
        return "";
    }

    @Override
    public software.amazon.awscdk.IResolvable getAtt(String logicalNameOfResource, String attributeName) {
        return null;
    }

    @Override
    public List<String> getAzs(String region) {
        return List.of();
    }

    @Override
    public List<String> getAzs() {
        return List.of();
    }

    @Override
    public List<String> importListValue(String sharedValueToImport, Number assumedLength, String delimiter) {
        return List.of();
    }

    @Override
    public List<String> importListValue(String sharedValueToImport, Number assumedLength) {
        return List.of();
    }

    @Override
    public String importValue(String sharedValueToImport) {
        return "";
    }

    @Override
    public String join(String delimiter, List<String> listOfValues) {
        return "";
    }

    @Override
    public Number len(Object array) {
        return null;
    }

    @Override
    public String parseDomainName(String url) {
        return "";
    }

    @Override
    public String ref(String logicalName) {
        return "";
    }

    @Override
    public List<String> refAll(String parameterType) {
        return List.of();
    }

    @Override
    public String select(Number index, List<String> array) {
        return "";
    }

    @Override
    public List<String> split(String delimiter, String source, Number assumedLength) {
        return List.of();
    }

    @Override
    public List<String> split(@NonNull String delimiter, @NonNull String source) {
        List<String> parts = new ArrayList<>();
        var start = 0;
        int index;
        while ((index = source.indexOf(delimiter, start)) != -1) {
            parts.add(source.substring(start, index));
            start = index + delimiter.length();
        }
        parts.add(source.substring(start));
        return parts;
    }

    @Override
    public String sub(String body, Map<String, String> variables) {
        return "";
    }

    @Override
    public String sub(String body) {
        return "";
    }

    @Override
    public String toJsonString(Object object) {
        return "";
    }

    @Override
    public software.amazon.awscdk.IResolvable transform(String macroName, Map<String, ?> parameters) {
        return null;
    }

    @Override
    public String valueOf(String parameterOrLogicalId, String attribute) {
        return "";
    }

    @Override
    public List<String> valueOfAll(String parameterType, String attribute) {
        return List.of();
    }
}
