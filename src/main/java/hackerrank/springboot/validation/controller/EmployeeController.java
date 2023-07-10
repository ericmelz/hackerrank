package hackerrank.springboot.validation.controller;

import hackerrank.springboot.validation.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EmployeeController {
    @PostMapping("/employee")
    ResponseEntity<String> addEmployee(@Valid @RequestBody Employee employee) {
        return ResponseEntity.ok("Employee is valid");
    }
}
