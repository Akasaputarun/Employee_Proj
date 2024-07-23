package com.tarun.service;

import com.tarun.dto.EmployeeDto;
import com.tarun.entity.Employee;
import com.tarun.exception.ResourceNotFoundException;
import com.tarun.mapper.EmployeeMapper;
import com.tarun.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
      private final EmployeeRepository employeeRepository;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {

        Employee employee = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Not Exist by id" + id));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());

    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto updatedEmployee) {

        Employee employee = employeeRepository.findById(id).orElseThrow(()
        -> new ResourceNotFoundException(" Not exist by Id"+ id));

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmployee1 = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployee1);
    }

    @Override
    public void deleteEmployee(Long id) {

        Employee employee1 = employeeRepository.findById(id).orElseThrow( () ->
                new ResourceNotFoundException((" Not exist by Id" + id)));

        employeeRepository.deleteById(id);

    }
}
