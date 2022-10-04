/* Role.java
   IRoleRepository for Restaurant system
   Author: Marcia Zanele Bika (211054356)
 */

package za.ac.cput.repository;
import za.ac.cput.domain.Role;

import java.util.Set;

public interface IRoleRepository extends IRepository <Role, String> {
    Role read();

    boolean delete(int roleId);

    public Set<Role> getAll();
}