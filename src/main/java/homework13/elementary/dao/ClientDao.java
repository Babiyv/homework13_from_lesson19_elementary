package homework13.elementary.dao;

import homework13.elementary.database.Database;
import homework13.elementary.entity.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {
    // dao (data access object) - общее название с точки зрения паттерна проектирования для сервисов взаимодействия с сущностями из баз данных;
    private static final String INSERT_CLIENT = "INSERT INTO clients (name, email, phone, about, age) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE clients SET name=?, email=?, phone=?, about=?, age=? WHERE id=?";
    private static final String CLIENTS = "SELECT * FROM clients";
    private static final String DELETE_CLIENT = "DELETE FROM clients WHERE id=?";
    private static final String CLIENT_BY_ID = "SELECT * FROM clients WHERE id=?";


    //    метод добавленные для избежания дублированивания кода (даже сама идея ругалась):
    private Client createClient(ResultSet resultSet) throws SQLException {
        Client client = new Client();
        client.setId(resultSet.getInt("id"));
        client.setName(resultSet.getString("name"));
        client.setEmail(resultSet.getString("email"));
        client.setPhone(resultSet.getLong("phone"));
        client.setAbout(resultSet.getString("about"));
        return client;
    }

    public List<Client> findAllClients() {
        List<Client> resultList = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(CLIENTS);
            while (resultSet.next()) {
                resultList.add(createClient(resultSet));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return resultList;
    }

    public Client getById(Integer id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(CLIENT_BY_ID)) {
            prepStatement.setInt(1, id);
            ResultSet resultSet = prepStatement.executeQuery();
            while (resultSet.next()) {
                createClient(resultSet);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    //     сохранение "сущности":
    public void save (Client client) {
        try (Connection connection = Database.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(INSERT_CLIENT)) { // PreparedStatement - интерфейс можно передать параметр, в отличии от стейтмент обычного
            prepStatement.setString(1, client.getName());
            prepStatement.setString(2, client.getEmail());
            prepStatement.setLong(3, client.getPhone());
            prepStatement.setString(4, client.getAbout());
            prepStatement.setInt(5, client.getAge());
            prepStatement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    //     обновление "сущности":
    public void update(Client client) {
        try (Connection connection = Database.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(UPDATE)) {
            prepStatement.setString(1, client.getName());
            prepStatement.setString(2, client.getEmail());
            prepStatement.setLong(3, client.getPhone());
            prepStatement.setString(4, client.getAbout());
            prepStatement.setInt(5, client.getAge());
            prepStatement.setInt(6, client.getId());
            prepStatement.execute(); // - команда выполнить;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    //     удаление "сущности":
    public void delete(Integer id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CLIENT)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }


}
