package Services;

import Models.User;

import java.util.Scanner;

public class UserService {
    public User inputUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя пользователя");
        String userName = sc.nextLine();
        System.out.println("Введите Id пользователя");
        int userID = sc.nextInt();
        sc.nextLine();
        System.out.println("Введите адрес");
        String address = sc.nextLine();
        User user = new User(userID, userName, address);
        return user;
    }
}
