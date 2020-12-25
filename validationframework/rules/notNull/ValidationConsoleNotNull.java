package validationframework.rules.notNull;

import javax.swing.JLabel;

public class ValidationConsoleNotNull extends ValidationRuleNotNull {

    public ValidationConsoleNotNull(String input, String message) {
        super(input, message);
    }
    @Override
    public void showMessage() {
//        System.out.println(message);
    	if (this.validate().isValid()){
    		System.out.println("Data in well!!!"); // hgv: Later, change to null
        } else {
        	System.out.println(message);
        }
    } 
    
}
