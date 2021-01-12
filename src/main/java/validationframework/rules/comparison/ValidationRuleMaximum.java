package validationframework.rules.comparison;

import static validationframework.rules.comparison.CompareOperator.isSmaller;

public class ValidationRuleMaximum extends ValidationRuleComparison {

    public ValidationRuleMaximum(Comparable input, Comparable limiter, String message) {
        super(input, limiter, message);
    }

    @Override
    protected CompareOperator getRule() {
        return isSmaller;
    }
    
}
