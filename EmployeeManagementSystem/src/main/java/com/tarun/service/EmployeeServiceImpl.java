package com.tarun.service;

import com.tarun.dto.EmployeeDto;
import com.tarun.entity.Employee;
import com.tarun.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

      private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee =

        return null;
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        return null;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return null;
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto updatedEmployee) {
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {

    }
}
