package by.it.webapp.util;

import by.it.webapp.dao.TransferDao;
import by.it.webapp.dao.UserDao;
import by.it.webapp.dao.impl.TransferDaoImpl;
import by.it.webapp.dao.impl.UserDaoImpl;
import by.it.webapp.domain.User;
import by.it.webapp.pool.ConnectionPool;
import by.it.webapp.pool.ConnectionPoolException;
import by.it.webapp.service.Transaction;
import by.it.webapp.service.TransferService;
import by.it.webapp.service.UserService;
import by.it.webapp.service.impl.TransactionImpl;
import by.it.webapp.service.impl.TransferServiceImpl;
import by.it.webapp.service.impl.UserServiceImpl;

import java.sql.Connection;

public final class ServiceFactory implements AutoCloseable {
    private Connection connection;

    private static final ServiceFactory instance = new ServiceFactory();
    private final UserServiceImpl userService = new UserServiceImpl();
    private final TransferServiceImpl transferService = new TransferServiceImpl();
    private final User user = new User();

    public ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public UserService getUserService() throws FactoryException {
        userService.setTransaction(getTransaction());
        userService.setUserDao(getUserDao());
        return userService;
    }

    public TransferService getTransferService() throws FactoryException{
        transferService.setTransaction(getTransaction());
        transferService.settransferDao(getTransferDao());
        return transferService;
    }
    public UserDao getUserDao() throws FactoryException {
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.setConnection(getConnection());
        return userDao;
    }
    public TransferDao getTransferDao() throws FactoryException{
        TransferDaoImpl transferDao = new TransferDaoImpl();
        transferDao.setConnection(getConnection());
        return transferDao;
    }

    public Connection getConnection() throws FactoryException {
        if (connection == null) {
            try {
                connection = ConnectionPool.getInstance().getConnection();
            } catch (ConnectionPoolException e) {
                throw new FactoryException(e);
            }
        }
        return connection;
    }
    public Transaction getTransaction() throws FactoryException {
        TransactionImpl transaction = new TransactionImpl();
        transaction.setConnection(getConnection());
        return transaction;
    }

    @Override
    public void close() throws Exception {
        {
            try {
                connection.close();
                connection = null;
            } catch (Exception e) {
            }
        }
    }

    public User getUser() {
        return user;
    }

    //    UserDao getUserDao() throws FactoryException;
//
//    Connection getConnection() throws FactoryException;
//
//    UserService getUserService() throws FactoryException;
//
//    Transaction getTransaction() throws FactoryException;
}
