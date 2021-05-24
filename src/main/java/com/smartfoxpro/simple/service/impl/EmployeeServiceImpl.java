package com.smartfoxpro.simple.service.impl;

import com.smartfoxpro.simple.dto.EmployeeDto;
import com.smartfoxpro.simple.entity.Employee;
import com.smartfoxpro.simple.repository.EmployeeRepository;
import com.smartfoxpro.simple.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee update(Employee employee) {
        getById(employee.getId());
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateSalary(EmployeeDto employeeDto) {
        Employee employee = getById(employeeDto.getId());
        employee.setSalary(employeeDto.getSalary());
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        getById(id);
        employeeRepository.deleteById(id);
    }
}
