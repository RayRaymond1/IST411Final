package psu.edu.Final.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import psu.edu.Final.entity.Employee;
import psu.edu.Final.service.EmployeeService;

@Controller
public class PageController {

	private EmployeeService employeeService;
	
	public PageController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }
	
    @GetMapping("/")
    public String showHome(Model theModel) {
		// get the employees from db
        List<Employee> theEmployees = employeeService.findAll();
        
        // add to the spring model
        theModel.addAttribute("employee_records", theEmployees);
        return "home";
    }
    @GetMapping("AddEmployee")
    public String getAddForm(Model theModel) {
		// create model attribute to bind form data
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee_records", theEmployee);
    	
    	
    	return "empAdd";
    }
    
    // New method to handle POST requests to /register
    @PostMapping("/register")
    public String registerEmployee(@ModelAttribute("employee") Employee theEmployee) {
        // Save the employee 
        employeeService.save(theEmployee);
        // Redirect to home
        return "redirect:/";
    }
    //Get update page and employees information
    @GetMapping("/updateEmployee")
    public String getEdit(@RequestParam Integer id,Model model) {
    	Employee emp = employeeService.findById(id);
    	model.addAttribute("emp",emp);
    	return "update";
    }
    @PostMapping("/updateEmp")
	public String updateCustomer(@ModelAttribute Employee emp){
		employeeService.updateEmployee(emp);
		return "redirect:/";
		
	}
    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam Integer id) {
    	employeeService.deleteById(id);
    	return "redirect:/";
    }
    
    

	
}
