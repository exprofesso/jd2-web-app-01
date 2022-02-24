package by.it.webapp.service;

import by.it.webapp.domain.Discount;
import by.it.webapp.service.exception.ServiceException;

import java.util.List;

public interface DiscountService {
    List<Discount> findAll() throws ServiceException;

    Discount findById(Long id) throws ServiceException;

    Discount findByPercent(String percent) throws ServiceException;

    void save(Discount discount) throws ServiceException;

    void delete(Long id) throws ServiceException;
}
