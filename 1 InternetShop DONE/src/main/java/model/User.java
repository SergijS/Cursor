package model;


import exceptions.UserAccessExceptions;

import java.util.Objects;

public class User {
    private String userName;
    private String password;
    private boolean isBlocked;
    private final UserRole userRole;

    public User(String userName, String password, UserRole userRole) {
        setUserName(userName);
        setPassword(password);
        this.isBlocked = false;
        this.userRole = userRole;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public boolean isBlocked() {
        return this.isBlocked;
    }

    public UserRole getUserRole() {
        return this.userRole;
    }

    public void setUserName(String userName) {
        if (userName.length() > 15 || userName.length() < 5) {
            throw new IllegalArgumentException("Username length must be in range from 5 to 15");
        }
        if (!userName.matches("([A-Za-z0-9_])\\w+")) {
            throw new IllegalArgumentException("Username can consist only letters, numbers, symbols");
        }
        this.userName = userName;
    }

    public void setPassword(String password) {
        if (password.length() > 15 || password.length() < 7) {
            throw new IllegalArgumentException("Password can not be smaller than 7 symbols");
        }
        if (!password.matches("([A-Za-z0-9_])\\w+")) {
            throw new IllegalArgumentException("Password can consist only letters, numbers, symbols");
        }
        this.password = password;
    }

    public void block() {
        if (userRole == UserRole.ADMIN) {
            throw new UserAccessExceptions("Almin can't be blocked!");
        } else {
            this.isBlocked = true;
        }
    }

    public void unblock() {
        this.isBlocked = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userName.equals(user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }

    @Override
    public String toString() {
        return "model.User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", isBlocked=" + isBlocked +
                ", userRole=" + userRole +
                '}';
    }
}