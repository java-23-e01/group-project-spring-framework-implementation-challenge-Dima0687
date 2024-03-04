package de.eisnerdietmar.employeecrud.controller;

import de.eisnerdietmar.employeecrud.enitity.Employee;
import de.eisnerdietmar.employeecrud.services.EmployeeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeServiceImpl empService;


    // CREATE
    // UPDATE
    @GetMapping("/employees/save")
    public String showAddEmployeeForm( Model model ) {
        model.addAttribute("page_title", "Add employee");
        Employee employee = new Employee();
        model.addAttribute("employee", employee );
        return "add-employee-form";
    }

    @GetMapping("/employees/update/{employeeId}")
    public String showAddEmployeeForm( @PathVariable Long employeeId, Model model ) {
        model.addAttribute("page_title", "Update employee");
        Employee employee = empService.findById( employeeId );
        model.addAttribute("employee", employee );
        return "add-employee-form";
    }

    @RequestMapping(value = "/employees", method = {RequestMethod.POST, RequestMethod.PUT})
    public String saveEmployee(@ModelAttribute Employee employee ) {
        empService.save( employee );
        return "redirect:/employees";
    }

    // READ
    @GetMapping({ "/", "/employees" })
    public String showEmployees( Model model ) {
        List<Employee> employeeList = empService.findAll();
        int year = LocalDate.now().getYear();
        model.addAttribute("employees", employeeList );
        model.addAttribute("page_title", "Employees");
        model.addAttribute("actual_year", year);
        return "employees";
    }

    // DELETE
    @GetMapping("/employees/delete/{employeeId}")
    public String deleteEmployeeById(@PathVariable Long employeeId ) {
        empService.deleteById( employeeId );
        return "redirect:/employees";
    }
}
