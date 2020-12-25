package validationframework.validator;

import validationframework.rules.ValidationResult;
import validationframework.rules.ValidationRule;
import validationframework.rules.ValidationRuleInterface;

public class Validator implements ValidatorInterface{
    private ValidationRuleInterface validationRule;
    
    @Override
    public void showMessage (){
        validationRule.showMessage();
    }
    @Override
    public ValidationResult validate (){
        return validationRule.validate();
    }
    
    public Validator(ValidationRuleInterface validationRule){
       this.validationRule = validationRule; 
    }
}
