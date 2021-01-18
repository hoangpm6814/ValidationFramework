package validationframework.rules.string;

import validationframework.rules.ValidationResult;
import validationframework.rules.ValidationRule;

import static validationframework.rules.ValidationResult.inValid;
import static validationframework.rules.ValidationResult.valid;

public class ValidationRuleNotEmpty extends ValidationRule <String> {
  protected String input;

  public ValidationRuleNotEmpty(String input, String message) {
    super(message);
    this.input = input;
//        System.out.println(input);
  }

  @Override
  public ValidationResult validate(){
    boolean check = ((input != null) && (!"".equals(input)));
    ValidationResult result = (check == true) ? valid : inValid;
    return result ;
  }
}
