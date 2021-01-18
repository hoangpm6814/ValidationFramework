package validationframework.rules.string;

import validationframework.rules.ValidationResult;
import validationframework.rules.ValidationRule;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

import static validationframework.rules.ValidationResult.inValid;
import static validationframework.rules.ValidationResult.valid;

public class ValidationRuleNotEmpty extends ValidationRule <String> {
  protected String input;

  public ValidationRuleNotEmpty(String input, String message) {
    super(message);
    this.input = input;
//        System.out.println(input);
  }
  public ValidationRuleNotEmpty(Annotation annotation, Object data) {
    super("");
    Class<? extends Annotation> annotationType = annotation.annotationType();

    String message = "";
    try {
      message = (String) annotationType.getMethod("message").invoke(annotation);
    } catch(Exception e) {
      System.out.println(e);
    }
    this.message = message;
    this.input = (String) data;

  }
  @Override
  public ValidationResult validate(){
    boolean check = ((input != null) && (!"".equals(input)));
    ValidationResult result = (check == true) ? valid : inValid;
    return result ;
  }
}