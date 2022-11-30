import service.impl.UserServiceImpl;
import view.impl.AdminMenu;

public class Main {
    public static void main(String[] args) {
new AdminMenu(new UserServiceImpl()).show();

    }
}