package validationframework.customPattern;

public enum EmailValidationPattern implements ValidationPatterns {
    simple, standard;

    public String getPattern() {
        switch (this){
            case simple:
                return "^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-+]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z‌​]{2,})$";
        
            case standard:
                return "^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-+]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z‌​]{2,})$";
        }
        return null;
    }
}

