package hackerrank.springboot.validation;

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


    @NotBlank(message = "The fullName is a mandatory field")
    private String fullName;
    @NotBlank(message = "The mobileNumber is mandatory")
    @Pattern(regexp = "^\\d{10}$", message = "The mobileNumber is a mandatory field")
    private String mobileNumber;

    @NotBlank(message = "The emailId is a mandatory field")
    @Pattern(regexp = "^.*@.*$", message = "The email should be in valid email format")
    private String emailId;

    @NotBlank(message = "The dateOfBirth is a mandatory field")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")
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
