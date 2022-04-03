package by.it.webapp.domain;

public enum Role {

    CUSTOMER("покупатель"),
    MANAGER("менеджер"),
    ADMINISTRATOR("администратор");

    private final String name;

    Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return Long.valueOf(ordinal());
    }


//    private int roleId;
//    private String roleType;
//
//
//    public Role() {
//    }
//
//    public Role(int roleId, String roleType) {
//        this.roleId = roleId;
//        this.roleType = roleType;
//    }
//
//    public Role(int roleId) {
//        this.roleId = roleId;
//        if (roleId == 1) {
//            this.roleType = "Customer";
//        } else if (roleId == 2) {
//            this.roleType = "Manager";
//        } else if (roleId == 3) {
//            this.roleType = "Admin";
//        } else {
//            this.roleType = "Customer";
//        }
//    }
//
//
//    public int getRoleId() {
//        return roleId;
//    }
//
//    public void setRoleId(int roleId) {
//        this.roleId = roleId;
//    }
//
//    public String getRoleType() {
//        return roleType;
//    }
//
//    public void setRoleType(String roleType) {
//        this.roleType = roleType;
//    }
//
//    @Override
//    public String toString() {
//        return "" + roleId;
//    }
}
