/* EmployeeServiceImpl.java
   Employee Service Impl class for Restaurant management system
   Author: Chadrack Mbuyi Kalala (219013012)
   Date: 25 August 2022
 */
package za.ac.cput.service.entity.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Employee;
import za.ac.cput.repository.EmployeeRepository;
import za.ac.cput.service.entity.EmployeeService;


import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    protected EmployeeRepository repository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }


    @Override
    public Employee save(Employee employee) {
        return this.repository.save(employee);
    }

    @Override
    public Optional<Employee> read(Integer integer) {
        return this.repository.findById(integer);
    }

    @Override
    public void delete(Employee employee) {

        this.repository.delete(employee);
    }

    @Override
    public List<Employee> getAll() {
        return this.repository.findAll();
    }
}
