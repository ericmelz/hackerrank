package hackerrank.springboot.validation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import hackerrank.springboot.validation.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Java6Assertions.assertThat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = EmployeeController.class)
public class ControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    private Employee invalidEmployeeAllNull() {
        Employee employee = new Employee();
        employee.setFullName(null);
        employee.setMobileNumber(null);
        employee.setEmailId(null);
        employee.setDateOfBirth(null);
        return employee;
    }

    private Employee invalidEmployeeAllBlank() {
        Employee employee = new Employee();
        employee.setFullName("");
        employee.setMobileNumber("");
        employee.setEmailId("");
        employee.setDateOfBirth("");
        return employee;
    }

    private Employee invalidEmployeeBadMobile() {
        Employee employee = new Employee();
        employee.setFullName("Foo Bar");
        employee.setMobileNumber("123456789");
        employee.setEmailId("test@gmail.com");
        employee.setDateOfBirth("1990-01-01");
        return employee;
    }

    private Employee invalidEmployeeBadEmail() {
        Employee employee = new Employee();
        employee.setFullName("Foo Bar");
        employee.setMobileNumber("1234567891");
        employee.setEmailId("test-At-gmail.com");
        employee.setDateOfBirth("1990-01-01");
        return employee;
    }

    private Employee invalidEmployeeBadDob() {
        Employee employee = new Employee();
        employee.setFullName("Foo Bar");
        employee.setMobileNumber("1234567891");
        employee.setEmailId("test@gmail.com");
        employee.setDateOfBirth("1990/01/01");
        return employee;
    }

    private Employee validEmployee() {
        Employee employee = new Employee();
        employee.setFullName("Foo Bar");
        employee.setMobileNumber("1234567891");
        employee.setEmailId("test@gmail.com");
        employee.setDateOfBirth("1990-01-01");
        return employee;
    }

    @Test
    void whenEmployeeAllNull_thenExpectErrors() throws Exception {
        Employee employee = invalidEmployeeAllNull();
        String body = objectMapper.writeValueAsString(employee);

        MvcResult result = mvc.perform(post("/employee")
                        .contentType("application/json")
                        .content(body))
                .andExpect(status().isBadRequest())
                .andReturn();

        assertThat(result.getResponse().getContentAsString()).isEqualTo(
                "[{\"message\":\"The fullName is a mandatory field\"}," +
                        "{\"message\":\"The mobileNumber is a mandatory field\"}," +
                        "{\"message\":\"The emailId is a mandatory field\"}," +
                        "{\"message\":\"The dateOfBirth is a mandatory field\"}]"
        );
    }

    @Test
    void whenEmployeeAllBlank_thenExpectErrors() throws Exception {
        Employee employee = invalidEmployeeAllBlank();
        String body = objectMapper.writeValueAsString(employee);

        MvcResult result = mvc.perform(post("/employee")
                        .contentType("application/json")
                        .content(body))
                .andExpect(status().isBadRequest())
                .andReturn();

        assertThat(result.getResponse().getContentAsString()).isEqualTo(
                "[{\"message\":\"The fullName is a mandatory field\"}," +
                        "{\"message\":\"The mobileNumber is a mandatory field\"}," +
                        "{\"message\":\"The emailId is a mandatory field\"}," +
                        "{\"message\":\"The dateOfBirth is a mandatory field\"}]"
        );
    }

    @Test
    void whenEmployeeBadMobile_thenExpectErrors() throws Exception {
        Employee employee = invalidEmployeeBadMobile();
        String body = objectMapper.writeValueAsString(employee);

        MvcResult result = mvc.perform(post("/employee")
                        .contentType("application/json")
                        .content(body))
                .andExpect(status().isBadRequest())
                .andReturn();

        assertThat(result.getResponse().getContentAsString()).isEqualTo(
                "[" +
                        "{\"message\":\"The mobileNumber is a mandatory field\"}" +
                        "]"
        );
    }

    @Test
    void whenEmployeeBadEmail_thenExpectErrors() throws Exception {
        Employee employee = invalidEmployeeBadEmail();
        String body = objectMapper.writeValueAsString(employee);

        MvcResult result = mvc.perform(post("/employee")
                        .contentType("application/json")
                        .content(body))
                .andExpect(status().isBadRequest())
                .andReturn();

        assertThat(result.getResponse().getContentAsString()).isEqualTo(
                "[" +
                        "{\"message\":\"The emailId should be in a valid email format\"}" +
                        "]"
        );
    }

    @Test
    void whenEmployeeValid_thenExpectStatusOk() throws Exception {
        Employee employee = validEmployee();
        String body = objectMapper.writeValueAsString(employee);

        MvcResult result = mvc.perform(post("/employee")
                        .contentType("application/json")
                        .content(body))
                .andExpect(status().isOk())
                .andReturn();

        assertThat(result.getResponse().getContentAsString()).isEqualTo(
                "Employee is valid"
        );
    }
}
