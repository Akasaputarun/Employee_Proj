package com.tarun.controller;

import com.tarun.dto.DepartmentDto;
import com.tarun.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")

public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto savedDepartment = departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id")Long id){
        DepartmentDto departmentDto = departmentService.getDepartmentById(id);
        return ResponseEntity.ok(departmentDto);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getALlDepartments(){
        List<DepartmentDto> departmentDtos = departmentService.getAllDepartments();
        return ResponseEntity.ok(departmentDtos);
    }

    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id")Long id,
                                                           @RequestBody DepartmentDto updatedDepartmentDto) {

        DepartmentDto updatedDepartment = departmentService.updateDepartment(id, updatedDepartmentDto);
        return ResponseEntity.ok(updatedDepartment);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id")Long id){
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok("Department deleted Success");
    }
}