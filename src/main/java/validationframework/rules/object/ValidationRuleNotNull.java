package validationframework.rules.object;

import validationframework.rules.ValidationResult;
import static validationframework.rules.ValidationResult.inValid;
import static validationframework.rules.ValidationResult.valid;
import validationframework.rules.ValidationRule;

public class ValidationRuleNotNull extends  ValidationRule {
    protected Object input;

    public ValidationRuleNotNull(Object input, String message) {
        super(message);
        this.input = input;
    }

    @Override
    public ValidationResult validate(){
        boolean check = (input != null);
        ValidationResult result = (check == true) ? valid : inValid;
        return result ;
    }
}
