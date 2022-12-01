package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import service.Response;
import service.UserService;
import view.impl.User;

import java.util.Map;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }


    public Response<User> addNewUser(User user) {
        Optional<User> userById = userDao.getById(user.getId());

        if (userById.isPresent()) {
            return new Response<>(userById.get(), false,
                    "User with ID " + user.getId() + " already exist.");
        }
        userDao.add(user);
        return new Response<>(user, true,
                "User " + user.getUserName() + " added to database");
    }
    public Response<User> getUserId(String id) {
        id = id.strip();
        Optional<User> user = userDao.getById(id);
        return user
                .map(value -> new Response<>(value, true, value.toString()))
                .orElse(new Response<>(null, false,
                        "User '" + id + "' does not exist."));
    }

    @Override
    public Response<Map<String, User>> getListOfUsers() {
        Map<String, User> userMap = userDao.getListOfUsers();
        if (userMap.isEmpty()) {
            return new Response<>(null, false,
                    "\"User database is empty.");
        }
        return new Response<>(userMap, true, userMap.values().toString());
    }


}
