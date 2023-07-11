package hackerrank.springboot.validation;

import hackerrank.springboot.validation.util.Messages;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = Messages.THE_FULL_NAME_IS_A_MANDATORY_FIELD)
    private String fullName;
    @NotBlank(message = Messages.THE_MOBILE_NUMBER_IS_A_MANDATORY_FIELD)
    @Pattern(regexp = "^\\d{10}$", message = Messages.THE_MOBILE_NUMBER_IS_A_MANDATORY_FIELD)
    private String mobileNumber;

    @Pattern(regexp = "^.*@.*$", message = Messages.THE_EMAIL_ID_SHOULD_BE_IN_VALID_EMAIL_FORMAT)
    @NotBlank(message = Messages.THE_EMAIL_ID_IS_A_MANDATORY_FIELD)
    private String emailId;

    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = Messages.THE_DATE_OF_BIRTH_SHOULD_BE_IN_YYYY_MM_DD_FORMAT)
    @NotBlank(message = Messages.THE_DATE_OF_BIRTH_IS_A_MANDATORY_FIELD)
    private String dateOfBirth;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
