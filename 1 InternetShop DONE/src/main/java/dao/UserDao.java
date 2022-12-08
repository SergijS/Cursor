package dao;

import model.User;

import java.util.Optional;

public interface UserDao {
    Optional<User> add(User user);

    Optional<User> getByUsername(String userName);

    Optional<User> update(String userName, User newUser);

    Optional<User> delete(String userName);
}