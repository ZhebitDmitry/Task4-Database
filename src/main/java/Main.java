import Services.UserService;
import querryExecutor.AccountQueryExecutor;
import querryExecutor.UsersQueryExecutor;

import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String DATA_BASE_URL =
            "jdbc:sqlite:" + System.getProperty("user.dir") + "\\src\\main\\resources\\Accounts.db";

    public static void main(String[] args) throws SQLException {
        if (isDriverExists()) {
            UsersQueryExecutor usersQueryExecutor = new UsersQueryExecutor();
            AccountQueryExecutor accountQueryExecutor = new AccountQueryExecutor();
            UserService userService = new UserService();
            Connection connection = DriverManager.getConnection(DATA_BASE_URL);
            String action;
            do {
                printMenu();
                System.out.println("Введите номер операции");
                action = new Scanner(System.in).nextLine();
                switch (action) {
                    case "1":
                        usersQueryExecutor.addUser(connection, userService.inputUser());
                        break;
                    case "2":
                        accountQueryExecutor.addNewAccount(connection);
                        break;
                    case "3":
                        break;
                    case "4":
                        break;
                    case "5":
                        usersQueryExecutor.printAllUsers(connection);
                        break;
                }
            } while (!"6".equals(action));
            connection.close();
        }
    }

    public static boolean isDriverExists() {
        try {
            Class.forName("org.sqlite.JDBC");
            return true;
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver was not found");
            return false;
        }
    }

    private static void printMenu() {
        System.out.println("1 - Регистрация нового пользователя");
        System.out.println("2 - Добавление аккаунта пользователю");
//        System.out.println("3 - Пополнение существующего аккаунта");
//        System.out.println("4 - Снятие средств с существующего аккаунта");
        System.out.println("5 - Показать всех пользователей");
    }
}