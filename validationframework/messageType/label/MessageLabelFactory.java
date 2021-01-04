package validationframework.messageType.label;

import javax.swing.JLabel;
import validationframework.messageType.MessageFactory;
import validationframework.rules.comparison.ValidationLabelMaximum;
import validationframework.rules.comparison.ValidationLabelMinimum;
import validationframework.rules.comparison.ValidationRuleMaximum;
import validationframework.rules.comparison.ValidationRuleMinimum;
import validationframework.rules.notNull.ValidationLabelNotNull;
import validationframework.rules.notNull.ValidationRuleNotNull;
import validationframework.rules.pattern.ValidationLabelPattern;
import validationframework.rules.pattern.ValidationRulePattern;

public class MessageLabelFactory implements MessageFactory {
    private JLabel label;

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public MessageLabelFactory(JLabel label) {
        this.label = label;
    }

    @Override
    public ValidationRuleNotNull createNotNullRule(String input, String message) {
        return new ValidationLabelNotNull (label, input, message );
    }

    @Override
    public ValidationRuleMaximum createMaximumRule(Comparable input, Comparable limiter, String message) {
        return new ValidationLabelMaximum (label, input, limiter, message );
    }

    @Override
    public ValidationRuleMinimum createMinimumRule(Comparable input, Comparable limiter, String message) {
        return new ValidationLabelMinimum (label, input, limiter, message );
    }

    @Override
    public ValidationRulePattern createPatternRule(String input, String pattern, String message) {
        return new ValidationLabelPattern(label, input, pattern, message);
    }
}
