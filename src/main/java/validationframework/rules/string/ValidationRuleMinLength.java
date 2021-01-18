package validationframework.rules.string;

import validationframework.rules.ValidationResult;
import validationframework.rules.ValidationRule;

import java.lang.annotation.Annotation;

import static validationframework.rules.ValidationResult.inValid;
import static validationframework.rules.ValidationResult.valid;

public class ValidationRuleMinLength extends ValidationRule <String> {
  protected String input;
  int limiter;

  public ValidationRuleMinLength(String input, int limiter, String message) {
    super(message);
    this.input = input;
    this.limiter = limiter;
  }
  public ValidationRuleMinLength(Annotation annotation, Object data) {
    super("");
    Class<? extends Annotation> annotationType = annotation.annotationType();

    String message = "";
    int min = 0;
    try {
      message = (String) annotationType.getMethod("message").invoke(annotation);
      min = (int) annotationType.getMethod("min").invoke(annotation);
    } catch(Exception e) {
      System.out.println(e);
    }
    this.message = message;
    this.input = (String) data;
    this.limiter = min;
  }

  @Override
  public ValidationResult validate(){
    boolean check = ((input != null) && (input.length() >= limiter));
    ValidationResult result = (check == true) ? valid : inValid;
    return result ;
  }
}
