/* EmployeeService.java
   Employee Service class for Restaurant management system
   Author: Chadrack Mbuyi Kalala (219013012)
   Date: 24 August 2022
 */
package za.ac.cput.service.entity;

import za.ac.cput.domain.Employee;
import za.ac.cput.service.IService;

import java.util.List;

public interface EmployeeService extends IService<Employee,Integer> {
    List<Employee> getAll();

    void deleteById(int empId);
}
