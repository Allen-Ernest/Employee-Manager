package com.allen.employee_manager.controller;

import com.allen.employee_manager.dto.EmployeeDTO;
import com.allen.employee_manager.model.Employee;
import com.allen.employee_manager.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class NavigationController {
    private final EmployeeService employeeService;

    public NavigationController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    
    @GetMapping("/")
    public String getHomePage(){
        return "home";
    }

    @GetMapping("/employees")
    public String listEmployees(Model model){
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employees";
    }

    @GetMapping("/add")
    public String getAddForm(Model model){
        model.addAttribute("employee", new EmployeeDTO());
        return "add-employee";
    }
}
