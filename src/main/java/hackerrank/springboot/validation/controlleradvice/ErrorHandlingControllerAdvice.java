package hackerrank.springboot.validation.controlleradvice;

import hackerrank.springboot.validation.util.Messages;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.*;

@ControllerAdvice
public class ErrorHandlingControllerAdvice {
    // fields and fieldMessages are used to control the output order of messages
    private static final List<String> fields = List.of("fullName", "mobileNumber", "emailId", "dateOfBirth");

    private static Map<String, List<String>> fieldMessages;

    static {
        fieldMessages = new HashMap<>();
        fieldMessages.put("fullName", List.of(
                Messages.THE_FULL_NAME_IS_A_MANDATORY_FIELD));
        fieldMessages.put("mobileNumber", List.of(
                Messages.THE_MOBILE_NUMBER_IS_A_MANDATORY_FIELD
        ));
        fieldMessages.put("emailId", List.of(
                Messages.THE_EMAIL_ID_SHOULD_BE_IN_VALID_EMAIL_FORMAT,
                Messages.THE_EMAIL_ID_IS_A_MANDATORY_FIELD));
        fieldMessages.put("dateOfBirth", List.of(
                Messages.THE_DATE_OF_BIRTH_SHOULD_BE_IN_YYYY_MM_DD_FORMAT,
                Messages.THE_DATE_OF_BIRTH_IS_A_MANDATORY_FIELD
        ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    List<FieldValidationMessage> onValidationException(MethodArgumentNotValidException e) {
        Map<String, String> fieldToMessage = new HashMap<>();
        Set<String> messages = new HashSet<>();
        List<FieldValidationMessage> response = new ArrayList<>();
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            messages.add(fieldError.getDefaultMessage());
        }
        Map<String, String> seenFieldMessages = new HashMap<>();
        for (String field : fields) {
            for (String message: fieldMessages.get(field)) {
                if (messages.contains(message)) {
                    seenFieldMessages.put(field, message);
                }
            }
        }
        for (String field: fields) {
            if (seenFieldMessages.containsKey(field)) {
                response.add(new FieldValidationMessage(seenFieldMessages.get(field)));
            }
        }

        return response;
    }
}
