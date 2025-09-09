package nl.bvkatwijk.awscdkfnhelper;

public class FnDelegate {
	public java.lang.String base64(final @org.jetbrains.annotations.NotNull java.lang.String data) {
		return software.amazon.awscdk.Fn.base64(data);
	}
	public java.util.List<java.lang.String> cidr(final @org.jetbrains.annotations.NotNull java.lang.String ipBlock, final @org.jetbrains.annotations.NotNull java.lang.Number count, final @org.jetbrains.annotations.Nullable java.lang.String sizeMask) {
		return software.amazon.awscdk.Fn.cidr(ipBlock, count, sizeMask);
	}
	public java.util.List<java.lang.String> cidr(final @org.jetbrains.annotations.NotNull java.lang.String ipBlock, final @org.jetbrains.annotations.NotNull java.lang.Number count) {
		return software.amazon.awscdk.Fn.cidr(ipBlock, count);
	}
	public software.amazon.awscdk.ICfnRuleConditionExpression conditionAnd(final @org.jetbrains.annotations.NotNull software.amazon.awscdk.ICfnConditionExpression... conditions) {
		return software.amazon.awscdk.Fn.conditionAnd(conditions);
	}
	public software.amazon.awscdk.ICfnRuleConditionExpression conditionContains(final @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> listOfStrings, final @org.jetbrains.annotations.NotNull java.lang.String value) {
		return software.amazon.awscdk.Fn.conditionContains(listOfStrings, value);
	}
	public software.amazon.awscdk.ICfnRuleConditionExpression conditionEachMemberEquals(final @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> listOfStrings, final @org.jetbrains.annotations.NotNull java.lang.String value) {
		return software.amazon.awscdk.Fn.conditionEachMemberEquals(listOfStrings, value);
	}
	public software.amazon.awscdk.ICfnRuleConditionExpression conditionEachMemberIn(final @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> stringsToCheck, final @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> stringsToMatch) {
		return software.amazon.awscdk.Fn.conditionEachMemberIn(stringsToCheck, stringsToMatch);
	}
	public software.amazon.awscdk.ICfnRuleConditionExpression conditionEquals(final @org.jetbrains.annotations.NotNull java.lang.Object lhs, final @org.jetbrains.annotations.NotNull java.lang.Object rhs) {
		return software.amazon.awscdk.Fn.conditionEquals(lhs, rhs);
	}
	public software.amazon.awscdk.ICfnRuleConditionExpression conditionIf(final @org.jetbrains.annotations.NotNull java.lang.String conditionId, final @org.jetbrains.annotations.NotNull java.lang.Object valueIfTrue, final @org.jetbrains.annotations.NotNull java.lang.Object valueIfFalse) {
		return software.amazon.awscdk.Fn.conditionIf(conditionId, valueIfTrue, valueIfFalse);
	}
	public software.amazon.awscdk.ICfnRuleConditionExpression conditionNot(final @org.jetbrains.annotations.NotNull software.amazon.awscdk.ICfnConditionExpression condition) {
		return software.amazon.awscdk.Fn.conditionNot(condition);
	}
	public software.amazon.awscdk.ICfnRuleConditionExpression conditionOr(final @org.jetbrains.annotations.NotNull software.amazon.awscdk.ICfnConditionExpression... conditions) {
		return software.amazon.awscdk.Fn.conditionOr(conditions);
	}
	public java.lang.String findInMap(final @org.jetbrains.annotations.NotNull java.lang.String mapName, final @org.jetbrains.annotations.NotNull java.lang.String topLevelKey, final @org.jetbrains.annotations.NotNull java.lang.String secondLevelKey, final @org.jetbrains.annotations.Nullable java.lang.String defaultValue) {
		return software.amazon.awscdk.Fn.findInMap(mapName, topLevelKey, secondLevelKey, defaultValue);
	}
	public java.lang.String findInMap(final @org.jetbrains.annotations.NotNull java.lang.String mapName, final @org.jetbrains.annotations.NotNull java.lang.String topLevelKey, final @org.jetbrains.annotations.NotNull java.lang.String secondLevelKey) {
		return software.amazon.awscdk.Fn.findInMap(mapName, topLevelKey, secondLevelKey);
	}
	public software.amazon.awscdk.IResolvable getAtt(final @org.jetbrains.annotations.NotNull java.lang.String logicalNameOfResource, final @org.jetbrains.annotations.NotNull java.lang.String attributeName) {
		return software.amazon.awscdk.Fn.getAtt(logicalNameOfResource, attributeName);
	}
	public java.util.List<java.lang.String> getAzs(final @org.jetbrains.annotations.Nullable java.lang.String region) {
		return software.amazon.awscdk.Fn.getAzs(region);
	}
	public java.util.List<java.lang.String> getAzs() {
		return software.amazon.awscdk.Fn.getAzs();
	}
	public java.util.List<java.lang.String> importListValue(final @org.jetbrains.annotations.NotNull java.lang.String sharedValueToImport, final @org.jetbrains.annotations.NotNull java.lang.Number assumedLength, final @org.jetbrains.annotations.Nullable java.lang.String delimiter) {
		return software.amazon.awscdk.Fn.importListValue(sharedValueToImport, assumedLength, delimiter);
	}
	public java.util.List<java.lang.String> importListValue(final @org.jetbrains.annotations.NotNull java.lang.String sharedValueToImport, final @org.jetbrains.annotations.NotNull java.lang.Number assumedLength) {
		return software.amazon.awscdk.Fn.importListValue(sharedValueToImport, assumedLength);
	}
	public java.lang.String importValue(final @org.jetbrains.annotations.NotNull java.lang.String sharedValueToImport) {
		return software.amazon.awscdk.Fn.importValue(sharedValueToImport);
	}
	public java.lang.String join(final @org.jetbrains.annotations.NotNull java.lang.String delimiter, final @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> listOfValues) {
		return software.amazon.awscdk.Fn.join(delimiter, listOfValues);
	}
	public java.lang.Number len(final @org.jetbrains.annotations.NotNull java.lang.Object array) {
		return software.amazon.awscdk.Fn.len(array);
	}
	public java.lang.String parseDomainName(final @org.jetbrains.annotations.NotNull java.lang.String url) {
		return software.amazon.awscdk.Fn.parseDomainName(url);
	}
	public java.lang.String ref(final @org.jetbrains.annotations.NotNull java.lang.String logicalName) {
		return software.amazon.awscdk.Fn.ref(logicalName);
	}
	public java.util.List<java.lang.String> refAll(final @org.jetbrains.annotations.NotNull java.lang.String parameterType) {
		return software.amazon.awscdk.Fn.refAll(parameterType);
	}
	public java.lang.String select(final @org.jetbrains.annotations.NotNull java.lang.Number index, final @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> array) {
		return software.amazon.awscdk.Fn.select(index, array);
	}
	public java.util.List<java.lang.String> split(final @org.jetbrains.annotations.NotNull java.lang.String delimiter, final @org.jetbrains.annotations.NotNull java.lang.String source, final @org.jetbrains.annotations.Nullable java.lang.Number assumedLength) {
		return software.amazon.awscdk.Fn.split(delimiter, source, assumedLength);
	}
	public java.util.List<java.lang.String> split(final @org.jetbrains.annotations.NotNull java.lang.String delimiter, final @org.jetbrains.annotations.NotNull java.lang.String source) {
		return software.amazon.awscdk.Fn.split(delimiter, source);
	}
	public java.lang.String sub(final @org.jetbrains.annotations.NotNull java.lang.String body, final @org.jetbrains.annotations.Nullable java.util.Map<java.lang.String, java.lang.String> variables) {
		return software.amazon.awscdk.Fn.sub(body, variables);
	}
	public java.lang.String sub(final @org.jetbrains.annotations.NotNull java.lang.String body) {
		return software.amazon.awscdk.Fn.sub(body);
	}
	public java.lang.String toJsonString(final @org.jetbrains.annotations.NotNull java.lang.Object object) {
		return software.amazon.awscdk.Fn.toJsonString(object);
	}
	public software.amazon.awscdk.IResolvable transform(final @org.jetbrains.annotations.NotNull java.lang.String macroName, final @org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, ? extends java.lang.Object> parameters) {
		return software.amazon.awscdk.Fn.transform(macroName, parameters);
	}
	public java.lang.String valueOf(final @org.jetbrains.annotations.NotNull java.lang.String parameterOrLogicalId, final @org.jetbrains.annotations.NotNull java.lang.String attribute) {
		return software.amazon.awscdk.Fn.valueOf(parameterOrLogicalId, attribute);
	}
	public java.util.List<java.lang.String> valueOfAll(final @org.jetbrains.annotations.NotNull java.lang.String parameterType, final @org.jetbrains.annotations.NotNull java.lang.String attribute) {
		return software.amazon.awscdk.Fn.valueOfAll(parameterType, attribute);
	}
}
