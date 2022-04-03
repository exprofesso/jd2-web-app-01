package by.it.webapp.dao.impl;

import by.it.webapp.dao.DaoException;
import by.it.webapp.dao.TypeOfHolidayDao;
import by.it.webapp.domain.TypeOfHoliday;
import by.it.webapp.pool.ConnectionPool;
import by.it.webapp.pool.ConnectionPoolException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TypeOfHolidayDaoImpl extends BaseDaoImpl implements TypeOfHolidayDao {
    private static final String HOLIDAYID = "id";
    private static final String TYPEOFHOLIDAY = "Type";

    private static final String READ_ALL = "SELECT * FROM Types_of_holidays ORDER BY id";
    private static final String READ_BY_TYPE = "SELECT  * FROM Types_of_holidays WHERE Type = ?";
    private static final String READ_ID = "SELECT  * FROM Types_of_holidays WHERE id = ?";
    private static final String CREATE = "INSERT INTO Types_of_holidays (Type) VALUES (?)";
    private static final String UPDATE = "UPDATE Types_of_holidays SET Type = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM Types_of_holidays WHERE id = ?";


    @Override
    public List<TypeOfHoliday> readAll() throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(READ_ALL)) {
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
        }
    }

    @Override
    public TypeOfHoliday readByType(String type) throws DaoException {

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_BY_TYPE)) {
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

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_ID)) {
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

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS)) {
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

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE)
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

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setLong(1, id);
            statement.executeUpdate();

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        }
    }
}
