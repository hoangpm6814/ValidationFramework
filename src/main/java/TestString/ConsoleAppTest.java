package TestString;

import validationframework.customPattern.ContainsNumberValidationPattern;
import validationframework.rules.AbstractValidationRule;
import validationframework.rules.ValidationRuleSet;
import validationframework.rules.notNull.ValidationRuleNotNull;
import validationframework.rules.pattern.ValidationRulePattern;
import validationframework.app.ConsoleApp;

public class ConsoleAppTest implements ConsoleApp {
	public static void main(String[] args) {
////        Validate userName: Check not null
//		String userName = "hoanggavis";
//        ValidationRuleNotNull notNullRule = new ValidationRuleNotNull(userName, "Username can not be null");
//        ConsoleAppTest consoleAppTest = new ConsoleAppTest();
//        consoleAppTest.showMessage(notNullRule);

//        Validate phone: Check ruleSet
        String phone = "1111111111";

        ValidationRulePattern phoneLengthRule = new ValidationRulePattern(phone, "\\b\\w{10,11}\\b", "Phone numbers length must be 10 or 11 digits");
        ValidationRulePattern containNumberRule = new ValidationRulePattern(phone, ContainsNumberValidationPattern.createInstance().getPattern(), "Phone number just contains numeric values");

        ValidationRuleSet phoneRuleSet = new ValidationRuleSet();
        phoneRuleSet.addRule(phoneLengthRule);
        phoneRuleSet.addRule(containNumberRule);

        ConsoleAppTest consoleAppTest = new ConsoleAppTest();
        consoleAppTest.showMessage(phoneRuleSet);
	}

    public void showMessage(AbstractValidationRule rule) {
        if (rule.validate().isValid()){
            System.out.println("Data in well!!!"); // hgv: Later, change to null
        } else {
            System.out.println(rule.getMessage());
        }
    }
}
