package validationframework.messageType.console;

import validationframework.messageType.MessageFactory;
import validationframework.rules.comparison.ValidationConsoleMaximum;
import validationframework.rules.comparison.ValidationConsoleMinimum;
import validationframework.rules.comparison.ValidationRuleMaximum;
import validationframework.rules.comparison.ValidationRuleMinimum;
import validationframework.rules.notNull.ValidationConsoleNotNull;
import validationframework.rules.notNull.ValidationRuleNotNull;
import validationframework.rules.pattern.ValidationConsolePattern;
import validationframework.rules.pattern.ValidationRulePattern;

public class MessageConsoleFactory implements MessageFactory {
	public MessageConsoleFactory() {
    }
    @Override
    public ValidationRuleNotNull createNotNullRule(String input, String message) {
        return new ValidationConsoleNotNull(input, message);
    }

    @Override
    public ValidationRuleMaximum createMaximumRule(Comparable input, Comparable limiter, String message) {
        return new ValidationConsoleMaximum(input, limiter, message);
    }

    @Override
    public ValidationRuleMinimum createMinimumRule(Comparable input, Comparable limiter, String message) {
        return new ValidationConsoleMinimum(input, limiter, message);
    }

    @Override
    public ValidationRulePattern createPatternRule(String input, String pattern, String message) {
        return new ValidationConsolePattern(input, pattern, message);    
    }
    
}
