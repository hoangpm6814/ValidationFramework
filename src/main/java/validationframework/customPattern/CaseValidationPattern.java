package validationframework.customPattern;

public enum CaseValidationPattern implements ValidationPatterns {
    uppercase, lowercase;

    public String getPattern() {
        switch (this){
            case uppercase:
                return "^.*?[A-Z].*?$";
        
            case lowercase:
                return "^.*?[a-z].*?$";
        }
        return null;
    }
}
