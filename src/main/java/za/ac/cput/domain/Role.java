/* Role.java
   Entity Role for Restaurant system
   Author: Marcia Zanele Bika (211054356)
 */
package za.ac.cput.domain;

public class Role {

    private int roleId;
    private String roleName;

    //private constructor
    private Role(Builder builder){
        this.roleId = builder.roleId;
        this.roleName = builder.roleName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
    public static class Builder{
        private int roleId;
        private String roleName;

        public Builder setRoleId(int roleId) {
            this.roleId = roleId;
            return this;
        }

        public Builder setRoleName(String roleName) {
            this.roleName = roleName;
            return this;
        }

        public Builder copy(Role role){
            this.roleId = role.roleId;
            this.roleName = role.roleName;
            return this;
        }

        public Role build(){
            return new Role(this);
        }
    }
}
