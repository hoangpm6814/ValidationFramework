package validationframework.messageType;

import validationframework.rules.comparison.ValidationRuleMaximum;
import validationframework.rules.comparison.ValidationRuleMinimum;
import validationframework.rules.notNull.ValidationRuleNotNull;
import validationframework.rules.pattern.ValidationRulePattern;

public interface MessageFactory {
    public ValidationRuleNotNull createNotNullRule(String input,String message);
    public ValidationRuleMaximum createMaximumRule (Comparable input, Comparable limiter, String message);
    public ValidationRuleMinimum createMinimumRule (Comparable input, Comparable limiter, String message);
    public ValidationRulePattern createPatternRule (String input, String pattern, String message);
}
