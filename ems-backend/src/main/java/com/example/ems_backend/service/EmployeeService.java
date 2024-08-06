package com.example.ems_backend.service;

import com.example.ems_backend.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto addEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long id);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployeeById(Long id, EmployeeDto updatedEmployeeDto);

    void deleteEmployeeById(Long id);
}
