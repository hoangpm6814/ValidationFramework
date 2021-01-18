package annatations;

import validationframework.rules.integer.ValidationRuleNotZero;
import validationframework.rules.object.ValidationRuleNotNull;
import validationframework.rules.string.ValidationRuleNotEmpty;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface NotZero {
  String category() default "ValidationRule";
  String message() default "Can not be zero";
  Class<?> validationRule() default ValidationRuleNotZero.class;

}
