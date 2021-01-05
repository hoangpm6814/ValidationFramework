package validationframework.rules;

import java.util.ArrayList;
import static validationframework.rules.ValidationResult.inValid;
import static validationframework.rules.ValidationResult.valid;

public class ValidationRuleSet implements ValidationRuleInterface{
    private ArrayList <ValidationRuleInterface> ruleSet;

    public ValidationRuleSet(ArrayList <ValidationRuleInterface> ruleSet) {
        super();
        this.ruleSet = ruleSet;
    }
    public ValidationRuleSet(){
        ruleSet = new ArrayList();
    }

    public ValidationResult validate() {
        for (int i = 0 ; i < ruleSet.size(); i++){
            if (ruleSet.get(i).validate() == inValid){
                return inValid;
            }
        }
        return valid;
    }
    public String getMessage (){
        String message = "";
        for (int i = 0 ; i < ruleSet.size(); i++){
            if (ruleSet.get(i).validate() == inValid){
                message += ruleSet.get(i).getMessage() + "\n";
            }
        }
        return message;
    }

    public void showMessage(){
        for (int i = 0 ; i < ruleSet.size(); i++){
            ruleSet.get(i).showMessage();
            if (ruleSet.get(i).validate() == inValid ){
                break;
            }
        }
    }
    public void addRule(ValidationRuleInterface rule){
        ruleSet.add(rule);
    }
}
