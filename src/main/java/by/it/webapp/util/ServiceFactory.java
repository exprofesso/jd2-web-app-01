package by.it.webapp.util;

import by.it.webapp.dao.*;
import by.it.webapp.dao.impl.*;
import by.it.webapp.domain.User;
import by.it.webapp.pool.ConnectionPool;
import by.it.webapp.pool.ConnectionPoolException;
import by.it.webapp.service.*;
import by.it.webapp.service.impl.*;

import java.sql.Connection;

public final class ServiceFactory implements AutoCloseable {
    private Connection connection;

    private static final ServiceFactory instance = new ServiceFactory();
    private final UserServiceImpl userService = new UserServiceImpl();
    private final TransferServiceImpl transferService = new TransferServiceImpl();
    private final TypeOfHolidayServiceImpl typeOfHolidayService = new TypeOfHolidayServiceImpl();
    private final DiscountServiceImpl discountService = new DiscountServiceImpl();
    private final TourServiceImpl tourService = new TourServiceImpl();

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

    public TransferService getTransferService() throws FactoryException {
        transferService.setTransaction(getTransaction());
        transferService.setTransferDao(getTransferDao());
        return transferService;
    }

    public TypeOfHolidayService getTypeOfHolidayService() throws FactoryException {
        typeOfHolidayService.setTransaction(getTransaction());
        typeOfHolidayService.setTypeOfHolidayDao(getTypeOfHolidayDao());
        return typeOfHolidayService;
    }

    public DiscountService getDiscountService() throws FactoryException {
        discountService.setTransaction(getTransaction());
        discountService.setDiscountDao(getDiscountDao());
        return discountService;
    }

    public TourService getTourService() throws FactoryException {
        tourService.setTransaction(getTransaction());
        tourService.setTourDao(getTourDao());
        return tourService;
    }

    public UserDao getUserDao() throws FactoryException {
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.setConnection(getConnection());
        return userDao;
    }

    public TransferDao getTransferDao() throws FactoryException {
        TransferDaoImpl transferDao = new TransferDaoImpl();
        transferDao.setConnection(getConnection());
        return transferDao;
    }

    public TypeOfHolidayDao getTypeOfHolidayDao() throws FactoryException {
        TypeOfHolidayDaoImpl typeOfHolidayDao = new TypeOfHolidayDaoImpl();
        typeOfHolidayDao.setConnection(getConnection());
        return typeOfHolidayDao;
    }

    public DiscountDao getDiscountDao() throws FactoryException {
        DiscountDaoImpl discountDao = new DiscountDaoImpl();
        discountDao.setConnection(getConnection());
        return discountDao;
    }

    public TourDao getTourDao() throws FactoryException {
        TourDaoImpl tourDao = new TourDaoImpl();
        tourDao.setConnection(getConnection());
        return tourDao;
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
