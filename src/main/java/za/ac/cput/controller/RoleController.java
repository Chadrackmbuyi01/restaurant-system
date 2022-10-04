/* Role.java
   Controller Role for Restaurant system
   Author: Marcia Zanele Bika (211054356)
 */

package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Role;
import za.ac.cput.service.entity.RoleService;

import java.util.List;

@RestController
@RequestMapping("restaurant/role/")
public class RoleController {

    private final RoleService roleService;

    @Autowired public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/save")
    public ResponseEntity<Role> save(@RequestBody  Role role)
    {
        System.out.println("save"+role);
        Role save= this.roleService.save(role);
        return  ResponseEntity.ok(save);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Role> read(@PathVariable  int roleId) {
        Role read=this.roleService.read(roleId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(read);
    }


    @DeleteMapping("/delete")
    public  ResponseEntity<Void> delete(Role role)
    {
        this.roleService.delete(role);

        return  ResponseEntity.noContent().build();
    }

    @GetMapping("All")
    public ResponseEntity<List<Role>> getAll(){
        List<Role> role = this.roleService.getAll();
        return ResponseEntity.ok(role);
    }
}
