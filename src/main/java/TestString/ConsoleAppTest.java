package TestString;

import validationframework.customPattern.ContainsNumberValidationPattern;
import validationframework.rules.ValidationRule;
import validationframework.rules.ValidationRuleSet;
import validationframework.rules.comparable.ValidationRuleMaximum;
import validationframework.rules.string.pattern.ValidationRulePattern;

public class ConsoleAppTest{
	public static void main(String[] args) {
//////        Validate userName: Check not null
////		String userName = "hoanggavis";
////        ValidationRuleNotNull notNullRule = new ValidationRuleNotNull(userName, "Username can not be null");
////        ConsoleAppTest consoleAppTest = new ConsoleAppTest();
////        consoleAppTest.showMessage(notNullRule);
//
////        Validate phone: Check ruleSet
        String phone = "b11111";
//
        ValidationRulePattern phoneLengthRule = new ValidationRulePattern(phone, "\\b\\w{10,11}\\b", "Phone numbers length must be 10 or 11 digits");
        ValidationRulePattern containNumberRule = new ValidationRulePattern(phone, ContainsNumberValidationPattern.createInstance().getPattern(), "Phone number just contains numeric values");
//
        ValidationRuleSet phoneRuleSet = new ValidationRuleSet();
        phoneRuleSet.addRule(phoneLengthRule);
        phoneRuleSet.addRule(containNumberRule);

        phoneRuleSet.showMessage();
//
//        AbstractionApp.showMessage(phoneLengthRule);
//
//        ValidationRule<Comparable> validationRule = new ValidationRuleMaximum("911", "91", "Smaller than 11");
//
//        validationRule.showMessage();


;	}

}
