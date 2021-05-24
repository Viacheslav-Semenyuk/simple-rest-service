package com.smartfoxpro.simple.service;

import com.smartfoxpro.simple.dto.EmployeeDto;
import com.smartfoxpro.simple.entity.Employee;

import java.util.List;

public interface EmployeeService {

    void save(Employee employee);

    Employee getById(Long id);

    List<Employee> getAll();

    Employee putUpdate(Employee employee);

    Employee patchUpdate(EmployeeDto employeeDto);

    void deleteById(Long id);
}
