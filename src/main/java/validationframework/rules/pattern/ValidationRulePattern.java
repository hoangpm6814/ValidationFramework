package validationframework.rules.pattern;

import validationframework.rules.ValidationResult;
import static validationframework.rules.ValidationResult.inValid;
import static validationframework.rules.ValidationResult.valid;
import validationframework.rules.ValidationRule;

public class ValidationRulePattern extends ValidationRule {
    
    protected String input;
    public String pattern;

    public ValidationRulePattern(String input, String pattern, String message) {
        super(message);
        this.input = input;
        this.pattern = pattern;
    }
    
    @Override
    public ValidationResult validate() {
        if (input.matches(pattern)){
            return valid;
        }
        return inValid;
    }
}
