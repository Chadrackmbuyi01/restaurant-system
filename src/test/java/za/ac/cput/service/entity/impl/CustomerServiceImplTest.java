package za.ac.cput.service.entity.impl;





import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
@Slf4j

class CustomerServiceImplTest {
    @Autowired
    protected CustomerServiceImpl service;
    Customer customerService= CustomerFactory.createcustomer("116994955","Ismail","Watara",723359631,"ismailwatara@gmail.com");
    Customer customerService1=CustomerFactory.createcustomer("9959599994","James","Earl Jones",723648520,"jamesearljones12");
//Ismail


    @Test
    void save() {
        Customer customerService1=this.service.save(customerService);
        Customer customerService=this.service.save(customerService1);
        log.info(customerService1.toString());
        log.info(customerService.toString());
    }

    @Test
    void read() {
        Optional<Customer> temp=this.service.read(2);
        log.info(temp.toString());
    }

    @Test
    void delete() {
        this.service.delete(customerService);
    }

    @Test
    void getAll() {
        List<Customer> list=  this.service.getAll();
        log.info(list.toString());
    }
}