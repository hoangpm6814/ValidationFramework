package validationframework.rules.comparison;

public class ValidationConsoleMinimum extends ValidationRuleMinimum {

    public ValidationConsoleMinimum(Comparable input, Comparable limiter, String message) {
        super(input, limiter, message);
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