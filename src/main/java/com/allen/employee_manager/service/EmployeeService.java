package com.allen.employee_manager.service;

import com.allen.employee_manager.dto.EmployeeDTO;
import com.allen.employee_manager.model.Employee;
import com.allen.employee_manager.model.FullTimeEmployee;
import com.allen.employee_manager.model.PartTimeEmployee;
import com.allen.employee_manager.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(String employeeCategory, EmployeeDTO employeeDTO) {
        if (employeeDTO.getEmployeeType() == null || employeeDTO.getFirstName() == null || employeeDTO.getLastName() == null || employeeDTO.getEmail() == null || employeeDTO.getPhone() == null) {
            return null;
        }

        Employee employee;
        switch (employeeDTO.getEmployeeType().trim().toLowerCase()) {
            case "fulltime":
                FullTimeEmployee fullTimeEmployee = new FullTimeEmployee();
                fullTimeEmployee.setSalary(employeeDTO.getSalary());
                fullTimeEmployee.setHireDate(employeeDTO.getHireDate());
                fullTimeEmployee.setPaidLeaveDays(employeeDTO.getPaidLeaveDays());
                fullTimeEmployee.setHireDate(employeeDTO.getHireDate());
                employee = fullTimeEmployee;
                break;
            case "parttime":
                PartTimeEmployee partTimeEmployee = new PartTimeEmployee();
                partTimeEmployee.setHourlyRate(employeeDTO.getHourlyRate());
                partTimeEmployee.setMaxHoursPerWeek(employeeDTO.getMaxHoursPerWeek());
                partTimeEmployee.setScheduledHours(employeeDTO.getScheduledHours());
                partTimeEmployee.setStartDate(employeeDTO.getStartDate());
                employee = partTimeEmployee;
                break;
            default:
                employee = new Employee();
        }
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setActive(employeeDTO.isActive());
        employee.setDepartment(employeeDTO.getDepartment());
        employee.setEmail(employeeDTO.getEmail());
        employee.setPhone(employeeDTO.getPhone());
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    public boolean deleteEmployee(int id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Employee updateEmployee(int id, EmployeeDTO employeeDTO){
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isEmpty()) return null;

        Employee existingEmployee = optionalEmployee.get();

        String newType = employeeDTO.getEmployeeType().trim().toLowerCase();
        String currentType = (existingEmployee instanceof FullTimeEmployee) ? "fulltime" :
                (existingEmployee instanceof PartTimeEmployee) ? "parttime" : "";

        if (!newType.equals(currentType)) {
            employeeRepository.deleteById(id);

            return addEmployee(newType, employeeDTO);
        }

        existingEmployee.setFirstName(employeeDTO.getFirstName().trim());
        existingEmployee.setLastName(employeeDTO.getLastName());
        existingEmployee.setEmail(employeeDTO.getEmail());
        existingEmployee.setPhone(employeeDTO.getPhone());
        existingEmployee.setActive(employeeDTO.isActive());
        existingEmployee.setDepartment(employeeDTO.getDepartment());

        if (existingEmployee instanceof FullTimeEmployee){
            ((FullTimeEmployee) existingEmployee).setSalary(employeeDTO.getSalary());
            ((FullTimeEmployee) existingEmployee).setPaidLeaveDays(employeeDTO.getPaidLeaveDays());
            ((FullTimeEmployee) existingEmployee).setHireDate(employeeDTO.getHireDate());
        } else if (existingEmployee instanceof PartTimeEmployee){
            ((PartTimeEmployee) existingEmployee).setStartDate(employeeDTO.getStartDate());
            ((PartTimeEmployee) existingEmployee).setHourlyRate(employeeDTO.getHourlyRate());
            ((PartTimeEmployee) existingEmployee).setScheduledHours(employeeDTO.getScheduledHours());
            ((PartTimeEmployee) existingEmployee).setOnCallEligible(employeeDTO.isOnCallEligible());
            ((PartTimeEmployee) existingEmployee).setMaxHoursPerWeek(employeeDTO.getMaxHoursPerWeek());
        }

        return employeeRepository.save(existingEmployee);
    }


}
