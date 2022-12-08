package dao.impl;

import dao.UserDao;
import model.User;
import model.UserRole;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class UserDaoImpl implements UserDao {
    private final Map<String, User> userMap = new TreeMap<>();

    public UserDaoImpl() {
        this.userMap.put("Admin", new User("Admin", "Admin_main", UserRole.ADMIN));
        this.userMap.put("User1", new User("User1", "12345678", UserRole.USER));
        this.userMap.put("User2", new User("User2", "User123452", UserRole.USER));
        this.userMap.put("User3", new User("User3", "User123453", UserRole.USER));
        this.userMap.put("User4", new User("User4", "User123454", UserRole.USER));
        User blockedUser = new User("User3", "User123453", UserRole.USER);
        blockedUser.block();
        this.userMap.put("User3", blockedUser);
    }

    @Override
    public Optional<User> add(User user) {
        return Optional.ofNullable((User) this.userMap.put(user.getUserName(), user));
    }

    @Override
    public Optional<User> getByUsername(String userName) {
        return Optional.ofNullable(userMap.get(userName));
    }

    @Override
    public Optional<User> update(String userName, User newUser) {
        Optional<User> deleteUser = this.delete(userName);
        if (deleteUser.isPresent()) {
            this.add(newUser);
        }
        return deleteUser;
    }

    @Override
    public Optional<User> delete(String userName) {
        return Optional.ofNullable((User) this.userMap.remove(userName));
    }
}