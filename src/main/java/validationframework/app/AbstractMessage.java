package validationframework.app;

import validationframework.rules.AbstractValidationRule;
import validationframework.rules.ValidationRule;

import javax.swing.*;

public abstract class AbstractMessage {
    protected AbstractValidationRule rule;

    public abstract void showMessage();

    public void setValidator(AbstractValidationRule rule) {
        this.rule = rule;

    }
}
