package validationframework.customPattern;

public class ContainsNumberValidationPattern implements ValidationPatterns {
    
    public static ContainsNumberValidationPattern shared = new ContainsNumberValidationPattern();

    private ContainsNumberValidationPattern() {
        
    }
    @Override
    public String getPattern() {
//    	return "(09|01[2|6|8|9])+([0-9]{8})\\\\b"; // hgv: Check phone in VietNam, starts with 09xxx, 0126, 0122, ...
    	return "^[0-9]*$"; // hgv: Only check only numbers
    }
}