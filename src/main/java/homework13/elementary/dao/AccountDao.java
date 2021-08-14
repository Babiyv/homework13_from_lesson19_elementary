package homework13.elementary.dao;

import homework13.elementary.database.Database;
import homework13.elementary.entity.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDao {
    // dao (data access object) - общее название с точки зрения паттерна проектирования для сервисов взаимодействия с сущностями из баз данных;
    private static final String INSERT_ACCOUNT = "INSERT INTO accounts (client_id, number, value) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE accounts SET client_id=?, number=?, value=? WHERE id=?";
    private static final String ACCOUNTS = "SELECT * FROM accounts";
    private static final String DELETE_ACCOUNT = "DELETE FROM accounts WHERE id=?";
    private static final String ACCOUNT_BY_ID = "SELECT * FROM accounts WHERE id=?";

    public List<Account> findAllAccounts() {
        List<Account> resultList = new ArrayList<>();
        // вариант написания "try with resources":
        try (Connection connection = Database.getConnection(); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(ACCOUNTS);
            while (resultSet.next()) { // .next - если есть следующее значение, то "тру"
                Account account = new Account();
                account.setId(resultSet.getInt("id"));
                account.setClientId(resultSet.getInt("client_id"));
                account.setNumber(resultSet.getString("number"));
                account.setValue(resultSet.getDouble("value"));
                resultList.add(account);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return resultList;
    }

    public Account findById(Integer id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(ACCOUNT_BY_ID)) {
            prepStatement.setInt(1, id);
            ResultSet resultSet = prepStatement.executeQuery();
            while (resultSet.next()) {
                Account account = new Account();
                account.setId(resultSet.getInt("id"));
                account.setClientId(resultSet.getInt("client_id"));
                account.setNumber(resultSet.getString("number"));
                account.setValue(resultSet.getDouble("value"));
                return account;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public void save (Account account) {
        try (Connection connection = Database.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(INSERT_ACCOUNT)) { // PreparedStatement - интерфейс можно передать параметр, в отличии от стейтмент обычного
            prepStatement.setInt(1, account.getClientId());
            prepStatement.setString(2, account.getNumber());
            prepStatement.setDouble(3, account.getValue());
            prepStatement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }


    public void delete(Integer id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(DELETE_ACCOUNT)) {
            prepStatement.setInt(1, id);
            prepStatement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void update(Account account) {
        try (Connection connection = Database.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(UPDATE)) {
            prepStatement.setInt(1, account.getClientId());
            prepStatement.setString(2, account.getNumber());
            prepStatement.setDouble(3, account.getValue());
            prepStatement.setInt(4, account.getId());
            prepStatement.execute(); // - команда выполнить;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
