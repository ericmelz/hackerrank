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

    @Test
    void whenEmployeeAllNull_thenReturnStatus400() throws Exception {
        Employee employee = invalidEmployeeAllNull();
        String body = objectMapper.writeValueAsString(employee);

        mvc.perform(post("/employee")
                        .contentType("application/json")
                        .content(body))
                .andExpect(status().isBadRequest());
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


}
