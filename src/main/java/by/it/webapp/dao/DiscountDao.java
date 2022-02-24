package by.it.webapp.dao;

import by.it.webapp.domain.Discount;

import java.util.List;

public interface DiscountDao extends Dao<Discount> {

    Discount readByPercent(String percent) throws DaoException;

    List<Discount> readAll() throws DaoException;


}
