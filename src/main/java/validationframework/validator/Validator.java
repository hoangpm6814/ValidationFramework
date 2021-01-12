package validationframework.validator;

import validationframework.rules.ValidationResult;
import validationframework.rules.AbstractValidationRule;

public class Validator implements ValidatorInterface{
    private AbstractValidationRule validationRule;

    public void showMessage (){
        validationRule.showMessage();
    }

    public ValidationResult validate (){
        return validationRule.validate();
    }
    
    public Validator(AbstractValidationRule validationRule){
       this.validationRule = validationRule; 
    }
}
