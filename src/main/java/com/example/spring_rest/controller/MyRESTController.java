package com.example.spring_rest.controller;

import com.example.spring_rest.entity.Employee;
import com.example.spring_rest.exeption_handling.EmployeeIncorrectData;
import com.example.spring_rest.exeption_handling.NoSuchEmployeeExeption;
import com.example.spring_rest.service.EmployeeServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeServise employeeServise;


    @GetMapping("/employees")
    public List<Employee> showAllEmployee(){
        List<Employee> allEmployee = employeeServise.getAllEmployees();
        return allEmployee;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee = employeeServise.getEmployee(id);
        if (employee == null){
            throw  new NoSuchEmployeeExeption( "The are not employee with this id =  "
            + id + " in dataBase");
        }
        return employee;
    }


    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee){

        employeeServise.saveEmployee(employee);
        return employee;
    }


    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){

        employeeServise.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){

        Employee employee = employeeServise.getEmployee(id);
        if (employee == null){
            throw new NoSuchEmployeeExeption("There is no employee with ID " +id + " in dataBase");
        }
        employeeServise.deleteEmployee(id);
        return "Employee with ID = " +id + " was delete";
    }

}
