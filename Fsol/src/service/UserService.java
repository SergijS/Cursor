package service;

import view.impl.User;

import java.util.Map;

public interface UserService {
    Response<User> getUserId(String id);
    Response<Map<String, User>> getListOfUsers();
    Response<User> addNewUser(User user);
}
