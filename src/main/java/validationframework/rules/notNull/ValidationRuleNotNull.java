package validationframework.rules.notNull;

import validationframework.rules.ValidationResult;
import static validationframework.rules.ValidationResult.inValid;
import static validationframework.rules.ValidationResult.valid;
import validationframework.rules.ValidationRule;

public abstract class ValidationRuleNotNull extends  ValidationRule {
    protected String input;

    public ValidationRuleNotNull(String input, String message) {
        super(message);
        this.input = input;
//        System.out.println(input);
    }

    @Override
    public ValidationResult validate(){
        boolean check = ((input != null) && (!"".equals(input)));
        ValidationResult result = (check == true) ? valid : inValid;
//        System.out.println(result);
        return result ;
    }
    @Override 
    public abstract void showMessage();
}
