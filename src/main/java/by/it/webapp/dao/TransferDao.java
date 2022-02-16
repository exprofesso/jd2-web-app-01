package by.it.webapp.dao;

import by.it.webapp.domain.Transfer;

import java.util.List;

public interface TransferDao extends Dao<Transfer> {
    List<Transfer> readAll() throws DaoException;

    Transfer readByType(String type) throws DaoException;
}
