package com.payroll;

import com.payroll.model.Employee;
import com.payroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    public Employee addEmployee(Employee emp) {
        return repo.save(emp);
    }

    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    public Employee getEmployee(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public void deleteEmployee(Long id) {
        repo.deleteById(id);
    }

    // 🔥 Salary calculation logic (Business Rule)
    public double calculateSalary(Long id) {
        Employee e = getEmployee(id);

        if (e.getType().equals("FULL_TIME")) {
            return e.getMonthlySalary() + e.getBonus() - e.getDeduction();
        } else {
            return e.getHoursWorked() * e.getHourlyRate();
        }
    }
}
