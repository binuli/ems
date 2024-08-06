package com.example.ems_backend.mapper;

import com.example.ems_backend.dto.EmployeeDto;
import com.example.ems_backend.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto employeeToEmployeeDto(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setEmail(employee.getEmail());

        return employeeDto;
    }

    public static Employee employeeDtoToEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());

        return employee;
    }
}
