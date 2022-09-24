package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Employee;
import za.ac.cput.service.entity.EmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("restaurant/employee/")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/save")
    public ResponseEntity<Employee> save(@RequestBody  Employee gender)
    {
        System.out.println("save"+gender);
        Employee save= this.employeeService.save(gender);
        return  ResponseEntity.ok(save);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Employee> read(@PathVariable  int id) {
        Employee read=this.employeeService.read(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(read);
    }


    @DeleteMapping("/delete")
    public  ResponseEntity<Void> delete(Employee employee)
    {
        this.employeeService.delete(employee);

        return  ResponseEntity.noContent().build();
    }

    @GetMapping("All")
    public ResponseEntity<List<Employee>> getAll(){
        List<Employee> employee = this.employeeService.getAll();
        return ResponseEntity.ok(employee);
    }
}
