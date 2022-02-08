package by.it.webapp.domain;

public class Role extends Entity {

    public Role(int roleId, String roleType) {
        this.roleId = roleId;
        this.roleType = roleType;
    }

    private int roleId;
    private String roleType;


    public Role() {
    }

    public Role(int roleId) {
        this.roleId = roleId;
        if (roleId == 1){
            this.roleType = "Customer";
        } else if (roleId == 2){
            this.roleType = "Manager";
        } else if (roleId == 3){
            this.roleType = "Admin";
        } else {
            this.roleType = "Customer";
        }
    }


    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }
}
