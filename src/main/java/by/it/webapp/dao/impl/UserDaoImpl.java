package by.it.webapp.dao.impl;

import by.it.webapp.dao.DaoException;
import by.it.webapp.dao.UserDao;
import by.it.webapp.domain.Discount;
import by.it.webapp.domain.Role;
import by.it.webapp.domain.User;
import by.it.webapp.pool.ConnectionPool;
import by.it.webapp.pool.ConnectionPoolException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {
    private static final String USERID = "id";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String EMAIL = "email";
    private static final String DISCOUNTSID = "Discounts_id";
    private static final String ROLESID = "Roles_id";


    @Override
    public List<User> readAll() throws DaoException {

        final String findAllQuery = "SELECT * FROM users ORDER BY id";
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(findAllQuery)) {
            List<User> usersAll = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User();
                Role role = new Role();
                Discount discount = new Discount();
                user.setId(resultSet.getLong(USERID));
                user.setLogin(resultSet.getString(LOGIN));
                user.setPassword(resultSet.getString(PASSWORD));
                user.setName(resultSet.getString(NAME));
                user.setSurname(resultSet.getString(SURNAME));
                user.setEmail(resultSet.getString(EMAIL));
                discount.setPercent(resultSet.getInt(DISCOUNTSID));
                user.setDiscount(discount);
                role.setRoleType(resultSet.getString(ROLESID));
                user.setRole(role);
                usersAll.add(user);
            }
            return usersAll;

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException();
        }
    }

    @Override
    public boolean isUserInitiatesTransfers(Long id) throws DaoException {
        return false;
    }

    @Override
    public User readByLogin(String login) throws DaoException {
        final String read = "SELECT  * FROM users WHERE login = ?";

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(read)) {
            statement.setString(1, login);
            try (ResultSet resultSet = statement.executeQuery()) {
                User user = null;
                if (resultSet.next()) {
                    user = new User();
                    user.setId(resultSet.getLong(USERID));
                    user.setLogin(resultSet.getString(LOGIN));
                    user.setPassword(resultSet.getString(PASSWORD));
                    user.setName(resultSet.getString(NAME));
                    user.setSurname(resultSet.getString(SURNAME));
                    user.setEmail(resultSet.getString(EMAIL));
                    Role role = new Role();
                    Discount discount = new Discount();
                    discount.setPercent(Integer.parseInt(resultSet.getString(DISCOUNTSID)));
                    user.setDiscount(discount);
                    role.setRoleType(resultSet.getString(ROLESID));
                    user.setRole(role);
                }
                return user;
            }

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public User readByLoginAndPassword(String login, String password) throws DaoException {
        final String read = "SELECT  * FROM users WHERE login = ? and password = ?";

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(read)) {
            statement.setString(1, login);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                User user = null;
                if (resultSet.next()) {
                    user = new User();
                    user.setId(resultSet.getLong(USERID));
                    user.setLogin(resultSet.getString(LOGIN));
                    user.setPassword(resultSet.getString(PASSWORD));
                    user.setName(resultSet.getString(NAME));
                    user.setSurname(resultSet.getString(SURNAME));
                    user.setEmail(resultSet.getString(EMAIL));
                    Role role = new Role();
                    Discount discount = new Discount();
                    discount.setPercent(Integer.parseInt(resultSet.getString(DISCOUNTSID)));
                    user.setDiscount(discount);
                    role.setRoleType(resultSet.getString(ROLESID));
                    user.setRole(role);
                }
                return user;
            }

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        }
    }


    @Override
    public User read(Long id) throws DaoException {
        final String read = "SELECT  * FROM users WHERE id = ?";

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(read)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                User user = null;
                if (resultSet.next()) {
                    user = new User();
                    user.setId(id);
                    user.setLogin(resultSet.getString(LOGIN));
                    user.setPassword(resultSet.getString(PASSWORD));
                    user.setName(resultSet.getString(NAME));
                    user.setSurname(resultSet.getString(SURNAME));
                    user.setEmail(resultSet.getString(EMAIL));
                    Role role = new Role();
                    Discount discount = new Discount();
                    discount.setPercent(Integer.parseInt(resultSet.getString(DISCOUNTSID)));
                    user.setDiscount(discount);
                    role.setRoleType(resultSet.getString(ROLESID));
                    user.setRole(role);
                }
                return user;
            }

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Long create(User user) throws DaoException {
        final String create = "INSERT INTO users (login, password, name, surname, email, Discounts_id, Roles_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(create, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, user.getSurname());
            statement.setString(5, user.getEmail());
            statement.setInt(6, user.getDiscount().getPercent());
            statement.setInt(7, user.getRole().getRoleId());
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
    public void update(User user) throws DaoException {
        final String updateQuery = "UPDATE users SET login = ?, password = ?, name = ?, surname = ?, email = ?, Discounts_id = ?, Roles_id = ? WHERE id = ?";


        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(updateQuery)
        ) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, user.getSurname());
            statement.setString(5, user.getEmail());
            statement.setInt(6, user.getDiscount().getPercent());
            statement.setInt(7, user.getRole().getRoleId());
            statement.setLong(8, user.getId());
            statement.executeUpdate();

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void delete(Long id) throws DaoException {
        final String delete = "DELETE FROM users WHERE id = ?";

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(delete)) {
            statement.setLong(1, id);
            statement.executeUpdate();

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        }
    }
}
