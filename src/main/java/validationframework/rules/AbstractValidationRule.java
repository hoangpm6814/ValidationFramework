package validationframework.rules;

public abstract class AbstractValidationRule {
    public abstract ValidationResult validate();

    public abstract String getMessage();
}
