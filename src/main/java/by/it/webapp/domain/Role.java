package by.it.webapp.domain;

public class Role extends Entity {

    private String roleType;

    public Role() {
    }

    public Role(String roleType) {
        this.roleType = roleType;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }
}
