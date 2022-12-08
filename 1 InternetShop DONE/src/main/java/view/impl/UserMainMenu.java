package view.impl;


import exceptions.MenuNumberCorrectInputExceptions;
import model.User;
import service.OrderService;
import service.ProductService;
import view.Menu;

public class UserMainMenu implements Menu {
    private final String[] items = {"1. Products menu", "2. My orders", "0. Login menu"};

    private final LoginMenu loginMenu;
    private final OrderService orderService;
    private final ProductService productService;
    private final User currentUser;

    public UserMainMenu(LoginMenu loginMenu,
                        OrderService orderService,
                        ProductService productService,
                        User currentUser) {
        this.loginMenu = loginMenu;
        this.orderService = orderService;
        this.productService = productService;
        this.currentUser = currentUser;
    }

    @Override
    public void show() {
        System.out.println("\nIt's the User menu!");
        showItems(items);
        System.out.print("Please do your choice: ");
        while(true){
            int choice = MenuNumberCorrectInputExceptions.menuNumberCorrectInputExceptions(2);
            switch (choice){
                case 0 -> loginMenu.show();
                case 1 -> new UserProductMenu(this, orderService,  productService).show();
                case 2 -> new UserOrdersMenu(this, orderService).show();
            }
        }
    }

    User getCurrentUser(){
        return currentUser;
    }
    @Override
    public void exit() {

    }
}