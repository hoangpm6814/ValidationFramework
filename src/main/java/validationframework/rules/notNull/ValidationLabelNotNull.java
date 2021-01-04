package validationframework.rules.notNull;

import javax.swing.JLabel;

public class ValidationLabelNotNull extends ValidationRuleNotNull {
    public JLabel label;

    public ValidationLabelNotNull(JLabel label, String input, String message) {
        super(input, message);
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

    public JLabel getLabel() {
        return label;
    }
    
    public void setLabel(JLabel label) {
        this.label = label;
    }
}
