package by.it.webapp.dao.impl;

import by.it.webapp.dao.DaoException;
import by.it.webapp.dao.TransferDao;
import by.it.webapp.domain.Transfer;
import by.it.webapp.pool.ConnectionPool;
import by.it.webapp.pool.ConnectionPoolException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransferDaoImpl extends BaseDaoImpl implements TransferDao {
    private static final String TRANSFERID = "id";
    private static final String TYPEOFTRANSPORT = "Type";


    @Override
    public List<Transfer> readAll() throws DaoException {
        final String findAllQuery = "SELECT * FROM Transfers ORDER BY id";
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(findAllQuery)) {
            List<Transfer> transferAll = new ArrayList<>();
            while (resultSet.next()) {
                Transfer transfer = new Transfer();
                transfer.setId(resultSet.getLong(TRANSFERID));
                transfer.setTypeOfTransport(resultSet.getString(TYPEOFTRANSPORT));
                transferAll.add(transfer);
            }
            return transferAll;

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException();
        }
    }

    @Override
    public Transfer readByType(String type) throws DaoException {
        final String read = "SELECT  * FROM Transfers WHERE login = ?";

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(read)) {
            statement.setString(1, type);
            try (ResultSet resultSet = statement.executeQuery()) {
                Transfer transfer = null;
                if (resultSet.next()) {
                    transfer = new Transfer();
                    transfer.setId(resultSet.getLong(TRANSFERID));
                    transfer.setTypeOfTransport(resultSet.getString(TYPEOFTRANSPORT));
                }
                return transfer;
            }

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Transfer read(Long id) throws DaoException {
        final String read = "SELECT  * FROM Transfers WHERE id = ?";

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(read)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                Transfer transfer = null;
                if (resultSet.next()) {
                    transfer = new Transfer();
                    transfer.setId(id);
                    transfer.setTypeOfTransport(resultSet.getString(TYPEOFTRANSPORT));
                }
                return transfer;
            }

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Long create(Transfer transfer) throws DaoException {
        final String create = "INSERT INTO Transfers (Type) VALUES (?)";

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(create, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, transfer.getTypeOfTransport());
            statement.executeUpdate();
            Long id = null;
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    id = resultSet.getLong(1);
                }
                return id;
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException();
        }
    }

    @Override
    public void update(Transfer transfer) throws DaoException {
        final String updateQuery = "UPDATE Transfers SET Type = ? WHERE id = ?";

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(updateQuery)
        ) {
            statement.setString(1, transfer.getTypeOfTransport());
            statement.setLong(2, transfer.getId());
            statement.executeUpdate();

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void delete(Long id) throws DaoException {
        final String delete = "DELETE FROM Transfers WHERE id = ?";

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(delete)) {
            statement.setLong(1, id);
            statement.executeUpdate();

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        }
    }
}
