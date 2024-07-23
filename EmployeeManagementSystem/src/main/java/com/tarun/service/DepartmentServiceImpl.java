package com.tarun.service;

import com.tarun.dto.DepartmentDto;
import com.tarun.entity.Department;
import com.tarun.entity.Employee;
import com.tarun.exception.ResourceNotFoundException;
import com.tarun.mapper.DepartmentMapper;
import com.tarun.mapper.EmployeeMapper;
import com.tarun.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.maptoDepartment(departmentDto);
        Department saved = departmentRepository.save(department);
        return DepartmentMapper.maptoDepartmentDto(saved);

    }

    @Override
    public DepartmentDto getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found by id: " + id));
        return DepartmentMapper.maptoDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream()
                .map((department) -> DepartmentMapper.maptoDepartmentDto(department))
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(Long id, DepartmentDto updatedDepartmentDto) {
        Department existingDepartment = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found by id: " + id));

        existingDepartment.setDepartmentName(updatedDepartmentDto.getDepartmentName());
        existingDepartment.setDescription(updatedDepartmentDto.getDepartmentDescription());

        Department updatedDepartment = departmentRepository.save(existingDepartment);
        return DepartmentMapper.maptoDepartmentDto(updatedDepartment);
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}