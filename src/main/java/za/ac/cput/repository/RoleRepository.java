/* Role.java
   Role Repository for Restaurant system
   Author: Marcia Zanele Bika (211054356)
 */

package za.ac.cput.repository;

import za.ac.cput.domain.Role;
import java.util.*;

public class RoleRepository implements IRoleRepository {
    private static RoleRepository repository = null;
    private Set<Role> employeeRoleDataBase = null;

    private RoleRepository(){
        employeeRoleDataBase = new HashSet<Role>();
    }

    public static RoleRepository getRepository(){
        if(repository == null){
            repository = new RoleRepository();
        }
        return repository;
    }

    public Role create(Role role) {
        boolean success = employeeRoleDataBase.add(role);
        if (!success)
            return null;
        return role;
    }

    @Override
    public Role read(String roleId) {

        Role role = employeeRoleDataBase.stream()
                .filter(em -> Objects.equals(em.getRoleId(),employeeRoleDataBase))
                .findAny()
                .orElse(null);
        return role;
    }

    public Role update(Role role) {
        Role Role = read();
        if (Role != null) {
            employeeRoleDataBase.remove(Role);
            employeeRoleDataBase.add(role);
            return role;
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public Role read() {
        return null;
    }

    @Override
    public boolean delete(int roleId) {
        Role roleToDelete = read();
        if (roleToDelete == null)
            return false;
        employeeRoleDataBase.remove(roleToDelete);
        return true;
    }

    @Override
    public Set<Role> getAll() {
        return employeeRoleDataBase;
    }

    public Role save(Role role) {
        return role;
    }

    public Integer findById(Integer s) {
        return s;
    }
}
