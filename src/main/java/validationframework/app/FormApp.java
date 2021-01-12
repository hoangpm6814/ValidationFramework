package validationframework.app;

import validationframework.rules.AbstractValidationRule;

import javax.swing.*;

public interface FormApp {
    public void showMessage(JLabel label, AbstractValidationRule rule);
}