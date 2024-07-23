package com.tarun.dto;

public class EmployeeDto {

    private Long id;
    private String firstName;
    private String lastName;

    private String email;
    private Long departmentId;




    public EmployeeDto(Long id) {
        this.id = id;
    }

    public EmployeeDto(Long id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

    public EmployeeDto(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public EmployeeDto(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public EmployeeDto(Long id, String firstName, String lastName, String email, Long departmentId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.departmentId = departmentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
