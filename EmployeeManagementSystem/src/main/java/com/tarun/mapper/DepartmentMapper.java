package com.tarun.mapper;

import com.tarun.dto.DepartmentDto;
import com.tarun.entity.Department;

public class DepartmentMapper {

    public static DepartmentDto maptoDepartmentDto(Department department){

        return  new DepartmentDto(

                department.getDepartmentId(),
                department.getDepartmentName(),
                department.getDescription()
        );
    }

    public static Department maptoDepartment(DepartmentDto departmentDto){

        return new Department(
                departmentDto.getDepartmentId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription()
        );

    }
}