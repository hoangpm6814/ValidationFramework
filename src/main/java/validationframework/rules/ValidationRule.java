package validationframework.rules;

import java.lang.annotation.Annotation;

public abstract class ValidationRule <T> extends AbstractValidationRule {
    protected String message;

    public abstract ValidationResult validate() ;


    
    public ValidationRule(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void showMessage() {
        abstractMessage.setValidator(this);
        abstractMessage.showMessage();
    }

}
