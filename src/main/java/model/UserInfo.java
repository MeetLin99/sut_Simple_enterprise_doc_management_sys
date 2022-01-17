package model;

import java.util.Date;

public class UserInfo {
    private Integer id;
public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    private String username;
public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    private String password;
public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    private String userPermissions;
public String getUserPermissions() {
        return userPermissions;
    }
    public void setUserPermissions(String userPermissions) {
        this.userPermissions = userPermissions;
    }
}