package com.payroll.controller;

import com.payroll.model.Employee;
import com.payroll.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // Add employee
    @PostMapping
    public Employee addEmployee(@RequestBody Employee emp) {
        return service.addEmployee(emp);
    }

    // Get all
    @GetMapping
    public List<Employee> getAll() {
        return service.getAllEmployees();
    }

    // Get by id
    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return service.getEmployee(id);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteEmployee(id);
        return "Employee deleted";
    }

    // Calculate Salary
    @GetMapping("/{id}/salary")
    public double getSalary(@PathVariable Long id) {
        return service.calculateSalary(id);
    }
}
