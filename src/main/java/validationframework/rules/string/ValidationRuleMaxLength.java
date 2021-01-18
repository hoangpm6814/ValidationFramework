package validationframework.rules.string;

import validationframework.rules.ValidationResult;
import validationframework.rules.ValidationRule;

import static validationframework.rules.ValidationResult.inValid;
import static validationframework.rules.ValidationResult.valid;

public class ValidationRuleMaxLength extends ValidationRule <String> {
  protected String input;
  int limiter;

  public ValidationRuleMaxLength(String input, int limiter, String message) {
    super(message);
    this.input = input;
    this.limiter = limiter;
  }

  @Override
  public ValidationResult validate(){
    boolean check = ((input != null) && (input.length() <= limiter));
    ValidationResult result = (check == true) ? valid : inValid;
    return result ;
  }
}
