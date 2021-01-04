package validationframework.rules.comparison;

import static validationframework.rules.comparison.CompareOperator.isBigger;

public abstract class ValidationRuleMinimum extends ValidationRuleComparison{

    public ValidationRuleMinimum(Comparable input, Comparable limiter, String message) {
        super(input, limiter, message);
    }

    
    @Override
    public abstract void showMessage();

    @Override
    protected CompareOperator getRule() {
        return isBigger;
    }  
}
