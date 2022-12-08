package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import exceptions.UserAccessExceptions;
import model.User;
import model.UserRole;
import service.Response;
import service.UserService;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserDaoImpl userDao = new UserDaoImpl();

    public UserServiceImpl(){
    }

    @Override
    public Response<User> login(String username, String password) {
        Optional<User> user = userDao.getByUsername(username);
        if(user.isPresent()){
            User userObj = user.get();
            if(userObj.isBlocked()){
                return new Response<>(null, false,
                        "User is blocked");
            }
            if(userObj.getPassword().equals(password)){
                return new Response<>(userObj, true,
                        userObj.toString());
            }
        }
        return new Response<>(null, false,
                "Incorrect username or password");
    }

    @Override
    public Response<User> register(String username, String password) {
       Optional<User> user = userDao.getByUsername(username);
       if(user.isEmpty()){
           User newUser;
           try {
               newUser = new User(username, password, UserRole.USER);
           }catch (IllegalArgumentException exception){
               return new Response<>(null, false,
                       exception.getMessage());
           }
           userDao.add(newUser);
           return new Response<>(newUser, true, user.toString());
       } else {
           return new Response<>(null, false,
                   "User already exist");
       }
    }

    @Override
    public Response<User> blockUser(String username) {
        Optional<User> user = userDao.getByUsername(username);
        if(user.isPresent()){
            User userToBlock = user.get();
            try{
                userToBlock.block();
            }catch (UserAccessExceptions exception){
                return new Response<>(null, false, exception.getMessage());
            }
            userDao.update(username, userToBlock);
            return new Response<>(userToBlock, true,
                    "User " + username + " is blocked");
        } else {
            return new Response<>(null, false,
                    "User " + username + " does not exist");
        }
    }

    @Override
    public Response<User> unBlockUser(String username) {
        Optional<User> user = userDao.getByUsername(username);
        if(user.isPresent()){
            User userToBlock = user.get();
            userToBlock.unblock();
            userDao.update(username, userToBlock);
            return new Response<>(userToBlock, true,
                    "User " + username + " is unblocked");
        }else {
            return new Response<>(null, false,
                    "User " + username + " wasn't un blocked because it wasn't blocked! Be careful!");
        }
    }
}