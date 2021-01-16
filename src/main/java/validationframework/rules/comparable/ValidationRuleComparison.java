package validationframework.rules.comparable;

import validationframework.rules.ValidationResult;
import static validationframework.rules.ValidationResult.*;
import validationframework.rules.ValidationRule;

enum CompareOperator{
  isBigger, isSmaller;
  String getOperator (){
    switch (this){
      case isBigger: return ">";
      case isSmaller: return "<";
    }
    return null;
  }
}

public abstract class ValidationRuleComparison extends ValidationRule <Comparable>{
  protected Comparable input;
  protected Comparable limiter;

  public ValidationRuleComparison(Comparable input, Comparable limiter, String message) {
    super(message);
    this.input = input;
    this.limiter = limiter;
  }
  @Override
  public ValidationResult validate(){
    CompareOperator op = getRule();
    boolean check = false;

    switch (op){
      case isBigger: check = input.compareTo (limiter) >= 0;break;
      case isSmaller: check = limiter.compareTo(input) >=0;break;
    }
    ValidationResult result = (check == true) ? valid : inValid;
    return result ;
  }

  protected abstract CompareOperator getRule();
}
