/* EmployeeAPI.java
   API component class for the Employee
   Author: Chadrack Mbuyi Kalala (219013012)
   Date: 29 September 2022
 */
package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Employee;
import za.ac.cput.service.entity.EmployeeService;

@Component
public class EmployeeAPI {
    private final EmployeeService employeeService;

    @Autowired public EmployeeAPI(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee save(Employee employee){
        this.employeeService.read(employee.getEmpId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Employee ID not found"));
        return this.employeeService.save(employee);
    }
}
