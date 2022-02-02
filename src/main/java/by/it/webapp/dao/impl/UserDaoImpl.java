package by.it.webapp.dao.impl;

import by.it.webapp.dao.DaoException;
import by.it.webapp.dao.UserDao;
import by.it.webapp.domain.Discount;
import by.it.webapp.domain.Role;
import by.it.webapp.domain.User;
import by.it.webapp.pool.ConnectionPool;
import by.it.webapp.pool.ConnectionPoolException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {
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
                user.setId(resultSet.getLong("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setEmail(resultSet.getString("email"));
                discount.setPercent(resultSet.getInt("Discounts_id"));
                user.setDiscount(discount);
                role.setRoleType(resultSet.getString("Roles_id"));
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
        return null;
    }

    @Override
    public User readByLoginAndPassword(String login, String password) throws DaoException {
        return null;
    }

    @Override
    public User read(Long id) throws DaoException {
        return null;
    }

    @Override
    public Long create(User entity) throws DaoException {
        return null;
    }

    @Override
    public void update(User entity) throws DaoException {

    }

    @Override
    public void delete(Long id) throws DaoException {

    }
}
