package by.it.webapp.dao;

import by.it.webapp.domain.Transfer;
import by.it.webapp.domain.TypeOfHoliday;

import java.util.List;

public interface TypeOfHolidayDao extends Dao<TypeOfHoliday>{
    List<TypeOfHoliday> readAll() throws DaoException;

    TypeOfHoliday readByType(String type) throws DaoException;
}
