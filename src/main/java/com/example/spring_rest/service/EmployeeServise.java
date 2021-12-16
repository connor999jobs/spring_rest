package com.example.spring_rest.service;

import com.example.spring_rest.entity.Employee;


import java.util.List;

public interface EmployeeServise {
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);
}
