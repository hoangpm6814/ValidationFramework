package validationframework.rules.comparison;

import javax.swing.JLabel;

public class ValidationLabelMaximum extends ValidationRuleMaximum{
    public JLabel label;

    public ValidationLabelMaximum(JLabel label, Comparable input, Comparable limiter, String message) {
        super(input, limiter, message);
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
