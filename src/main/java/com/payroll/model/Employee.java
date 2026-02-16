package com.payroll.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;   // FULL_TIME / PART_TIME

    private double monthlySalary;
    private double bonus;
    private double deduction;

    private int hoursWorked;
    private double hourlyRate;
}

