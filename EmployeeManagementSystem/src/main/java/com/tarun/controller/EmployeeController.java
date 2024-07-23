package com.tarun.controller;

import com.tarun.dto.EmployeeDto;
import com.tarun.service.EmployeeService;
import com.tarun.service.EmployeeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Provider;
import java.util.List;

@RestController
@RequestMapping("/api/employees")

public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){

        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);

    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id){

        EmployeeDto employeeDto = employeeService.getEmployeeById(id);

        return ResponseEntity.ok(employeeDto);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){

       List<EmployeeDto> employeeDto = employeeService.getAllEmployees();
       return ResponseEntity.ok(employeeDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id")Long id, @RequestBody EmployeeDto updatedEmployee){

        EmployeeDto employeeDto1= employeeService.updateEmployee(id, updatedEmployee);
        return ResponseEntity.ok(employeeDto1);
    }

   @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id")Long id) {

       employeeService.deleteEmployee(id);
       return ResponseEntity.ok("Successfully Deleted!");
   }

}