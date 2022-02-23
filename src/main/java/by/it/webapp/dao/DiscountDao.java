package by.it.webapp.dao;

import by.it.webapp.domain.Discount;
import by.it.webapp.domain.User;

public interface DiscountDao extends Dao<Discount> {
    Discount readByPercent(String percent) throws DaoException;

}
