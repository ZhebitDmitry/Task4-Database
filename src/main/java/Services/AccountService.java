package Services;

import Models.Account;

import java.util.Scanner;

public class AccountService {
    public Account inputAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введит Id аккаунта");
        int accountId = sc.nextInt();
        System.out.println("Введите Id пользователя");
        int userId = sc.nextInt();
        sc.nextLine();
        System.out.println("Введите валюту");
        String currency = sc.nextLine();
        Account account = new Account(accountId, userId, 0, currency);
        return account;
    }
}
