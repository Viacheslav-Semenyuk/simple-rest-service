package com.smartfoxpro.simple.controller;

import com.smartfoxpro.simple.dto.EmployeeDto;
import com.smartfoxpro.simple.entity.Employee;
import com.smartfoxpro.simple.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return employeeService.getById(id);
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @PostMapping
    public void save(@RequestBody Employee employee) {
        employeeService.save(employee);
    }

    @PutMapping
    public Employee putUpdate(@RequestBody Employee employee) {
        return employeeService.putUpdate(employee);
    }

    @PatchMapping
    public Employee patchUpdate(@RequestBody EmployeeDto employeeDto) {
        return employeeService.patchUpdate(employeeDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        employeeService.deleteById(id);
    }

}
