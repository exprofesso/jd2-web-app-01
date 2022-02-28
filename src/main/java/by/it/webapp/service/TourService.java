package by.it.webapp.service;

import by.it.webapp.domain.Tour;
import by.it.webapp.service.exception.ServiceException;

import java.util.List;

public interface TourService {
    List<Tour> findAll() throws ServiceException;

    Tour findById(Long id) throws ServiceException;

    void save(Tour tour) throws ServiceException;

    void delete(Long id) throws ServiceException;
}
