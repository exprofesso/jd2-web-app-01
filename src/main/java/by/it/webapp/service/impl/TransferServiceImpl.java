package by.it.webapp.service.impl;

import by.it.webapp.dao.DaoException;
import by.it.webapp.dao.TransferDao;
import by.it.webapp.domain.Transfer;
import by.it.webapp.service.TransferService;
import by.it.webapp.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class TransferServiceImpl extends BaseService implements TransferService {

    private TransferDao transferDao;
    private static final Logger log = LogManager.getLogger(TransferServiceImpl.class);


    public void settransferDao(TransferDao transferDao) {
        this.transferDao = transferDao;
    }

    @Override
    public List<Transfer> findAll() throws ServiceException {
        try {
            log.info("transition to findAll Transfer");
            return transferDao.readAll();
        } catch (DaoException e) {
            log.error("transition to" + e.getMessage());
            throw new ServiceException(e);

        }
    }

    @Override
    public Transfer findById(Long id) throws ServiceException {
        try {
            log.info("transition to findById Transfer");
            return transferDao.read(id);
        } catch (DaoException e) {
            log.error("Didn't find one" + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public Transfer findByType(String type) throws ServiceException {
        try {
            log.info("transition to findByType Transfer");
            return transferDao.readByType(type);
        } catch (DaoException e) {
            log.error("Didn't find one" + e.getMessage());
            throw new ServiceException(e);
        }

    }

    @Override
    public void save(Transfer transfer) throws ServiceException {
        log.info("Beginning to save the Transfer");
        try {
            log.info("CREATE Transfer");
            transferDao.create(transfer);
        } catch (DaoException e) {
            log.error("NOT CREATE Transfer");
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(Long id) throws ServiceException {
        try {
            log.info("Removal started");
            transferDao.delete(id);
        } catch (DaoException e) {
            log.error("delete doesn’t work maybe wrong id");
            throw new ServiceException(e);
        }
    }
}
