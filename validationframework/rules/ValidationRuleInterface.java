package validationframework.rules;

public interface ValidationRuleInterface {
    public ValidationResult validate();
    public void showMessage();

    public String getMessage();
}
