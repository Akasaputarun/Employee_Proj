package com.tarun.service;

import com.tarun.dto.DepartmentDto;
import  java.util.*;

public interface DepartmentService {

   DepartmentDto createDepartment(DepartmentDto departmentDto);

   DepartmentDto getDepartmentById(Long id);

   List<DepartmentDto> getAllDepartments();

   DepartmentDto updateDepartment(Long id, DepartmentDto updatedDepartmentDto);

   void deleteDepartment(Long id);

}
