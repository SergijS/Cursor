package view.impl;

import exceptions.MenuNumberCorrectInputExceptions;
import model.Order;
import model.OrderStatus;
import model.Product;
import service.OrderService;
import service.ProductService;
import service.Response;
import view.Menu;

import java.util.*;

public class UserProductMenu implements Menu {
    private final String[] items = {"1. Show product list", "2. Search product", "3. Add products to order ", "4. Confirm order", "0. Back previous menu"};
    private final String[] checkoutItems = {"1.Remove product", "2.Change product count", "3.Confirm order", "0.Back"};
    private final UserMainMenu userMainMenu;
    private final OrderService orderService;
    private final ProductService productService;

    public UserProductMenu(UserMainMenu userMainMenu,
                           OrderService orderService,
                           ProductService productService) {
        this.userMainMenu = userMainMenu;
        this.orderService = orderService;
        this.productService = productService;
    }

    @Override
    public void show() {
        System.out.println("It's the Product menu");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showItems(items);
            System.out.print("Please do your choice: ");
            int choice = MenuNumberCorrectInputExceptions.menuNumberCorrectInputExceptions(4);
            switch (choice) {
                case 0 -> userMainMenu.show();
                case 1 -> showProductList();
                case 2 -> searchProduct(scanner);
                case 3 -> addProductToOrder(scanner);
                case 4 -> orderCheckout(scanner);
            }
        }
    }

    @Override
    public void exit() {
        System.exit(0);
    }

    private void showProductList() {
        Response<Map<String, Product>> allProductMapResponse = productService.getAllProducts();
        if (!allProductMapResponse.isSuccessful()) {
            System.out.println(allProductMapResponse.message());
            return;
        }
        Map<String, Product> allProductMap = allProductMapResponse.value();
        System.out.println("\nIt's the Product list: \n");
        allProductMap.values().forEach(System.out::println);
    }

    private void searchProduct(Scanner scanner) {
        List<Product> findProductList = new ArrayList<>();
        System.out.print("Enter product name:");
        String productName = scanner.nextLine();
        try {
            int exit = Integer.parseInt(productName);
            if (exit == 0) {
                show();
            }
        } catch (NumberFormatException exception) {
        }
        Response<Map<String, Product>> allProductResponse = productService.getAllProducts();
        if (allProductResponse.isSuccessful()) {
            Collection<Product> productCollection = allProductResponse.value().values();
            for (Product product : productCollection) {
                if (product.getName().toLowerCase(Locale.ROOT).contains(productName.toLowerCase(Locale.ROOT))) {
                    findProductList.add(product);
                }
            }
        }
        if (findProductList.isEmpty()) {
            System.out.println("Product does not exist");
            System.out.println("In our shop you can by only CARS!");
        } else {
            findProductList.forEach(System.out::println);
        }
    }

    private void addProductToOrder(Scanner scanner) {
        Response<Map<Integer, Order>> orderByUserResponse = orderService.getOrdersByUser(userMainMenu.getCurrentUser());
        Collection<Order> orderCollection = orderByUserResponse.value().values();
        int orderId = orderCollection.stream()
                .filter(order -> order.getOrderStatus() == OrderStatus.IN_PROGRESS)
                .findFirst()
                .orElseGet(() -> orderService.addOrder(new Order(userMainMenu.getCurrentUser())).value())
                .getId();
        while (true) {
            showProductList();
            System.out.print("Exit - 0");
            System.out.print("\nEnter product name: ");
            String productName = scanner.nextLine();
            try {
                int exit = Integer.parseInt(productName);
                if (exit == 0) {
                    show();
                }
            } catch (NumberFormatException e) {
            }
            Response<Product> productResponse = productService.getProduct(productName);
            if (!productResponse.isSuccessful()) {
                System.out.println(productResponse.message());
                continue;
            }
            Product product = productResponse.value();
            System.out.print("Enter quantity for " + product.getName() + ":");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            Response<Order> addProductResponse = orderService
                    .addProductToOrder(orderId, productResponse.value(), quantity);
            System.out.println(addProductResponse.message());
            if (addProductResponse.isSuccessful()) {
                break;
            }
        }
    }

    private void orderCheckout(Scanner scanner) {
        Response<Map<Integer, Order>> orderByUsersResponse = orderService.getOrdersByUser(userMainMenu.getCurrentUser());
        Collection<Order> orderCollection = orderByUsersResponse.value().values();
        Optional<Order> inProgressOptional = orderCollection.stream()
                .filter(order -> order.getOrderStatus() == OrderStatus.IN_PROGRESS)
                .findFirst();
        if (inProgressOptional.isEmpty()) {
            System.out.println("You have no active orders. New order creates in 'Add product to order");
            return;
        }
        Order order = inProgressOptional.get();
        if (order.getProductMap().isEmpty()) {
            System.out.println("Your order is empty!");
            return;
        }
        while (true) {
            System.out.println(order);
            showItems(checkoutItems);
            int choice = MenuNumberCorrectInputExceptions.menuNumberCorrectInputExceptions(3);
            switch (choice) {
                case 0:
                    show();
                    break;
                case 1: {
                    while (true) {
                        List<Product> productList = new ArrayList<>(order.getProductMap().keySet());
                        for (int i = 0; i < productList.size(); i++) {
                            System.out.println((i + 1) + "." + productList.get(i));
                        }
                        System.out.print("Choose product number to remove: ");
                        int productNumber = scanner.nextInt();
                        scanner.nextLine();
                        Product productToRemove;
                        try {
                            productToRemove = productList.get(productNumber - 1);
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Incorrect product number!");
                            continue;
                        }
                        Response<Order> orderResponse = orderService.removeProductFormOrder(order.getId(), productToRemove);
                        System.out.println(orderResponse.message());
                        if (orderResponse.isSuccessful()) {
                            order = orderResponse.value();
                        }
                        break;
                    }
                }
                case 2: {
                    while (true) {
                        Map<Product, Integer> productMap = order.getProductMap();
                        List<Product> productList = new ArrayList<>(productMap.keySet());
                        int counter = 0;
                        for (Map.Entry<Product, Integer> productCountEntry : productMap.entrySet()) {
                            System.out.println(++counter + "." + productCountEntry.getKey() + "-" + productCountEntry.getValue());
                        }
                        System.out.print("Choose product number for change count: ");
                        int productNumber = scanner.nextInt();
                        scanner.nextLine();
                        Product productToChangeCount;
                        try {
                            productToChangeCount = productList.get(productNumber - 1);
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Incorrect product Number!");
                            continue;
                        }
                        System.out.print("Enter new quantity: ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine();
                        Response<Order> orderResponse = orderService.addProductToOrder(order.getId(), productToChangeCount, quantity);
                        System.out.println(orderResponse.message());
                        if (orderResponse.isSuccessful()) {
                            order = orderResponse.value();
                        }
                        break;
                    }
                }
                case 3: {
                    Response<Order> changeOrderStatusResponse = orderService.changeOrderStatus(order.getId(), OrderStatus.AWAITING_CONFIRMATION);
                    System.out.println(changeOrderStatusResponse.message());
                    if (changeOrderStatusResponse.isSuccessful()) ;
                    {
                        order = changeOrderStatusResponse.value();
                        show();
                    }
                }
            }
        }
    }
}