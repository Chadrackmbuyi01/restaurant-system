/* Role.java
   Service Role Impl for Restaurant system
   Author: Marcia Zanele Bika (211054356)
 */

package za.ac.cput.service.entity.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Role;
import za.ac.cput.repository.IRoleRepository;
import za.ac.cput.service.entity.RoleService;


import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    protected IRoleRepository repository;
    @Autowired
    public RoleServiceImpl(IRoleRepository repository) {
        this.repository = repository;
    }


    @Override
    public Role save(Role role) {
        return this.repository.save(role);
    }

    @Override
    public Optional<Role> read(Integer integer) {
        return this.repository.findById(integer);
    }

    @Override
    public void delete(Role role) {
        this.repository.delete(role);
    }

    @Override
    public List<Role> getAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(int roleId) {

    }
}
