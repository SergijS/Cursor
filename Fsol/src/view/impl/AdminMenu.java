package view.impl;

import exceptions.MenuNumberCorrectException;
import service.Response;
import service.UserService;
import view.Menu;
import view.impl.User;

import java.util.*;

public class AdminMenu implements Menu {
    private final String[] users = {"1. Add new User", "2. Get user by ID", "3. Get list of Users", "0. Exit"};

    private final UserService userService;

    private Scanner scanner;

    public AdminMenu(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void show() {
        System.out.println("\nHello Admin!");
        showUsers(users);
        System.out.print("Please create one fo numbers: ");
        scanner = new Scanner(System.in);
        while (true) {
            int choice = MenuNumberCorrectException.menuNumberCorrectInputException(3);
            switch (choice) {
                case 1:
                    addNewUser();
                    break;
                case 2:
                    getUserID(scanner);
                    break;
                case 3:
                    getListOfUsers();
                    break;
                case 0:
                    exit();
                    break;
                default:
                    showUsers(users);


            }
        }
    }
    public void exit(){System.exit(0);}

    private void addNewUser() {
        if (true) {
            System.out.print("Enter user's ID: ");
            String id = scanner.nextLine();
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            System.out.print("Enter first name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter last name: ");
            String lastName = scanner.nextLine();

            try {
                User newUser = new User(id, username, password, firstName, lastName);
                Response<User> userResponse = userService.addNewUser(newUser);
                System.out.println(userResponse.getMessage());
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
            System.out.print("Do the next choice: ");
        } else {
            showUsers(users);

        }
    }


    private void getUserID(Scanner scanner){
        List<User> findUserList = new ArrayList<>();
        System.out.print("Enter User's ID: ");
        String userId = scanner.nextLine();
        try {
            int exit = Integer.parseInt(userId);
            if(exit == 0){
                show();
            }
        }catch (NumberFormatException exception){
            }
        Response<Map<String, User>> allUsersResponse = userService.getListOfUsers();
        if(allUsersResponse.isSuccessful()){
            Collection<User> userCollection = allUsersResponse.getValue().values();
            for(User user : userCollection){
                if(user.getId().contains(userId)) {
                    findUserList.add(user);
                }
            }
            }
        if(findUserList.isEmpty()){
            System.out.println("User isn't exist!");
        } else {
            findUserList.forEach(System.out::println);
        }
        showUsers(users);
        System.out.print("Do the next choice: ");
        }

    private void getListOfUsers(){
        Response<Map<String, User>> allUsersMapResponse = userService.getListOfUsers();
        if(!allUsersMapResponse.isSuccessful()){
            System.out.println(allUsersMapResponse.getMessage());
            return;
        }
        Map<String, User> allProductMap = allUsersMapResponse.getValue();
        System.out.println("It's the list of Users: ");
        allProductMap.values().forEach(System.out::println);
        showUsers(users);
        System.out.print("Do the next choice: ");
    }

 }

