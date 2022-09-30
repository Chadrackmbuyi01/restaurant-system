package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.entity.Owner;
import za.ac.cput.factory.OwnerFactory;
import za.ac.cput.service.entity.impl.OwnerServiceImpl;

import java.util.List;
import java.util.Optional;
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
