package by.it.webapp.service;

import by.it.webapp.dao.DaoException;
import by.it.webapp.domain.User;
import by.it.webapp.service.exception.ServiceException;

import java.util.List;

public interface UserService {
    List<User> findAll() throws ServiceException;

    User findById(Long id) throws ServiceException;

    User findByLogin(String login) throws ServiceException;

    User findByLoginAndPassword(String login, String password) throws ServiceException;


    void save(User user) throws ServiceException;

    void changePassword(Long userId, String oldPassword, String newPassword) throws ServiceException;

    boolean canDelete(Long id) throws ServiceException;

    void delete(Long id) throws ServiceException;

    User readByLoginAndPassword(String login, String password) throws ServiceException;

}
