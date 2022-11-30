package view.impl;

import java.util.Objects;

public class User {
    private String id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;

    public User(String id, String userName,
                String password, String firstName,
                String lastName) {
        setId(id);
        setUserName(userName);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
    }



    public String getId() {
        return id;
    }
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(String id) {
        if (id.length() != 4) {
            throw new IllegalArgumentException("Id will be in format 0000");
        }
        if (!id.matches("([A-Za-z0-9_])\\w+")) {
            throw new IllegalArgumentException("Id can consist only numbers");
        }
        this.id = id;
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
    public void setFirstName(String firstName) {
        if (firstName.length() > 15 || firstName.length() < 5) {
            throw new IllegalArgumentException("First name can not be smaller than 7 symbols");
        }
        if (!firstName.matches("([A-Za-z0-9_])\\w+")) {
            throw new IllegalArgumentException("First name can consist only letters, numbers, symbols");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() > 15 || lastName.length() < 7) {
            throw new IllegalArgumentException("Last name can not be smaller than 7 symbols");
        }
        if (!lastName.matches("([A-Za-z0-9_])\\w+")) {
            throw new IllegalArgumentException("Last name can consist only letters, numbers, symbols");
        }
        this.lastName = lastName;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}