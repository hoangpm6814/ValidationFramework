package validationframework.rules.pattern;

import javax.swing.JLabel;

public class ValidationLabelPattern extends ValidationRulePattern {
    public JLabel label;

    public ValidationLabelPattern(JLabel label, String input, String pattern, String message) {
        super(input, pattern, message);
        this.label = label;
    }
    @Override
    public void showMessage() {
        if (this.validate().isValid()){
            label.setText("");
        } else {
            label.setText(message);
        }
    }
}
