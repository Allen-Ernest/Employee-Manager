package com.allen.employee_manager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "PartTimeEmployee")
public class PartTimeEmployee extends Employee {
    @Column(nullable = false)
    private double hourlyRate;

    @Column(nullable = false)
    private int maxHoursPerWeek;

    @Column(nullable = false)
    private double scheduledHours;

    @Column(nullable = false)
    private boolean onCallEligible;

    @Column(nullable = false)
    private LocalDate startDate;

    @Override
    public String getEmployeeType(){
        return "parttime";
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

    public int getMaxHoursPerWeek() {
        return maxHoursPerWeek;
    }

    public void setMaxHoursPerWeek(int maxHoursPerWeek) {
        this.maxHoursPerWeek = maxHoursPerWeek;
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
