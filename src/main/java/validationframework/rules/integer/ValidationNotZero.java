package validationframework.rules.integer;

import validationframework.rules.ValidationResult;
import validationframework.rules.ValidationRule;

import static validationframework.rules.ValidationResult.inValid;
import static validationframework.rules.ValidationResult.valid;

public class ValidationNotZero extends ValidationRule <Integer> {
  protected int input;

  public ValidationNotZero(int input, String message) {
    super(message);
    this.input = input;
  }

  @Override
  public ValidationResult validate(){
    boolean check = (input != 0);
    ValidationResult result = (check == true) ? valid : inValid;
    return result ;
  }
}
