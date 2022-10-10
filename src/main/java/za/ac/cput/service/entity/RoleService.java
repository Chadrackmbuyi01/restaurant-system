/* Role.java
   Role Service for Restaurant system
   Author: Marcia Zanele Bika (211054356)
 */

package za.ac.cput.service.entity;

import za.ac.cput.domain.Role;
import za.ac.cput.service.IService;
import java.util.List;

public interface RoleService extends IService<Role,Integer> {
    List<Role> getAll();

    void deleteById(int roleId);
}
