package TestString;

import validationframework.customPattern.ContainsNumberValidationPattern;
import validationframework.messageType.console.MessageConsoleFactory;
import validationframework.messageType.label.MessageLabelFactory;
import validationframework.rules.ValidationRuleSet;
import validationframework.rules.notNull.ValidationRuleNotNull;
import validationframework.rules.pattern.ValidationRulePattern;
import validationframework.validator.Validator;

public class TestStringDemo {
	public static void main(String[] args) {	
	    
////		Validate userName: Check not null
//		String userName = "hoanggavis";
////		String userName = "";
//        MessageConsoleFactory messageUsernameFactory = new MessageConsoleFactory();
//        ValidationRuleNotNull notNullRule = messageUsernameFactory.createNotNullRule(userName, "Username cannot be null");
//        System.out.println(userName);
//        Validator usernameValidator = new Validator (notNullRule);
//        usernameValidator.showMessage();
//        
//      //Validate password: Check pattern
//        String password = "hoanggavis";
////		String password = "hoang";
//        MessageConsoleFactory messagePasswordFactory = new MessageConsoleFactory();
//        ValidationRulePattern passwordLengthRule = messagePasswordFactory.createPatternRule(password,"\\b\\w{5,10}\\b", "Password must be between 5 and 10 characters");
//        Validator passwordValidator = new Validator (passwordLengthRule);
//        passwordValidator.showMessage();
        
//      Validate phone: Check ruleSet
		String phone = "0123456789";
//		String phone = "111111111h";
        MessageConsoleFactory messagePhoneFactory = new MessageConsoleFactory();
        ValidationRulePattern phoneLengthRule = messagePhoneFactory.createPatternRule(phone, "\\b\\w{10,11}\\b", "Phone numbers length must be 10 or 11 digits");
        ValidationRulePattern containNumberRule = messagePhoneFactory.createPatternRule(phone, ContainsNumberValidationPattern.createInstance().getPattern(), "Phone number just contains numeric values");
        ValidationRuleSet phoneRuleSet = new ValidationRuleSet();
        phoneRuleSet.addRule(phoneLengthRule);
        phoneRuleSet.addRule(containNumberRule);
        Validator phoneValidator = new Validator (phoneRuleSet);
        phoneValidator.showMessage();
        
//		String phone = "3942405111130";
//		String pattern = "^[0-9]*$"; // change to check vietnamese phone numbers if needed by uncomment code in the method
//		boolean x = phone.matches(pattern);
//		System.out.println(x);
	  }
}
