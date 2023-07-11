package hackerrank.springboot.validation.controlleradvice;

public class FieldValidationMessage {
    private final String message;

    public FieldValidationMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
