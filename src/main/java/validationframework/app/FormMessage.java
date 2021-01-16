package validationframework.app;

import javax.swing.*;

public class FormMessage extends AbstractMessage {

  private JLabel jLabel;

  public FormMessage(JLabel jLabel) {
    this.jLabel = jLabel;
  }

  public FormMessage() {
    super();
  }
  @Override
  public void showMessage() {
    if (rule.validate().isValid()){
      jLabel.setText("");
    } else {
      jLabel.setText(rule.getMessage());
    }
  }

}
