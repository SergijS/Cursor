package dao;

import view.impl.User;

import java.util.Map;
import java.util.Optional;

public interface UserDao {
    Optional<User> add(User user);
    Optional<User> getById(String id);

    Optional<User> getByUserName (String username);
    Map<String, User> getListOfUsers();
}
