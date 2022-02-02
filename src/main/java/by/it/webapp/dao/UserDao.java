package by.it.webapp.dao;

import by.it.webapp.domain.User;

import java.util.List;

public interface UserDao extends Dao<User> {
    List<User> readAll() throws DaoException;

    boolean isUserInitiatesTransfers(Long id) throws DaoException;

    User readByLogin(String login) throws DaoException;

    User readByLoginAndPassword(String login, String password) throws DaoException;
}
