package homework13.elementary.dao;

import homework13.elementary.database.Database;
import homework13.elementary.entity.ClientStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientStatusDao {
    private static final String INSERT_CLIENT_STATUS = "INSERT INTO client_status (client_id, status_id) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE client_status SET status_id=? WHERE client_id=?";
    private static final String CLIENTS_STATUSES = "SELECT * FROM client_status";
    private static final String DELETE_CLIENT_STATUS = "DELETE FROM client_status WHERE client_id=?";

    //     сохранение "сущности":
    public void save(ClientStatus clientStatus) {
        try (Connection connection = Database.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(INSERT_CLIENT_STATUS)) {
            prepStatement.setInt(1, clientStatus.getClientId());
            prepStatement.setInt(2, clientStatus.getStatusId());
            prepStatement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    //     обновление "сущности":
    public void update(ClientStatus clientStatus) {
        try (Connection connection = Database.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(UPDATE)) {
            prepStatement.setInt(1, clientStatus.getStatusId());
            prepStatement.setInt(2, clientStatus.getClientId());
            prepStatement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    //     получение списка "сущностей":
    public List<ClientStatus> getAllStatuses() {
        List<ClientStatus> resultList = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(CLIENTS_STATUSES);
            while (resultSet.next()) {
                ClientStatus clientStatus = new ClientStatus();
                clientStatus.setClientId(resultSet.getInt("client_id"));
                clientStatus.setStatusId(resultSet.getInt("status_id"));
                resultList.add(clientStatus);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return resultList;
    }

    //     удаление "сущности":
    public void delete(Integer id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CLIENT_STATUS)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}