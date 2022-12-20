package com.user.user_service.entity;

//import java.util.ArrayList;
//import java.util.List;

import javax.persistence.*;
import java.util.Set;
@Entity
public class User {

    @Id
    private String userName;
    private int psNo;
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private String userPassword;
    private String userBg;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinTable(name = "USER_ROLE",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID")
            }
    )
    private Set<Role> role;
    //private Long userId;
    //private String name;
    //private String phone;

    //List<Contact> contacts=new ArrayList<>();

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

    /*public User(Long userId, String name, String phone, List<Contact> contacts) {
        this.userId = userId;
        this.name = name;
        this.phone = phone;
        this.contacts = contacts;
    }*/

    /*public User(Long userId, String name, String phone) {
        this.userId = userId;
        this.name = name;
        this.phone = phone;
    }

    public User() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }*/

    
    
}
