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
    public Employee putUpdate(Employee employee) {
        getById(employee.getId());
        return employeeRepository.save(employee);
    }

    @Override
    public Employee patchUpdate(EmployeeDto employeeDto) {
        Employee employee = getById(employeeDto.getId());
        if (employeeDto.getFirstName() != null) {
            employee.setFirstName(employeeDto.getFirstName());
        }
        if (employeeDto.getLastName() != null) {
            employee.setLastName(employeeDto.getLastName());
        }
        if (employeeDto.getSalary() != null) {
            employee.setSalary(employeeDto.getSalary());
        }
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        getById(id);
        employeeRepository.deleteById(id);
    }
}
