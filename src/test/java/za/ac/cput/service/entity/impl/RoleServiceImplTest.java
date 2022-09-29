/* Role.java
   Role service impl Test for Restaurant system
   Author: Marcia Zanele Bika (211054356)
 */

package za.ac.cput.service.entity.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Role;
import za.ac.cput.factory.RoleFactory;



import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
@Slf4j

class RoleServiceImplTest {
    @Autowired
    protected RoleServiceImpl service;
    Role roleService= RoleFactory.createRole(215,"Marcia");
    Role roleService1=RoleFactory.createRole(332,"Bika");
    @Test
    void save() {
        Role roleService1=this.service.save(roleService);
        Role roleService=this.service.save(roleService1);
        log.info(roleService1.toString());
        log.info(roleService.toString());
    }

    @Test
    void read() {
        Optional<Role> temp=this.service.read(2);
        log.info(temp.toString());
    }

    @Test
    void delete() {
        this.service.delete(roleService);
    }

    @Test
    void getAll() {
        List<Role> list=  this.service.getAll();
        log.info(list.toString());
    }
}