package com.example.ems_backend.service.impl;

import com.example.ems_backend.dto.EmployeeDto;
import com.example.ems_backend.entity.Employee;
import com.example.ems_backend.exception.ResourceNotFoundException;
import com.example.ems_backend.mapper.EmployeeMapper;
import com.example.ems_backend.repository.EmployeeRepository;
import com.example.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Service  //tells Sprint container to create Spring Beans for this class
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.employeeDtoToEmployee(employeeDto);

        Employee newEmployee = employeeRepository.save(employee);
        return EmployeeMapper.employeeToEmployeeDto(newEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee =getEmployee(id);
        return EmployeeMapper.employeeToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll().stream().map(EmployeeMapper::employeeToEmployeeDto).toList();
    }

    @Override
    public EmployeeDto updateEmployeeById(Long id, EmployeeDto updatedEmployeeDto) {
        Employee employee = getEmployee(id);

        if(!Objects.equals(employee.getFirstName(), updatedEmployeeDto.getFirstName())){
            employee.setFirstName(updatedEmployeeDto.getFirstName());
        }
        if(!Objects.equals(employee.getLastName(), updatedEmployeeDto.getLastName())){
            employee.setLastName(updatedEmployeeDto.getLastName());
        }
        if(!Objects.equals(employee.getEmail(), updatedEmployeeDto.getEmail())){
            employee.setEmail(updatedEmployeeDto.getEmail());
        }
        Employee updatedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.employeeToEmployeeDto(updatedEmployee);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        Employee employee = getEmployee(id);
        employeeRepository.deleteById(id);
    }

    private Employee getEmployee(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with given id: " + id));
    }
}
