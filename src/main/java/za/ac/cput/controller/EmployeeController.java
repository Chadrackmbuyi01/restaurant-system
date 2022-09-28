package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Employee;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.service.entity.EmployeeService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("restaurant/employee/")
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("save")
    public ResponseEntity<Employee> save(@Valid @RequestBody Employee gender) {
        log.info("Save request:{}",gender);
        //System.out.println("save" +""+ gender);
        Employee em;
        try{
            em = EmployeeFactory.build(gender.getEmpFname(), gender.getEmpLname(), gender.getEmpAddress());
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        Employee save = this.employeeService.save(gender);
        return ResponseEntity.ok(save);
    }

    private Optional<Employee> getById(int empId){
        return this.employeeService.read(empId);
    }

    @GetMapping("read/{empId}")
    public ResponseEntity<Employee> read(@PathVariable int empId) {
        log.info("Read request:{}",empId);
        //System.out.println("read" +""+ id);
        Employee read = this.employeeService.read(empId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(read);
    }


    @DeleteMapping("delete/{empId}")
    public ResponseEntity<Void> delete(@PathVariable int empId) {
        log.info("delete request:{}",empId);
        //System.out.println("delete" +""+ empId);
        Optional<Employee> employee  = getById(empId);
        if (employee.isPresent()){
            this.employeeService.delete(employee.get());
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Employee>> getAll() {
        List<Employee> employee = this.employeeService.getAll();
        return ResponseEntity.ok(employee);
    }

}
