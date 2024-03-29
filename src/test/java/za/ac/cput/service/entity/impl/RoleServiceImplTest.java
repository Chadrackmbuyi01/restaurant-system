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
import za.ac.cput.domain.Role;
import za.ac.cput.factory.RoleFactory;



import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
@Slf4j

class RoleServiceImplTest {
    @Autowired
    protected RoleServiceImpl service;
    Role roleService= RoleFactory.createRole(215,"Marcia");

    @Test
    void save() {
        Role roleService1 = this.service.save(roleService);
        log.info(roleService1.toString());

    }

    @Test
    void read() {
        Optional<Role> temp=this.service.read(roleService.getRoleId());
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