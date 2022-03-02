package by.it.webapp.service.impl;

import by.it.webapp.dao.DaoException;
import by.it.webapp.dao.DiscountDao;
import by.it.webapp.dao.UserDao;
import by.it.webapp.domain.User;
import by.it.webapp.service.DiscountService;
import by.it.webapp.service.UserService;
import by.it.webapp.service.exception.ServiceException;
import by.it.webapp.service.exception.UserNotExistsException;
import by.it.webapp.service.exception.UserPasswordIncorrectException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class UserServiceImpl extends BaseService implements UserService {
    private UserDao userDao;
    private String defaultPassword;
    private static final Logger log = LogManager.getLogger(UserServiceImpl.class);


    public void setDefaultPassword(String defaultPassword) {
        this.defaultPassword = defaultPassword;
    }

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
        try {
            log.info("transition to findById User");
            return userDao.read(id);
        } catch (DaoException e) {
            log.error("Didn't find one" + e.getMessage());
            throw new ServiceException(e);
        }

    }

    @Override
    public User findByLogin(String login) throws ServiceException {
        try {
            log.info("transition to findByLogin User");
            return userDao.readByLogin(login);
        } catch (DaoException e) {
            log.error("Didn't find one" + e.getMessage());
            throw new ServiceException(e);
        }

    }

    @Override
    public User findByLoginAndPassword(String login, String password) throws ServiceException {
        try {
            log.info("transition to findByLoginAndPassword User");
            return userDao.readByLoginAndPassword(login, password);
        } catch (DaoException e) {
            log.error("Didn't find one" + e.getMessage());
            throw new ServiceException(e);
        }    }

    @Override
    public void save(User user) throws ServiceException {
        log.info("Beginning to save the user");
        try {
            if (user.getPassword().length() == 0) {
                user.setPassword("1q2w3e");
                log.info("YOU DON'T HAVE A PASSWORD, YOU NEW PASSWORD " + user.getPassword());
            }

            if (user.getId() != null) {
                log.info("UPDATE USER");
                userDao.update(user);
            } else {
                log.info("CREATE USER");
                userDao.create(user);
            }
        } catch (DaoException e) {
            log.error("NOT CREATE USER");
            throw new ServiceException(e);
        }
    }

    @Override
    public void changePassword(Long userId, String oldPassword, String newPassword) throws ServiceException {
        try {
            log.info("let's change the password");
            getTransaction().start();
            User user = userDao.read(userId);
            if (user != null) {

                if (user.getPassword().equals(oldPassword)) {
                    if (newPassword == null) {
                        log.debug("There was no password");
                        newPassword = defaultPassword;
                    }
                    user.setPassword(newPassword);
                    userDao.update(user);
                } else {
                    log.error("Let's provide a good password");
                    throw new UserPasswordIncorrectException(user.getId());
                }
            } else {
                throw new UserNotExistsException(userId);
            }
            getTransaction().commit();
        } catch (DaoException e) {
            try {
                getTransaction().rollback();
            } catch (ServiceException e1) {
            }
            throw new ServiceException(e);
        } catch (ServiceException e) {
            try {
                getTransaction().rollback();
            } catch (ServiceException e1) {
            }
            throw e;
        }
    }

        @Override
        public boolean canDelete (Long id) throws ServiceException {
            return false;
        }

        @Override
        public void delete (Long id) throws ServiceException {
            try {
                log.info("Removal started");
                userDao.delete(id);
            } catch (DaoException e) {
                log.error("delete doesn’t work maybe wrong id");
                throw new ServiceException(e);
            }
        }
    }
