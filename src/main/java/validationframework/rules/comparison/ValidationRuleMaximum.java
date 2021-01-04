package validationframework.rules.comparison;

import static validationframework.rules.comparison.CompareOperator.isSmaller;

public abstract class ValidationRuleMaximum extends ValidationRuleComparison {

    public ValidationRuleMaximum(Comparable input, Comparable limiter, String message) {
        super(input, limiter, message);
    }
    
    
    @Override
    public abstract void showMessage();

    @Override
    protected CompareOperator getRule() {
        return isSmaller;
    }
    
}
