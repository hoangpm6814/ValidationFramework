package annatations;

import validationframework.rules.object.ValidationRuleNotNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface NotNull {
  String category() default "ValidationRule";
  String message() default "Can not be null";
  Class<?> validationRule() default ValidationRuleNotNull.class;

}
