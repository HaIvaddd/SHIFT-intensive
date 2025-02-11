package by.koronatech.office.api.controller;

import by.koronatech.office.api.dto.CreateEmployeeDTO;
import by.koronatech.office.api.dto.EmployeeDTO;
import by.koronatech.office.core.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody CreateEmployeeDTO employeeDTO){
        return employeeService.createEmployee(employeeDTO);
    }

    @GetMapping(params = "department")
    public List<EmployeeDTO> findAllEmployeesByDepartment(@RequestParam("department") String department){
        return employeeService.findAllEmployeesByDepartment(department);
    }

    @PatchMapping({"/{id}"})
    public EmployeeDTO setManagerEmployee(@PathVariable int id){
        return employeeService.setManagerEmployee(id);
    }

    @PutMapping("/{id}")
    public EmployeeDTO updateEmployee(@PathVariable int id, @RequestBody EmployeeDTO employeeDTO){
        return employeeService.updateEmployee(id, employeeDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
    }
}
//