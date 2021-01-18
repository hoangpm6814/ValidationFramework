package annatations;

import validationframework.rules.comparable.ValidationRuleMinimum;
import validationframework.rules.object.ValidationRuleNotNull;
import validationframework.rules.string.ValidationRuleNotEmpty;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Minimum {
  String category() default "ValidationRule";
  String message() default "Exceed the minimum";

  Class<?> validationRule() default ValidationRuleMinimum.class;

}
