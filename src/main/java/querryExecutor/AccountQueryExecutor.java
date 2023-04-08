package querryExecutor;

import Models.Account;
import Services.AccountService;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class AccountQueryExecutor {

    public Set<Integer> getAllAccountId(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        Set<Integer> accountIdSet = new HashSet();
        ResultSet resultSet = statement.executeQuery("SELECT accountid FROM Accounts;");
        while (resultSet.next()) {
            accountIdSet.add(resultSet.getInt("accountid"));
        }
        statement.close();
        resultSet.close();
        return accountIdSet;
    }

    public void addNewAccount(Connection connection) throws SQLException {
        AccountService accountService = new AccountService();
        Account account = accountService.inputAccount();
        if (getAllAccountId(connection).contains(account.getAccountid())) {
            System.out.println("Аккаунт с таким Id уже существует");
        } else {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Accounts (accountid, userid, balance, currency) VALUES (?,?,?,?)");
            preparedStatement.setInt(1, account.getAccountid());
            preparedStatement.setInt(2, account.getUserid());
            preparedStatement.setInt(3, account.getBalance());
            preparedStatement.setString(4, account.getCurrency());
            preparedStatement.execute();
            preparedStatement.close();
        }
    }
}
