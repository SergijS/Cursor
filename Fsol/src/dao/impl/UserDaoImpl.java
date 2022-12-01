package dao.impl;

import dao.UserDao;
import view.impl.User;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class UserDaoImpl implements UserDao {
    private final Map<String, User> userMap = new TreeMap<>();

    public UserDaoImpl(){
        add(new User("0001", "Master123", "123456789", "Steven", "Mihalevich"));
        add(new User("0002", "Master321", "234567891", "Mikolt", "Stnkevych"));
        add(new User("0003", "Master231", "345678912", "Lionel", "Krasoption"));
    }

    @Override
    public Optional<User> add(User user) {
        return Optional.ofNullable(userMap.put(user.getId(), user));
    }

    @Override
    public Optional<User> getById(String id) {
        return Optional.ofNullable(userMap.get(id));
    }

    @Override
    public Optional<User> getByUserName(String username) {
        return Optional.empty();
    }

    @Override
    public Map<String, User> getListOfUsers() {
        return new TreeMap<>(userMap);
    }
}
