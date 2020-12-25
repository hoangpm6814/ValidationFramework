package validationframework.rules.pattern;

public class ValidationConsolePattern extends ValidationRulePattern {

    public ValidationConsolePattern(String input, String pattern, String message) {
        super(input, pattern, message);
    }

    @Override
    public void showMessage() {
    	if (this.validate().isValid()){
            System.out.println("Data in valid !!!"); // hgv: Later, Change to null
        } else {
        	System.out.println(message);
        }
    }
}
