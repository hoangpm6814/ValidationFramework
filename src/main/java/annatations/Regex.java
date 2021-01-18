package annatations;

import validationframework.rules.object.ValidationRuleNotNull;
import validationframework.rules.string.ValidationRuleNotEmpty;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Regex {
  String category() default "ValidationRule";
  String message() default "Can not be empty";
  Class<?> validationRule() default ValidationRuleNotEmpty.class;

}
