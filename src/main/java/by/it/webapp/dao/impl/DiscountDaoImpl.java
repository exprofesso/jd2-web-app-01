package by.it.webapp.dao.impl;

import by.it.webapp.dao.DaoException;
import by.it.webapp.dao.DiscountDao;
import by.it.webapp.domain.Discount;
import by.it.webapp.pool.ConnectionPool;
import by.it.webapp.pool.ConnectionPoolException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DiscountDaoImpl extends BaseDaoImpl implements DiscountDao {

    private static final String ID = "id";
    private static final String PERCENT = "percent";


    @Override
    public Discount readByPercent(String percent) throws DaoException {
        final String read = "SELECT  * FROM Discounts WHERE percent = ?";

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(read)) {
            statement.setString(1, percent);
            try (ResultSet resultSet = statement.executeQuery()) {
                Discount discount = null;
                if (resultSet.next()) {
                    discount = new Discount();
                    discount.setId(resultSet.getLong(ID));
                    discount.setPercent(Integer.parseInt(resultSet.getString(PERCENT)));
                }
                return discount;
            }

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Discount> readAll() throws DaoException {
        final String findAllQuery = "SELECT * FROM Discounts ORDER BY id";
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(findAllQuery)) {
            List<Discount> discountAll = new ArrayList<>();
            while (resultSet.next()) {
                Discount discount = new Discount();
                discount.setId(resultSet.getLong(ID));
                discount.setPercent(Integer.parseInt(resultSet.getString(PERCENT)));
                discountAll.add(discount);
            }
            return discountAll;

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException();
        }
    }

    @Override
    public Discount read(Long id) throws DaoException {
        final String read = "SELECT  * FROM Discounts WHERE id = ?";

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(read)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                Discount discount = null;
                if (resultSet.next()) {
                    discount = new Discount();
                    discount.setId(id);
                    discount.setPercent(Integer.parseInt(resultSet.getString(PERCENT)));
                }
                return discount;
            }

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Long create(Discount discount) throws DaoException {
        final String create = "INSERT INTO Discounts (percent) VALUES (?)";

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(create, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, String.valueOf(discount.getPercent()));
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
    public void update(Discount discount) throws DaoException {
        final String updateQuery = "UPDATE Discounts SET percent = ? WHERE id = ?";

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(updateQuery)
        ) {
            statement.setString(1, String.valueOf(discount.getPercent()));
            statement.setLong(2, discount.getId());
            statement.executeUpdate();

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void delete(Long id) throws DaoException {
        final String delete = "DELETE FROM Discounts WHERE id = ?";

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(delete)) {
            statement.setLong(1, id);
            statement.executeUpdate();

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        }
    }
}
