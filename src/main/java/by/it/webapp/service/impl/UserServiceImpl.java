package by.it.webapp.service.impl;

import by.it.webapp.dao.DaoException;
import by.it.webapp.dao.UserDao;
import by.it.webapp.domain.User;
import by.it.webapp.service.UserService;
import by.it.webapp.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class UserServiceImpl extends BaseService implements UserService {
    private UserDao userDao;
    Object object;
    private static final Logger log = LogManager.getLogger(UserServiceImpl.class);

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public List<User> findAll() throws ServiceException {
        try {
            log.info("transition to findAll User");
            return userDao.readAll();
        } catch (DaoException e) {
            log.error("transition to" + e.getMessage());
            throw new ServiceException(e);

        }
    }

    @Override
    public User findById(Long id) throws ServiceException {
        return null;
    }

    @Override
    public void save(User user) throws ServiceException {

    }

    @Override
    public void changePassword(Long userId, String oldPassword, String newPassword) throws ServiceException {

    }

    @Override
    public boolean canDelete(Long id) throws ServiceException {
        return false;
    }

    @Override
    public void delete(Long id) throws ServiceException {

    }

    @Override
    public User readByLoginAndPassword(String login, String password) throws ServiceException {
        return null;
    }
}
