package za.ac.cput.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.service.entity.EmployeeService;

@SpringBootTest
class EmployeeAPITest {

    @Autowired private EmployeeService employeeService;
    @Autowired private EmployeeAPI api;

    private Employee employee = EmployeeFactory
            .build("Keale","Chulu", "2 Beach road");

    @Test
    void save() {
        Employee saved = this.api.save(this.employee);
    }
}