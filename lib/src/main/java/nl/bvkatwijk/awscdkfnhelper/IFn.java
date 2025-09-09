package nl.bvkatwijk.awscdkfnhelper;

public interface IFn {
	/**
	* The intrinsic function <code>Fn::Base64</code> returns the Base64 representation of the input string.
	* <p>
	* This function is typically used to pass encoded data to
	* Amazon EC2 instances by way of the UserData property.
	* <p>
	* @return a token represented as a string
	* @param data The string value you want to convert to Base64. This parameter is required.
	*/
	@software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Stable)
	java.lang.String base64(final @org.jetbrains.annotations.NotNull java.lang.String data);

	/**
	* The intrinsic function <code>Fn::Cidr</code> returns the specified Cidr address block.
	* <p>
	* @return a token represented as a string
	* @param ipBlock The user-specified default Cidr address block. This parameter is required.
	* @param count The number of subnets' Cidr block wanted. This parameter is required.
	* @param sizeMask The digit covered in the subnet.
	*/
	@software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Stable)
	java.util.List<java.lang.String> cidr(final @org.jetbrains.annotations.NotNull java.lang.String ipBlock, final @org.jetbrains.annotations.NotNull java.lang.Number count, final @org.jetbrains.annotations.Nullable java.lang.String sizeMask);

	/**
	* The intrinsic function <code>Fn::Cidr</code> returns the specified Cidr address block.
	* <p>
	* @return a token represented as a string
	* @param ipBlock The user-specified default Cidr address block. This parameter is required.
	* @param count The number of subnets' Cidr block wanted. This parameter is required.
	*/
	@software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Stable)
	java.util.List<java.lang.String> cidr(final @org.jetbrains.annotations.NotNull java.lang.String ipBlock, final @org.jetbrains.annotations.NotNull java.lang.Number count);

	/**
	* Returns true if all the specified conditions evaluate to true, or returns false if any one of the conditions evaluates to false.
	* <p>
	* <code>Fn::And</code> acts as
	* an AND operator. The minimum number of conditions that you can include is
	* 1.
	* <p>
	* @return an FnCondition token
	* @param conditions conditions to AND. This parameter is required.
	*/
	@software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Stable)
	software.amazon.awscdk.ICfnRuleConditionExpression conditionAnd(final @org.jetbrains.annotations.NotNull software.amazon.awscdk.ICfnConditionExpression... conditions);

	/**
	* Returns true if a specified string matches at least one value in a list of strings.
	* <p>
	* @return an FnCondition token
	* @param listOfStrings A list of strings, such as "A", "B", "C". This parameter is required.
	* @param value A string, such as "A", that you want to compare against a list of strings. This parameter is required.
	*/
	@software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Stable)
	software.amazon.awscdk.ICfnRuleConditionExpression conditionContains(final @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> listOfStrings, final @org.jetbrains.annotations.NotNull java.lang.String value);

	/**
	* Returns true if a specified string matches all values in a list.
	* <p>
	* @return an FnCondition token
	* @param listOfStrings A list of strings, such as "A", "B", "C". This parameter is required.
	* @param value A string, such as "A", that you want to compare against a list of strings. This parameter is required.
	*/
	@software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Stable)
	software.amazon.awscdk.ICfnRuleConditionExpression conditionEachMemberEquals(final @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> listOfStrings, final @org.jetbrains.annotations.NotNull java.lang.String value);

	/**
	* Returns true if each member in a list of strings matches at least one value in a second list of strings.
	* <p>
	* @return an FnCondition token
	* @param stringsToCheck A list of strings, such as "A", "B", "C". This parameter is required.
	* @param stringsToMatch A list of strings, such as "A", "B", "C". This parameter is required.
	*/
	@software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Stable)
	software.amazon.awscdk.ICfnRuleConditionExpression conditionEachMemberIn(final @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> stringsToCheck, final @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> stringsToMatch);

	/**
	* Compares if two values are equal.
	* <p>
	* Returns true if the two values are equal
	* or false if they aren't.
	* <p>
	* @return an FnCondition token
	* @param lhs A value of any type that you want to compare. This parameter is required.
	* @param rhs A value of any type that you want to compare. This parameter is required.
	*/
	@software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Stable)
	software.amazon.awscdk.ICfnRuleConditionExpression conditionEquals(final @org.jetbrains.annotations.NotNull java.lang.Object lhs, final @org.jetbrains.annotations.NotNull java.lang.Object rhs);

	/**
	* Returns one value if the specified condition evaluates to true and another value if the specified condition evaluates to false.
	* <p>
	* Currently, AWS
	* CloudFormation supports the <code>Fn::If</code> intrinsic function in the metadata
	* attribute, update policy attribute, and property values in the Resources
	* section and Outputs sections of a template. You can use the AWS::NoValue
	* pseudo parameter as a return value to remove the corresponding property.
	* <p>
	* @return an FnCondition token
	* @param conditionId A reference to a condition in the Conditions section. This parameter is required.
	* @param valueIfTrue A value to be returned if the specified condition evaluates to true. This parameter is required.
	* @param valueIfFalse A value to be returned if the specified condition evaluates to false. This parameter is required.
	*/
	@software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Stable)
	software.amazon.awscdk.ICfnRuleConditionExpression conditionIf(final @org.jetbrains.annotations.NotNull java.lang.String conditionId, final @org.jetbrains.annotations.NotNull java.lang.Object valueIfTrue, final @org.jetbrains.annotations.NotNull java.lang.Object valueIfFalse);

	/**
	* Returns true for a condition that evaluates to false or returns false for a condition that evaluates to true.
	* <p>
	* <code>Fn::Not</code> acts as a NOT operator.
	* <p>
	* @return an FnCondition token
	* @param condition A condition such as <code>Fn::Equals</code> that evaluates to true or false. This parameter is required.
	*/
	@software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Stable)
	software.amazon.awscdk.ICfnRuleConditionExpression conditionNot(final @org.jetbrains.annotations.NotNull software.amazon.awscdk.ICfnConditionExpression condition);

	/**
	* Returns true if any one of the specified conditions evaluate to true, or returns false if all of the conditions evaluates to false.
	* <p>
	* <code>Fn::Or</code> acts
	* as an OR operator. The minimum number of conditions that you can include is
	* 1.
	* <p>
	* @return an FnCondition token
	* @param conditions conditions that evaluates to true or false. This parameter is required.
	*/
	@software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Stable)
	software.amazon.awscdk.ICfnRuleConditionExpression conditionOr(final @org.jetbrains.annotations.NotNull software.amazon.awscdk.ICfnConditionExpression... conditions);

	/**
	* The intrinsic function <code>Fn::FindInMap</code> returns the value corresponding to keys in a two-level map that is declared in the Mappings section.
	* <p>
	* Warning: do not use with lazy mappings as this function will not guarentee a lazy mapping to render in the template.
	* Prefer to use <code>CfnMapping.findInMap</code> in general.
	* <p>
	* @return a token represented as a string
	* @param mapName This parameter is required.
	* @param topLevelKey This parameter is required.
	* @param secondLevelKey This parameter is required.
	* @param defaultValue
	*/
	@software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Stable)
	java.lang.String findInMap(final @org.jetbrains.annotations.NotNull java.lang.String mapName, final @org.jetbrains.annotations.NotNull java.lang.String topLevelKey, final @org.jetbrains.annotations.NotNull java.lang.String secondLevelKey, final @org.jetbrains.annotations.Nullable java.lang.String defaultValue);

	/**
	* The intrinsic function <code>Fn::FindInMap</code> returns the value corresponding to keys in a two-level map that is declared in the Mappings section.
	* <p>
	* Warning: do not use with lazy mappings as this function will not guarentee a lazy mapping to render in the template.
	* Prefer to use <code>CfnMapping.findInMap</code> in general.
	* <p>
	* @return a token represented as a string
	* @param mapName This parameter is required.
	* @param topLevelKey This parameter is required.
	* @param secondLevelKey This parameter is required.
	*/
	@software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Stable)
	java.lang.String findInMap(final @org.jetbrains.annotations.NotNull java.lang.String mapName, final @org.jetbrains.annotations.NotNull java.lang.String topLevelKey, final @org.jetbrains.annotations.NotNull java.lang.String secondLevelKey);

	/**
	* The <code>Fn::GetAtt</code> intrinsic function returns the value of an attribute from a resource in the template.
	* <p>
	* @return an IResolvable object
	* @param logicalNameOfResource The logical name (also called logical ID) of the resource that contains the attribute that you want. This parameter is required.
	* @param attributeName The name of the resource-specific attribute whose value you want. This parameter is required.
	*/
	@software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Stable)
	software.amazon.awscdk.IResolvable getAtt(final @org.jetbrains.annotations.NotNull java.lang.String logicalNameOfResource, final @org.jetbrains.annotations.NotNull java.lang.String attributeName);

	/**
	* The intrinsic function <code>Fn::GetAZs</code> returns an array that lists Availability Zones for a specified region.
	* <p>
	* Because customers have access to
	* different Availability Zones, the intrinsic function <code>Fn::GetAZs</code> enables
	* template authors to write templates that adapt to the calling user's
	* access. That way you don't have to hard-code a full list of Availability
	* Zones for a specified region.
	* <p>
	* @return a token represented as a string array
	* @param region The name of the region for which you want to get the Availability Zones.
	*/
	@software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Stable)
	java.util.List<java.lang.String> getAzs(final @org.jetbrains.annotations.Nullable java.lang.String region);

	/**
	* The intrinsic function <code>Fn::GetAZs</code> returns an array that lists Availability Zones for a specified region.
	* <p>
	* Because customers have access to
	* different Availability Zones, the intrinsic function <code>Fn::GetAZs</code> enables
	* template authors to write templates that adapt to the calling user's
	* access. That way you don't have to hard-code a full list of Availability
	* Zones for a specified region.
	* <p>
	* @return a token represented as a string array
	*/
	@software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Stable)
	java.util.List<java.lang.String> getAzs();

	/**
	* Like <code>Fn.importValue</code>, but import a list with a known length.
	* <p>
	* If you explicitly want a list with an unknown length, call <code>Fn.split(',', Fn.importValue(exportName))</code>. See the documentation of <code>Fn.split</code> to read
	* more about the limitations of using lists of unknown length.
	* <p>
	* <code>Fn.importListValue(exportName, assumedLength)</code> is the same as
	* <code>Fn.split(',', Fn.importValue(exportName), assumedLength)</code>,
	* but easier to read and impossible to forget to pass <code>assumedLength</code>.
	* <p>
	* @param sharedValueToImport This parameter is required.
	* @param assumedLength This parameter is required.
	* @param delimiter
	*/
	@software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Stable)
	java.util.List<java.lang.String> importListValue(final @org.jetbrains.annotations.NotNull java.lang.String sharedValueToImport, final @org.jetbrains.annotations.NotNull java.lang.Number assumedLength, final @org.jetbrains.annotations.Nullable java.lang.String delimiter);

	/**
	* Like <code>Fn.importValue</code>, but import a list with a known length.
	* <p>
	* If you explicitly want a list with an unknown length, call <code>Fn.split(',', Fn.importValue(exportName))</code>. See the documentation of <code>Fn.split</code> to read
	* more about the limitations of using lists of unknown length.
	* <p>
	* <code>Fn.importListValue(exportName, assumedLength)</code> is the same as
	* <code>Fn.split(',', Fn.importValue(exportName), assumedLength)</code>,
	* but easier to read and impossible to forget to pass <code>assumedLength</code>.
	* <p>
	* @param sharedValueToImport This parameter is required.
	* @param assumedLength This parameter is required.
	*/
	@software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Stable)
	java.util.List<java.lang.String> importListValue(final @org.jetbrains.annotations.NotNull java.lang.String sharedValueToImport, final @org.jetbrains.annotations.NotNull java.lang.Number assumedLength);

	/**
	* The intrinsic function <code>Fn::ImportValue</code> returns the value of an output exported by another stack.
	* <p>
	* You typically use this function to create
	* cross-stack references. In the following example template snippets, Stack A
	* exports VPC security group values and Stack B imports them.
	* <p>
	* @return a token represented as a string
	* @param sharedValueToImport The stack output value that you want to import. This parameter is required.
	*/
	@software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Stable)
	java.lang.String importValue(final @org.jetbrains.annotations.NotNull java.lang.String sharedValueToImport);

	/**
	* The intrinsic function <code>Fn::Join</code> appends a set of values into a single value, separated by the specified delimiter.
	* <p>
	* If a delimiter is the empty
	* string, the set of values are concatenated with no delimiter.
	* <p>
	* @return a token represented as a string
	* @param delimiter The value you want to occur between fragments. This parameter is required.
	* @param listOfValues The list of values you want combined. This parameter is required.
	*/
	@software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Stable)
	java.lang.String join(final @org.jetbrains.annotations.NotNull java.lang.String delimiter, final @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> listOfValues);

	/**
	* The intrinsic function <code>Fn::Length</code> returns the number of elements within an array or an intrinsic function that returns an array.
	* <p>
	* @param array The array you want to return the number of elements from. This parameter is required.
	*/
	@software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Stable)
	java.lang.Number len(final @org.jetbrains.annotations.NotNull java.lang.Object array);

	/**
	* Given an url, parse the domain name.
	* <p>
	* @param url the url to parse. This parameter is required.
	*/
	@software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Stable)
	java.lang.String parseDomainName(final @org.jetbrains.annotations.NotNull java.lang.String url);

	/**
	* The <code>Ref</code> intrinsic function returns the value of the specified parameter or resource.
	* <p>
	* Note that it doesn't validate the logicalName, it mainly serves parameter/resource reference defined in a <code>CfnInclude</code> template.
	* <p>
	* @param logicalName The logical name of a parameter/resource for which you want to retrieve its value. This parameter is required.
	*/
	@software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Stable)
	java.lang.String ref(final @org.jetbrains.annotations.NotNull java.lang.String logicalName);

	/**
	* Returns all values for a specified parameter type.
	* <p>
	* @return a token represented as a string array
	* @param parameterType An AWS-specific parameter type, such as AWS::EC2::SecurityGroup::Id or AWS::EC2::VPC::Id. This parameter is required.
	*/
	@software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Stable)
	java.util.List<java.lang.String> refAll(final @org.jetbrains.annotations.NotNull java.lang.String parameterType);

	/**
	* The intrinsic function <code>Fn::Select</code> returns a single object from a list of objects by index.
	* <p>
	* @return a token represented as a string
	* @param index The index of the object to retrieve. This parameter is required.
	* @param array The list of objects to select from. This parameter is required.
	*/
	@software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Stable)
	java.lang.String select(final @org.jetbrains.annotations.NotNull java.lang.Number index, final @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> array);

	/**
	* Split a string token into a token list of string values.
	* <p>
	* Specify the location of splits with a delimiter such as ',' (a comma).
	* Renders to the <code>Fn::Split</code> intrinsic function.
	* <p>
	* <h2>Lists with unknown lengths (default)</h2>
	* <p>
	* Since this function is used to work with deploy-time values, if <code>assumedLength</code>
	* is not given the CDK cannot know the length of the resulting list at synthesis time.
	* This brings the following restrictions:
	* <p>
	* <ul>
	* <li>You must use <code>Fn.select(i, list)</code> to pick elements out of the list (you must not use
	* <code>list[i]</code>).</li>
	* <li>You cannot add elements to the list, remove elements from the list,
	* combine two such lists together, or take a slice of the list.</li>
	* <li>You cannot pass the list to constructs that do any of the above.</li>
	* </ul>
	* <p>
	* The only valid operation with such a tokenized list is to pass it unmodified to a
	* CloudFormation Resource construct.
	* <p>
	* <h2>Lists with assumed lengths</h2>
	* <p>
	* Pass <code>assumedLength</code> if you know the length of the list that will be
	* produced by splitting. The actual list length at deploy time may be
	* <em>longer</em> than the number you pass, but not <em>shorter</em>.
	* <p>
	* The returned list will look like:
	* <p>
	* <blockquote><pre>
	* [Fn.select(0, split), Fn.select(1, split), Fn.select(2, split), ...]
	* </pre></blockquote>
	* <p>
	* The restrictions from the section "Lists with unknown lengths" will now be lifted,
	* at the expense of having to know and fix the length of the list.
	* <p>
	* @return a token represented as a string array
	* @param delimiter A string value that determines where the source string is divided. This parameter is required.
	* @param source The string value that you want to split. This parameter is required.
	* @param assumedLength The length of the list that will be produced by splitting.
	*/
	@software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Stable)
	java.util.List<java.lang.String> split(final @org.jetbrains.annotations.NotNull java.lang.String delimiter, final @org.jetbrains.annotations.NotNull java.lang.String source, final @org.jetbrains.annotations.Nullable java.lang.Number assumedLength);

	/**
	* Split a string token into a token list of string values.
	* <p>
	* Specify the location of splits with a delimiter such as ',' (a comma).
	* Renders to the <code>Fn::Split</code> intrinsic function.
	* <p>
	* <h2>Lists with unknown lengths (default)</h2>
	* <p>
	* Since this function is used to work with deploy-time values, if <code>assumedLength</code>
	* is not given the CDK cannot know the length of the resulting list at synthesis time.
	* This brings the following restrictions:
	* <p>
	* <ul>
	* <li>You must use <code>Fn.select(i, list)</code> to pick elements out of the list (you must not use
	* <code>list[i]</code>).</li>
	* <li>You cannot add elements to the list, remove elements from the list,
	* combine two such lists together, or take a slice of the list.</li>
	* <li>You cannot pass the list to constructs that do any of the above.</li>
	* </ul>
	* <p>
	* The only valid operation with such a tokenized list is to pass it unmodified to a
	* CloudFormation Resource construct.
	* <p>
	* <h2>Lists with assumed lengths</h2>
	* <p>
	* Pass <code>assumedLength</code> if you know the length of the list that will be
	* produced by splitting. The actual list length at deploy time may be
	* <em>longer</em> than the number you pass, but not <em>shorter</em>.
	* <p>
	* The returned list will look like:
	* <p>
	* <blockquote><pre>
	* [Fn.select(0, split), Fn.select(1, split), Fn.select(2, split), ...]
	* </pre></blockquote>
	* <p>
	* The restrictions from the section "Lists with unknown lengths" will now be lifted,
	* at the expense of having to know and fix the length of the list.
	* <p>
	* @return a token represented as a string array
	* @param delimiter A string value that determines where the source string is divided. This parameter is required.
	* @param source The string value that you want to split. This parameter is required.
	*/
	@software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Stable)
	java.util.List<java.lang.String> split(final @org.jetbrains.annotations.NotNull java.lang.String delimiter, final @org.jetbrains.annotations.NotNull java.lang.String source);

	/**
	* The intrinsic function <code>Fn::Sub</code> substitutes variables in an input string with values that you specify.
	* <p>
	* In your templates, you can use this function
	* to construct commands or outputs that include values that aren't available
	* until you create or update a stack.
	* <p>
	* @return a token represented as a string
	* @param body A string with variables that AWS CloudFormation substitutes with their associated values at runtime. This parameter is required.
	* @param variables The name of a variable that you included in the String parameter.
	*/
	@software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Stable)
	java.lang.String sub(final @org.jetbrains.annotations.NotNull java.lang.String body, final @org.jetbrains.annotations.Nullable java.util.Map<java.lang.String, java.lang.String> variables);

	/**
	* The intrinsic function <code>Fn::Sub</code> substitutes variables in an input string with values that you specify.
	* <p>
	* In your templates, you can use this function
	* to construct commands or outputs that include values that aren't available
	* until you create or update a stack.
	* <p>
	* @return a token represented as a string
	* @param body A string with variables that AWS CloudFormation substitutes with their associated values at runtime. This parameter is required.
	*/
	@software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Stable)
	java.lang.String sub(final @org.jetbrains.annotations.NotNull java.lang.String body);

	/**
	* The <code>Fn::ToJsonString</code> intrinsic function converts an object or array to its corresponding JSON string.
	* <p>
	* @param object The object or array to stringify. This parameter is required.
	*/
	@software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Stable)
	java.lang.String toJsonString(final @org.jetbrains.annotations.NotNull java.lang.Object object);

	/**
	* Creates a token representing the <code>Fn::Transform</code> expression.
	* <p>
	* @return a token representing the transform expression
	* @see <a href="https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/intrinsic-function-reference-transform.html">https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/intrinsic-function-reference-transform.html</a>
	* @param macroName The name of the macro to perform the processing. This parameter is required.
	* @param parameters The parameters to be passed to the macro. This parameter is required.
	*/
	@software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Stable)
	software.amazon.awscdk.IResolvable transform(final @org.jetbrains.annotations.NotNull java.lang.String macroName, final @org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, ? extends java.lang.Object> parameters);

	/**
	* Returns an attribute value or list of values for a specific parameter and attribute.
	* <p>
	* @return a token represented as a string
	* @param parameterOrLogicalId The name of a parameter for which you want to retrieve attribute values. This parameter is required.
	* @param attribute The name of an attribute from which you want to retrieve a value. This parameter is required.
	*/
	@software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Stable)
	java.lang.String valueOf(final @org.jetbrains.annotations.NotNull java.lang.String parameterOrLogicalId, final @org.jetbrains.annotations.NotNull java.lang.String attribute);

	/**
	* Returns a list of all attribute values for a given parameter type and attribute.
	* <p>
	* @return a token represented as a string array
	* @param parameterType An AWS-specific parameter type, such as AWS::EC2::SecurityGroup::Id or AWS::EC2::VPC::Id. This parameter is required.
	* @param attribute The name of an attribute from which you want to retrieve a value. This parameter is required.
	*/
	@software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Stable)
	java.util.List<java.lang.String> valueOfAll(final @org.jetbrains.annotations.NotNull java.lang.String parameterType, final @org.jetbrains.annotations.NotNull java.lang.String attribute);

}
