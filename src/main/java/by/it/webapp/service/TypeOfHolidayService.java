package by.it.webapp.service;

import by.it.webapp.domain.TypeOfHoliday;
import by.it.webapp.service.exception.ServiceException;

import java.util.List;

public interface TypeOfHolidayService {
    List<TypeOfHoliday> findAll() throws ServiceException;

    TypeOfHoliday findById(Long id) throws ServiceException;

    TypeOfHoliday findByType(String type) throws ServiceException;

    void save(TypeOfHoliday typeOfHoliday) throws ServiceException;

    void delete(Long id) throws ServiceException;
}
