package querryExecutor;

import Models.User;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class UsersQueryExecutor {
    public void printAllUsers(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Users;");
        while (resultSet.next()) {
            System.out.print(resultSet.getInt("userid") + " ");
            System.out.print(resultSet.getString("name") + " ");
            System.out.println(resultSet.getString("address"));
        }
        statement.close();
        resultSet.close();
    }

    public Set<Integer> getAllUssersId(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        Set<Integer> userIdSet = new HashSet();
        ResultSet resultSet = statement.executeQuery("SELECT userid FROM Users;");
        while (resultSet.next()) {
            userIdSet.add(resultSet.getInt("userid"));
        }
        statement.close();
        resultSet.close();
        return userIdSet;
    }

    public void addUser(Connection connection, User user) throws SQLException {
        if (getAllUssersId(connection).contains(user.getUserid())) {
            System.out.println("Пользователь с таки ID уже существует");
        } else {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Users (userid, name, address) VALUES (?,?,?)");
            preparedStatement.setInt(1, user.getUserid());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getAddress());
            preparedStatement.execute();
            preparedStatement.close();
        }
    }
}

