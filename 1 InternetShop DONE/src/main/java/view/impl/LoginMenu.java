package view.impl;


import exceptions.MenuNumberCorrectInputExceptions;
import model.User;
import model.UserRole;
import service.OrderService;
import service.ProductService;
import service.Response;
import service.UserService;
import view.Menu;

import java.util.Scanner;

public class LoginMenu implements Menu {

    private final UserService userService;
    private final OrderService orderService;
    private final ProductService productService;

    private final String[] items = {"1.Login", "2.Register", "0.Exit"};

    public LoginMenu(OrderService orderService, UserService userService, ProductService productService) {
        this.userService = userService;
        this.orderService = orderService;
        this.productService = productService;
    }

    @Override
    public void show() {
        System.out.println("\nHello, this the main menu of internet shop FUTURE");

        while (true) {
        showItems(items);
        System.out.print("Please, doing your choice: ");

            int choice = MenuNumberCorrectInputExceptions.menuNumberCorrectInputExceptions(2);

            switch (choice) {
                case 1 -> loginSubMenu();
                case 2 -> registerSubMenu();
                case 0 -> exit();
            }
        }
    }
    @Override
    public void exit() {
        System.exit(0);
    }

    private void loginSubMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input login: ");
        String login = scanner.nextLine();

        System.out.print("Input password: ");
        String password = scanner.nextLine();
        Response<User> userResponse = userService.login(login, password);
        if (userResponse.isSuccessful()) {
            User user = userResponse.value();
            if (user.getUserRole() == UserRole.ADMIN) {
                new AdminMainMenu(this, userService, orderService, productService).show();
            } else {
                new UserMainMenu(this, orderService, productService, user).show();
            }
        }else{
            System.out.println(userResponse.message());
            show();
        }
    }
    private void registerSubMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input login: ");
        String login = scanner.nextLine();

        System.out.print("Input password: ");
        String password = scanner.nextLine();

        System.out.print("Repeat password: ");
        String repeatPassword = scanner.nextLine();
        if(!repeatPassword.equals(password)){
            System.out.println("You entered wrong repeat code! Pleas, check your code and try again!");
        registerSubMenu();
        } else {
            Response<User> registerResponse = userService.register(login, password);
            if(registerResponse.isSuccessful()){
                new UserMainMenu(this, orderService, productService, registerResponse.value()).show();
            } else {
                System.out.println(registerResponse.message());
                registerSubMenu();
            }
        }
    }
}