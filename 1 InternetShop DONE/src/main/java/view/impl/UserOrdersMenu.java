package view.impl;

import exceptions.MenuNumberCorrectInputExceptions;
import model.Order;
import service.OrderService;
import service.Response;
import view.Menu;

import java.util.Map;

public class UserOrdersMenu implements Menu {
    private final String[] items = {"1. Orders list", "0. Back to previous menu"};
    private final UserMainMenu userMainMenu;
    private final OrderService orderService;

    public UserOrdersMenu(UserMainMenu userMainMenu,
                          OrderService orderService) {
        this.userMainMenu = userMainMenu;
        this.orderService = orderService;
    }

    public void show(){
        System.out.println("You are in user orders menu");
        while(true){
            showItems(items);
            System.out.print("Please do your choice: ");
            int choice = MenuNumberCorrectInputExceptions.menuNumberCorrectInputExceptions(1);
            switch (choice){
                case 0 -> userMainMenu.show();
                case 1 ->showOrderList();
            }
        }
    }
    private void showOrderList(){
        Response<Map<Integer, Order>> ordersByUserResponse = orderService.getOrdersByUser(userMainMenu.getCurrentUser());
        if(!ordersByUserResponse.isSuccessful()){
            System.out.println(ordersByUserResponse.message());
            return;
        }
        System.out.print("Order list: ");
        ordersByUserResponse.value().values().forEach(System.out::println);
    }
    public void exit(){
        System.exit(0);
    }
}