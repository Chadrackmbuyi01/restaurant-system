/* RoleFactory.java
   RoleFactory for Restaurant system
   Author: Marcia Zanele Bika (211054356)
   Date: 07 April 2022
 */

package za.ac.cput.factory;

import za.ac.cput.entity.Role;

public class RoleFactory {

    public static Role createRole(int roleId, String roleName){
        return new Role.Builder().setRoleId(roleId)
                .setRoleName(roleName)
                .build();

    }
}
