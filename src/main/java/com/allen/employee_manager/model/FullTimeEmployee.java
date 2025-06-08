package com.allen.employee_manager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "FullTimeEmployees")
public class FullTimeEmployee extends Employee {
    @Column(nullable = false)
    private double salary;

    @Column(nullable = false)
    private int paidLeaveDays;

    @Column(nullable = false)
    private LocalDate hireDate;

    @Override
    public String getEmployeeType(){
        return "fulltime";
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getPaidLeaveDays() {
        return paidLeaveDays;
    }

    public void setPaidLeaveDays(int paidLeaveDays) {
        this.paidLeaveDays = paidLeaveDays;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }
}
