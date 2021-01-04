package validationframework.rules;

public enum ValidationResult {
    inValid , valid;
    public boolean isValid(){
        switch (this){
            case inValid : return false;
            case valid : return true;
        }
        return false;
    }
}
