package validationframework.rules;

import lombok.Setter;
import lombok.Getter;
import validationframework.app.ConsoleMessage;
import validationframework.app.AbstractMessage;

public abstract class AbstractValidationRule {

    @Setter
    @Getter
    protected AbstractMessage abstractMessage;

    public AbstractValidationRule(AbstractMessage abstractMessage) {
        this.abstractMessage = abstractMessage;
    }
    public AbstractValidationRule() {
        this.abstractMessage = new ConsoleMessage();
    }

    public abstract ValidationResult validate();

    public abstract String getMessage();

    public abstract void showMessage();

}
