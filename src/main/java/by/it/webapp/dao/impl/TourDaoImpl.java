package by.it.webapp.dao.impl;

import by.it.webapp.dao.DaoException;
import by.it.webapp.dao.TourDao;
import by.it.webapp.domain.Food;
import by.it.webapp.domain.Tour;
import by.it.webapp.domain.Transfer;
import by.it.webapp.domain.TypeOfHoliday;
import by.it.webapp.pool.ConnectionPool;
import by.it.webapp.pool.ConnectionPoolException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TourDaoImpl extends BaseDaoImpl implements TourDao {

    private static final String TOURID = "id";
    private static final String TYPESOFHOLIDAYSID = "Types_of_holidays_id";
    private static final String TOWN = "town";
    private static final String DATE = "date";
    private static final String DAYS = "days";
    private static final String FOOD = "food";
    private static final String PRICE = "price";
    private static final String TRANSFERSID = "Transfers_id";


    @Override
    public List<Tour> readAll() throws DaoException {
        final String findAllQuery = "SELECT * FROM tours ORDER BY id";
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(findAllQuery)) {
            List<Tour> tourAll = new ArrayList<>();
            while (resultSet.next()) {
                Tour tour = new Tour();
                TypeOfHoliday typeOfHoliday = new TypeOfHoliday();
                Transfer transfer = new Transfer();

                tour.setId(resultSet.getLong(TOURID));
                typeOfHoliday.setId((long) resultSet.getInt(TYPESOFHOLIDAYSID));
                tour.setTypeOfHoliday(typeOfHoliday);
                tour.setTown(resultSet.getString(TOWN));
                tour.setDate(resultSet.getDate(DATE));
                tour.setDay(resultSet.getInt(DAYS));
                tour.setFood(Food.values()[resultSet.getInt(FOOD)]);
                tour.setPrice(resultSet.getInt(PRICE));
                transfer.setId(resultSet.getLong(TRANSFERSID));
                tour.setTransfer(transfer);

                tourAll.add(tour);
            }
            return tourAll;

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException();
        }
    }

    @Override
    public Tour read(Long id) throws DaoException {
        final String read = "SELECT  * FROM tours WHERE id = ?";

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(read)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                Tour tour = null;
                if (resultSet.next()) {
                    tour = new Tour();
                    TypeOfHoliday typeOfHoliday = new TypeOfHoliday();
                    Transfer transfer = new Transfer();
                    tour.setId(id);
                    typeOfHoliday.setId(Long.valueOf(resultSet.getInt(TYPESOFHOLIDAYSID)));
                    tour.setTypeOfHoliday(typeOfHoliday);
                    tour.setTown(resultSet.getString(TOWN));
                    tour.setDate(resultSet.getDate(DATE));
                    tour.setDay(resultSet.getInt(DAYS));
                    tour.setFood(Food.values()[resultSet.getInt(FOOD)]);
                    tour.setPrice(resultSet.getInt(PRICE));
                    transfer.setId(resultSet.getLong(TRANSFERSID));
                    tour.setTransfer(transfer);
                }
                return tour;
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Long create(Tour tour) throws DaoException {
        final String create = "INSERT INTO tours (Types_of_holidays_id, town, date, days, food, price, Transfers_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(create, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, Math.toIntExact(tour.getTypeOfHoliday().getId()));
            statement.setString(2, tour.getTown());
            statement.setDate(3, tour.getDate());
            statement.setInt(4, tour.getDay());
            statement.setInt(5, tour.getFood().ordinal());
            statement.setInt(6, tour.getPrice());
            statement.setInt(7, Math.toIntExact(tour.getTransfer().getId()));

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
    public void update(Tour tour) throws DaoException {
        final String updateQuery = "UPDATE tours SET Types_of_holidays_id = ?, town = ?, date = ?, days = ?, food = ?, price = ?, Transfers_id = ? WHERE id = ?";

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(updateQuery)) {
            statement.setInt(1, Math.toIntExact(tour.getTypeOfHoliday().getId()));
            statement.setString(2, tour.getTown());
            statement.setDate(3, tour.getDate());
            statement.setInt(4, tour.getDay());
            statement.setInt(5, tour.getFood().ordinal());
            statement.setInt(6, tour.getPrice());
            statement.setInt(7, Math.toIntExact(tour.getTransfer().getId()));
            statement.setLong(8, tour.getId());
            statement.executeUpdate();

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void delete(Long id) throws DaoException {
        final String delete = "DELETE FROM tours WHERE id = ?";

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(delete)) {
            statement.setLong(1, id);
            statement.executeUpdate();

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        }
    }
}
