package by.it.webapp.service.impl;

import by.it.webapp.dao.DaoException;
import by.it.webapp.dao.DiscountDao;
import by.it.webapp.domain.Discount;
import by.it.webapp.service.DiscountService;
import by.it.webapp.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class DiscountServiceImpl extends BaseService implements DiscountService {

    private static final Logger log = LogManager.getLogger(DiscountServiceImpl.class);
    private DiscountDao discountDao;

    public void setDiscountDao(DiscountDao discountDao) {
        this.discountDao = discountDao;
    }

    @Override
    public List<Discount> findAll() throws ServiceException {
        try {
            log.info("transition to findAll Discount");
            return discountDao.readAll();
        } catch (DaoException e) {
            log.error("transition to" + e.getMessage());
            throw new ServiceException(e);

        }
    }

    @Override
    public Discount findById(Long id) throws ServiceException {
        try {
            log.info("transition to findById Discount");
            return discountDao.read(id);
        } catch (DaoException e) {
            log.error("Didn't find one" + e.getMessage());
            throw new ServiceException(e);
        }    }

    @Override
    public Discount findByPercent(String percent) throws ServiceException {
        try {
            log.info("transition to readByPercent Discount");
            return discountDao.readByPercent(percent);
        } catch (DaoException e) {
            log.error("Didn't find one" + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public void save(Discount discount) throws ServiceException {
        log.info("Beginning to save the Discount");
        try {
            if (discount.getId() != null) {
                log.info("UPDATE Discount");
                discountDao.update(discount);
            } else {
                log.info("CREATE Discount");
                discountDao.create(discount);
            }
        } catch (DaoException e) {
            log.error("NOT CREATE Discount");
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(Long id) throws ServiceException {
        try {
            log.info("Removal started");
            discountDao.delete(id);
        } catch (DaoException e) {
            log.error("delete doesn’t work maybe wrong id");
            throw new ServiceException(e);
        }
    }
}
