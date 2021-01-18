package validationframework.rules;

import annatations.NotNull;
import validationframework.app.AbstractMessage;
import validationframework.rules.object.ValidationRuleNotNull;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;

import static validationframework.rules.ValidationResult.inValid;
import static validationframework.rules.ValidationResult.valid;

public class Validator extends AbstractValidationRule {
  private ArrayList<AbstractValidationRule> ruleSet;
  private Class<?> clazz;
  private AbstractMessage abstractionApp;

  public Validator(Object object) {
    super();
    ruleSet = new ArrayList();
    this.clazz = object.getClass();

    for (Method method : clazz.getDeclaredMethods()) {

      Annotation[] annotations = method.getAnnotations();

      if(annotations == null)
        continue;

      ValidationRuleSet methodRuleSet = new ValidationRuleSet();

      for(int i = 0; i < annotations.length; i++) {
        Annotation annotation = annotations[i];

        Class<? extends Annotation> annotationType = annotation.annotationType();

        try {

          String category = (String)annotationType.getMethod("category").invoke(annotation);

          if(category.equals("ValidationRule")) {

            Class<ValidationRule> validationRuleClass = (Class<ValidationRule>)annotationType.getMethod("validationRule").invoke(annotation);



            String message = (String)annotationType.getMethod("message").invoke(annotation);
            method.setAccessible(true);
            Constructor<ValidationRule> constructor;
            try {
              constructor = validationRuleClass.getConstructor(method.getReturnType(), String.class);

            } catch (NoSuchMethodException e) {
              constructor = validationRuleClass.getConstructor(Object.class, String.class);
            }

            ValidationRule validationRule = constructor.newInstance(method.invoke(object), message);

            methodRuleSet.addRule(validationRule);

          }
        }catch(Exception e) {
          System.out.println(e);
        }
      }

      if(methodRuleSet.getRuleSet().size() > 0 ) {
        this.addRule(methodRuleSet);
      }

    }

  }

  public ValidationResult validate() {
    for (int i = 0; i < ruleSet.size(); i++) {
      if (ruleSet.get(i).validate() == inValid) {
        return inValid;
      }
    }
    return valid;
  }

  public String getMessage() {
    String message = "";
    for (int i = 0; i < ruleSet.size(); i++) {
      if (ruleSet.get(i).validate() == inValid) {
        message += ruleSet.get(i).getMessage() + "\n";
      }
    }
    return message;
  }

  @Override
  public void showMessage() {
    for (int i = 0; i < ruleSet.size(); i++) {

      ruleSet.get(i).showMessage();
      if (ruleSet.get(i).validate() == inValid) {
        break;
      }
    }
  }

  public void addRule(AbstractValidationRule rule) {
    ruleSet.add(rule);
  }
}
