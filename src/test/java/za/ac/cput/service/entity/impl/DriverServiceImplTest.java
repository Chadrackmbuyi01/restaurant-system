package za.ac.cput.service.entity.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Driver;
import za.ac.cput.entity.Employee;
import za.ac.cput.factory.DriverFactory;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
@Slf4j

class DriverServiceImplTest {
    @Autowired
    protected DriverServiceImpl service;
    Driver driverService= DriverFactory.createDriver("12B", "4Burgers",
            "Lionel Messi");
    Driver driverService2022= DriverFactory.createDriver("12B", "4Burgers",
            "Lionel Messi");

    protected Driver driver;
    protected String driverName;

    @Test
    @Order(1)
    void a_save() {
        Driver driverService2022=this.service.save(driverService);
        Driver driverService=this.service.save(driverService2022);
        log.info( driverService2022.toString());
        log.info(driverService.toString());
    }

    @Test
    @Order(2)
    void b_read() {
        Optional<Driver> read = this.service.read(this.driverName);
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.driver, read.get())
        );
    }

    @Test
    @Order(3)
    void c_delete() {
        this.service.delete(driverService);
    }

    @Test
    @Order(4)
    void d_getAll() {
        List<Driver> list=  this.service.getAll();
        log.info(list.toString());
    }
}