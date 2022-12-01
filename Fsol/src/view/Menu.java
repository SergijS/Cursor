package view;

public interface Menu {

    void show();

    default void showUsers(String[] users) {
        System.out.println("-------------");
        for (String user : users) {
            System.out.println(user);
        }
        System.out.println("-------------");
    }
}

