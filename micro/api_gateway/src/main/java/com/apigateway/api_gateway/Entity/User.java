package com.apigateway.api_gateway.Entity;

import java.util.Set;

public class User{
    private String userName;
    private int psNo;
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private String userPassword;
    private String userBg;
    private Set<Role> role;
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public int getPsNo() {
        return psNo;
    }
    public void setPsNo(int psNo) {
        this.psNo = psNo;
    }
    public String getUserFirstName() {
        return userFirstName;
    }
    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }
    public String getUserLastName() {
        return userLastName;
    }
    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public String getUserBg() {
        return userBg;
    }
    public void setUserBg(String userBg) {
        this.userBg = userBg;
    }
    public Set<Role> getRole() {
        return role;
    }
    public void setRole(Set<Role> role) {
        this.role = role;
    }
    
}
