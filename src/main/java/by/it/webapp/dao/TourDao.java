package by.it.webapp.dao;

import by.it.webapp.domain.Tour;

import java.util.List;

public interface TourDao extends Dao<Tour> {
    List<Tour> readAll() throws DaoException;


}
