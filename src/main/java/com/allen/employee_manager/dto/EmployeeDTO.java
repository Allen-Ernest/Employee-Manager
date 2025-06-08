package com.allen.employee_manager.dto;

import java.time.LocalDate;

public class EmployeeDTO {
    private String employeeType;
    private String firstName;
    private String lastName;
    private boolean isActive;
    private LocalDate hireDate;
    private String department;
    private String email;
    private String phone;
    private double salary;
    private double hourlyRate;
    private String benefitsPackage;
    private int paidLeaveDays;
    private int maxHoursPerWeek;
    private double scheduledHours;
    private boolean onCallEligible;
    private LocalDate startDate;

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getMaxHoursPerWeek() {
        return maxHoursPerWeek;
    }

    public void setMaxHoursPerWeek(int maxHoursPerWeek) {
        this.maxHoursPerWeek = maxHoursPerWeek;
    }

    public int getPaidLeaveDays() {
        return paidLeaveDays;
    }

    public void setPaidLeaveDays(int paidLeaveDays) {
        this.paidLeaveDays = paidLeaveDays;
    }

    public String getBenefitsPackage() {
        return benefitsPackage;
    }

    public void setBenefitsPackage(String benefitsPackage) {
        this.benefitsPackage = benefitsPackage;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getScheduledHours() {
        return scheduledHours;
    }

    public void setScheduledHours(double scheduledHours) {
        this.scheduledHours = scheduledHours;
    }

    public boolean isOnCallEligible() {
        return onCallEligible;
    }

    public void setOnCallEligible(boolean onCallEligible) {
        this.onCallEligible = onCallEligible;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
