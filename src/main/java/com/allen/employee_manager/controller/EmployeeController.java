package com.allen.employee_manager.controller;

import com.allen.employee_manager.dto.EmployeeDTO;
import com.allen.employee_manager.model.Employee;
import com.allen.employee_manager.model.FullTimeEmployee;
import com.allen.employee_manager.model.PartTimeEmployee;
import com.allen.employee_manager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute EmployeeDTO employeeDTO) {
        employeeService.addEmployee(employeeDTO.getEmployeeType(), employeeDTO);
        return "redirect:/employees";
    }

    @GetMapping("/{id}")
    public String viewEmployee(@PathVariable int id, Model model) {
        Optional<Employee> optionalEmployee = employeeService.getEmployeeById(id);
        if (optionalEmployee.isEmpty()) {
            return "redirect:/employees";
        }
        Employee employee = optionalEmployee.get();
        model.addAttribute("employee", employee);
        if (employee instanceof FullTimeEmployee) {
            model.addAttribute("type", "fulltime");
        } else if (employee instanceof PartTimeEmployee) {
            model.addAttribute("type", "parttime");
        }
        return "view-employee";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Employee employee = employeeService.getEmployeeById(id).orElse(null);
        if (employee == null) return "redirect:/employees";

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployeeType(employee instanceof FullTimeEmployee ? "fulltime" : "parttime");
        employeeDTO.setFirstName(employee.getFirstName());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setPhone(employee.getPhone());
        employeeDTO.setDepartment(employee.getDepartment());
        employeeDTO.setActive(employee.isActive());

        if (employee instanceof FullTimeEmployee) {
            FullTimeEmployee fullTimeEmployee = (FullTimeEmployee) employee;
            employeeDTO.setSalary(fullTimeEmployee.getSalary());
            employeeDTO.setPaidLeaveDays(fullTimeEmployee.getPaidLeaveDays());
            employeeDTO.setHireDate(fullTimeEmployee.getHireDate());
        } else if (employee instanceof PartTimeEmployee) {
            PartTimeEmployee partTimeEmployee = (PartTimeEmployee) employee;
            employeeDTO.setHourlyRate(partTimeEmployee.getHourlyRate());
            employeeDTO.setMaxHoursPerWeek(partTimeEmployee.getMaxHoursPerWeek());
            employeeDTO.setScheduledHours(partTimeEmployee.getScheduledHours());
            employeeDTO.setOnCallEligible(partTimeEmployee.isOnCallEligible());
            employeeDTO.setStartDate(partTimeEmployee.getStartDate());
        }

        model.addAttribute("employeeDTO", employeeDTO);
        model.addAttribute("id", id);
        return "edit-employee";

    }

    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable int id, @ModelAttribute EmployeeDTO employeeDTO) {
        employeeService.updateEmployee(id, employeeDTO);
        return "redirect:/employees";
    }
}
