package by.it.webapp.dao.impl;

import by.it.webapp.dao.DaoException;
import by.it.webapp.dao.TypeOfHolidayDao;
import by.it.webapp.domain.Transfer;
import by.it.webapp.domain.TypeOfHoliday;
import by.it.webapp.pool.ConnectionPool;
import by.it.webapp.pool.ConnectionPoolException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TypeOfHolidayDaoImpl extends BaseDaoImpl implements TypeOfHolidayDao {
    private static final String HOLIDAYID = "id";
    private static final String TYPEOFHOLIDAY = "Type";


    @Override
    public List<TypeOfHoliday> readAll() throws DaoException {
        final String findAllQuery = "SELECT * FROM Types_of_holidays ORDER BY id";
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(findAllQuery)) {
            List<TypeOfHoliday> typeOfHolidayAll = new ArrayList<>();
            while (resultSet.next()) {
                TypeOfHoliday typeOfHoliday = new TypeOfHoliday();
                typeOfHoliday.setId(resultSet.getLong(HOLIDAYID));
                typeOfHoliday.setTypeOfHoliday(resultSet.getString(TYPEOFHOLIDAY));
                typeOfHolidayAll.add(typeOfHoliday);
            }
            return typeOfHolidayAll;

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException();
        }    }

    @Override
    public TypeOfHoliday readByType(String type) throws DaoException {
        final String read = "SELECT  * FROM Types_of_holidays WHERE Type = ?";

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(read)) {
            statement.setString(1, type);
            try (ResultSet resultSet = statement.executeQuery()) {
                TypeOfHoliday typeOfHoliday = null;
                if (resultSet.next()) {
                    typeOfHoliday = new TypeOfHoliday();
                    typeOfHoliday.setId(resultSet.getLong(HOLIDAYID));
                    typeOfHoliday.setTypeOfHoliday(resultSet.getString(TYPEOFHOLIDAY));
                }
                return typeOfHoliday;
            }

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public TypeOfHoliday read(Long id) throws DaoException {
        final String read = "SELECT  * FROM Types_of_holidays WHERE id = ?";

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(read)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                TypeOfHoliday typeOfHoliday = null;
                if (resultSet.next()) {
                    typeOfHoliday = new TypeOfHoliday();
                    typeOfHoliday.setId(id);
                    typeOfHoliday.setTypeOfHoliday(resultSet.getString(TYPEOFHOLIDAY));
                }
                return typeOfHoliday;
            }

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Long create(TypeOfHoliday typeOfHoliday) throws DaoException {
        final String create = "INSERT INTO Types_of_holidays (Type) VALUES (?)";

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(create, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, typeOfHoliday.getTypeOfHoliday());
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
    public void update(TypeOfHoliday typeOfHoliday) throws DaoException {
        final String updateQuery = "UPDATE Types_of_holidays SET Type = ? WHERE id = ?";

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(updateQuery)
        ) {
            statement.setString(1, typeOfHoliday.getTypeOfHoliday());
            statement.setLong(2, typeOfHoliday.getId());
            statement.executeUpdate();

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void delete(Long id) throws DaoException {
        final String delete = "DELETE FROM Types_of_holidays WHERE id = ?";

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(delete)) {
            statement.setLong(1, id);
            statement.executeUpdate();

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        }
    }
}
