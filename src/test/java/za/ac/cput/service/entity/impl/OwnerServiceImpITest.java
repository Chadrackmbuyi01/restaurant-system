package za.ac.cput.service.entity.impl;
/*
 *OwnerServiceImpITest.java
 * VuyolwethuKalolo
 * 214015637
 * 30-09-2022
 */
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Owner;
/*
 *OwnerServiceImpITest.java
 * VuyolwethuKalolo
 * 214015637
 * 30-09-2022
 */
import za.ac.cput.factory.OwnerFactory;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
@Slf4j
public class OwnerServiceImpITest {
    @Autowired
    protected OwnerServiceImpl service;
    Owner ownerServic1= OwnerFactory.createOwner(1234,"Vuyolwethu");
    Owner ownerService2= OwnerFactory.createOwner(5555,"Aphiwe");

    @Test
    void save() {
        Owner ownerService1=this.service.save(ownerServic1);
        Owner ownerServic2=this.service.save(ownerService2);
        log.info(ownerService1.toString());
        log.info(ownerServic2.toString());
    }

    @Test
    void read() {
        Optional<Owner> temp=this.service.read(2);
        log.info(temp.toString());
    }


    @Test
    void getAll() {
        List<Owner> list=  this.service.getAll();
        log.info(list.toString());
    }
}
