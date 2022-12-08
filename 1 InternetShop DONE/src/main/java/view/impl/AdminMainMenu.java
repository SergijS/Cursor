package view.impl;

import exceptions.MenuNumberCorrectInputExceptions;
import model.Order;
import model.OrderStatus;
import model.Product;
import model.User;
import service.OrderService;
import service.ProductService;
import service.Response;
import service.UserService;
import view.Menu;

import java.util.Collection;
import java.util.Map;
import java.util.Scanner;

public class AdminMainMenu implements Menu {
    private final String[] items = {"1. Users menu", "2. Order menu", "3. Product menu", "0. Return to Main menu"};
    private final String[] itemForUserMenu = {"1. Block User", "2. Unblock User", "0. Return"};
    private final String[] itemForOrderMenu = {"1. Change order status", "0. Return"};
    private final String[] itemForProductMenu = {"1. Edit product", "2. Add product", "3. Delete product", "0. Return"};
    private final String[] itemOrderStatus = {"1. Confirm", "2. Un confirm"};
    private final String[] itemForEditProduct = {"1. Edit price", "2. Edit quantity", "0. Return"};
    private final LoginMenu loginMenu;
    private final UserService userService;
    private final OrderService orderService;
    private final ProductService productService;
    private Scanner scanner;

    public AdminMainMenu(LoginMenu loginMenu,
                         UserService userService,
                         OrderService orderService,
                         ProductService productService) {
        this.loginMenu = loginMenu;
        this.userService = userService;
        this.orderService = orderService;
        this.productService = productService;
    }

    @Override
    public void show() {
        System.out.println("\nIt is the Main admin menu!");
        showItems(items);
        System.out.print("Please do your choice: ");
        scanner = new Scanner(System.in);
        while (true) {
            int choice = MenuNumberCorrectInputExceptions.menuNumberCorrectInputExceptions(3);
            switch (choice) {
                case 1 -> usersMenu();
                case 2 -> ordersMenu();
                case 3 -> productMenu();
                case 0 -> loginMenu.show();
            }
        }
    }

    @Override
    public void exit() {
        System.exit(0);
    }

    private void usersMenu() {
        System.out.println("\nIt's Admin menu: User menu");
        showItems(itemForUserMenu);
        System.out.print("Do one of the following: ");
        int choice = MenuNumberCorrectInputExceptions.menuNumberCorrectInputExceptions(3);
        switch (choice) {
            case 1: {
                System.out.print("Enter username for blocking: ");
                Response<User> userResponse = userService.blockUser(scanner.nextLine());
                System.out.println(userResponse.message());
                usersMenu();
                break;
            }
            case 2: {
                System.out.print("Enter username for un blocking: ");
                Response<User> userResponse = userService.unBlockUser(scanner.nextLine());
                System.out.println(userResponse.message());
                usersMenu();
                break;
            }
            case 0:
                show();
                break;

            default:
                usersMenu();
        }
    }

    private void ordersMenu() {
        System.out.println("\nIt's Admin menu: Orders menu");
        showItems(itemForOrderMenu);
        System.out.print("Do one of the following: ");
        int choice = MenuNumberCorrectInputExceptions.menuNumberCorrectInputExceptions(3);
        switch (choice) {
            case 1: {
                while (true) {
                    Response<Map<Integer, Order>> orderMapResponse = orderService.getOrdersByOrderStatus(OrderStatus.AWAITING_CONFIRMATION);
                    if (!orderMapResponse.isSuccessful()) {
                        System.out.println(orderMapResponse.message());
                        break;
                    }
                    Map<Integer, Order> orderMap = orderMapResponse.value();
                    orderMap.values().forEach(System.out::println);
                    Response<Order> orderStatusResponse;
                    while (true) {
                        System.out.print("\nChoose order id to change: ");
                        int orderId = scanner.nextInt();
                        scanner.nextLine();
                        Order order = orderMap.get(orderId);
                        if (order == null) {
                            System.out.println("Order " + orderId + " does not exist");
                            continue;
                        }
                        OrderStatus newStatus;
                        while (true) {
                            showItems(itemOrderStatus);
                            System.out.print("Choose status for order: ");
                            int orderStatusIndex = scanner.nextInt();
                            scanner.nextLine();
                            if (orderStatusIndex == 1) {
                                newStatus = OrderStatus.CONFIRMED;
                            } else if (orderStatusIndex == 2) {
                                newStatus = OrderStatus.UNCONFIRMED;
                            } else {
                                System.out.println("Wrong status number!");
                                continue;
                            }
                            break;
                        }
                        orderStatusResponse = orderService.changeOrderStatus(orderId, newStatus);
                        System.out.println(orderStatusResponse.message());
                        if (orderStatusResponse.isSuccessful()) {
                            break;
                        }
                    }
                    break;
                }
                ordersMenu();
            }
            case 0:
                show();
            default:
                ordersMenu();
        }
    }

    private void productMenu() {
        System.out.println("\nIt's Admin menu: Products menu");
        Collection<Product> productCollections = productService.getAllProducts().value().values();
        productCollections.forEach(System.out::println);
        System.out.println();
        showItems(itemForProductMenu);
        System.out.print("Do one of the following:");

        int choice = MenuNumberCorrectInputExceptions.menuNumberCorrectInputExceptions(3);
        switch (choice) {
            case 0 -> show();
            case 1 -> editProduct(productCollections);
            case 2 -> addNewProduct();
            case 3 -> deleteProduct(productCollections);
        }
    }

    private void editProduct(Collection<Product> productCollection) {
        productCollection.forEach(System.out::println);
        System.out.print("Enter product name for edit: ");
        String productName = scanner.nextLine();
        Response<Product> productResponse = productService.getProduct(productName);
        if (!productResponse.isSuccessful()) {
            System.out.println(productResponse.message());
            productMenu();
        }
        while (true) {
            System.out.println(productResponse.value());
            showItems(itemForEditProduct);
            System.out.print("Do your choice: ");
            int chosenItem = scanner.nextInt();
            scanner.nextLine();
            Response<Product> changeProductResponse;
            switch ((chosenItem)) {
                case 1: {
                    System.out.print("Enter new product price: ");
                    String newProductPrice = scanner.nextLine();
                    changeProductResponse = productService.changeProductPrice(productName, Double.parseDouble(newProductPrice));
                    System.out.println(changeProductResponse.message());
                    break;
                }
                case 2: {
                    System.out.print("Enter new product quantity: ");
                    int newProductQuantity = scanner.nextInt();
                    scanner.nextLine();
                    changeProductResponse = productService.changeProductQuantity(productName, newProductQuantity);
                    System.out.println(changeProductResponse.message());
                    break;
                }
                case 0:
                    productMenu();

            }
        }
    }

    private void addNewProduct() {
        while (true) {
            System.out.print("Enter new product name: ");
            String name = scanner.nextLine();
            System.out.print("Enter product price: ");
            int price = scanner.nextInt();
            System.out.print("Enter product quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            try {
                Product newProduct = new Product(name, price, quantity);
                Response<Product> productResponse = productService.addProduct(newProduct);
                System.out.println(productResponse.message());
                productMenu();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void deleteProduct(Collection<Product> productCollection) {
        while (true) {
            productCollection.forEach(System.out::println);
            System.out.print("Enter product name for delete: ");
            Response<Product> productDeleteResponse = productService.deleteProduct(scanner.nextLine());
            System.out.println(productDeleteResponse.message());
            productMenu();
        }
    }
}