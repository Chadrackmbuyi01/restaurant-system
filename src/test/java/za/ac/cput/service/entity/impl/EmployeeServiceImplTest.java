package za.ac.cput.service.entity.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Employee;
import za.ac.cput.factory.EmployeeFactory;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
@Slf4j
class EmployeeServiceImplTest {
    @Autowired
    protected EmployeeServiceImpl service;
    Employee employeeService=EmployeeFactory.createEmployee("Kalala","Serge",
            "Rose road");
    Employee employeeService1=EmployeeFactory.createEmployee("Kalala","Smith",
            "Rose road");
    @Test
    void a_save() {
        Employee employeeService1=this.service.save(employeeService);
        Employee employeeService=this.service.save(employeeService1);
        log.info(employeeService1.toString());
        log.info(employeeService.toString());
    }

    @Test
    void b_read() {
        Optional<Employee> temp=this.service.read(2);
        log.info(temp.toString());
    }

    @Test
    void d_delete() {
        this.service.delete(employeeService);

    }

    @Test
    void c_getAll() {
        List<Employee> list=  this.service.getAll();

        log.info(list.toString());
    }
}