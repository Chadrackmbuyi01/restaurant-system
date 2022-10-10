package za.ac.cput.service.entity.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Owner;
import za.ac.cput.domain.Role;
import za.ac.cput.factory.OwnerFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
@Slf4j
class OwnerServiceImplTest {

    @Autowired
    protected OwnerServiceImpl service;
    Owner ownerService = OwnerFactory.createOwner(1001, "Vuyolwethu");

    @Test
    void a_save() {
        Owner ownerService1 = this.service.save(ownerService);
        log.info(ownerService1.toString());
    }

    @Test
    void b_read() {
        Optional<Owner> temp = this.service.read(ownerService.getOwnerId());
        log.info(temp.toString());
    }

    @Test
    void c_delete() {
            this.service.delete(ownerService);
    }

    @Test
    void d_getAll() {
        List<Owner> list=  this.service.getAll();
        log.info(list.toString());
    }
}