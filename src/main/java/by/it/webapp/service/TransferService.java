package by.it.webapp.service;

import by.it.webapp.domain.Transfer;
import by.it.webapp.service.exception.ServiceException;

import java.util.List;

public interface TransferService {

    List<Transfer> findAll() throws ServiceException;

    Transfer findById(Long id) throws ServiceException;

    Transfer findByType(String type) throws ServiceException;

    void save(Transfer transfer) throws ServiceException;

    void delete(Long id) throws ServiceException;


}
