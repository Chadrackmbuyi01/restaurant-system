/* Role.java
   IRoleRepository for Restaurant system
   Author: Marcia Zanele Bika (211054356)
 */

package za.ac.cput.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Role;

import java.util.Set;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer> {

}