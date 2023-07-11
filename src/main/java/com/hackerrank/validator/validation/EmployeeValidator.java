package com.hackerrank.validator.validation;

import com.hackerrank.validator.model.Employee;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Employee.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object employeeObject, Errors errors) {
        Employee employee = (Employee) employeeObject;
        ValidationUtils.rejectIfEmpty(errors, "fullName", "fullName.is.mandatory",
                "The fullName is a mandatory field");
        if (Objects.isNull(employee.getMobileNumber()) ||
                employee.getMobileNumber() < 1000000000L || employee.getMobileNumber() > 9999999999L) {
            errors.rejectValue("mobileNumber", "mobileNumber.is.mandatory",
                    "The mobileNumber is a mandatory field");
        }
        ValidationUtils.rejectIfEmpty(errors, "emailId", "emailId.is.mandatory",
                "The emailId is a mandatory field");
        if (!Objects.isNull(employee.getEmailId()) &&
                employee.getEmailId().length() > 0 &&
                employee.getEmailId().indexOf('@') == -1) {
            errors.rejectValue("emailId", "emailId.is.invalid",
                    "The emailId should be in a valid email format");
        }
        ValidationUtils.rejectIfEmpty(errors, "dateOfBirth", "dateOfBirth.is.mandatory",
                "The dateOfBirth is a mandatory field");
        if (!Objects.isNull(employee.getDateOfBirth()) &&
                employee.getDateOfBirth().length() > 0) {
            Pattern pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
            Matcher matcher = pattern.matcher(employee.getDateOfBirth());
            boolean matchFound = matcher.find();
            if (!matchFound) {
                errors.rejectValue("dateOfBirth", "dateOfBirth.is.invalid",
                        "The dateOfBirth should be in YYYY-MM-DD format");
            }
        }
    }
}