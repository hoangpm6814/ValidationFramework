package validationframework.rules;

public abstract class ValidationRule implements ValidationRuleInterface{
    protected String message;

    public abstract ValidationResult validate() ;

    public abstract void showMessage();
    
    public ValidationRule(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
