package validationframework.validator;

import validationframework.rules.ValidationResult;

public interface ValidatorInterface {
    public void showMessage ();
    public ValidationResult validate ();
}
