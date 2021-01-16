package validationframework.app;

import jdk.nashorn.internal.objects.annotations.Setter;
import validationframework.rules.AbstractValidationRule;

public class ConsoleMessage extends AbstractMessage {

  public ConsoleMessage() {
    super();
  }

  @Override
  public void showMessage() {

    if (rule.validate().isValid()) {
      System.out.println("");
    } else {
      System.out.println(rule.getMessage());
    }

  }
}
