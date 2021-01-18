package annatations;

import validationframework.rules.comparable.ValidationRuleMaximum;
import validationframework.rules.object.ValidationRuleNotNull;
import validationframework.rules.string.ValidationRuleNotEmpty;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MinLength {
  String category() default "ValidationRule";
  String message() default "Exceed the minimum length";
  int min();
  Class<?> validationRule() default ValidationRuleMaximum.class;

}
