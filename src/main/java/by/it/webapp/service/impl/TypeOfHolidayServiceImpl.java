package by.it.webapp.service.impl;

import by.it.webapp.dao.DaoException;
import by.it.webapp.dao.TypeOfHolidayDao;
import by.it.webapp.domain.TypeOfHoliday;
import by.it.webapp.service.TypeOfHolidayService;
import by.it.webapp.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class TypeOfHolidayServiceImpl extends BaseService implements TypeOfHolidayService {

    private TypeOfHolidayDao typeOfHolidayDao;
    private static final Logger log = LogManager.getLogger(TypeOfHolidayServiceImpl.class);

    public void setTypeOfHolidayDao(TypeOfHolidayDao typeOfHolidayDao) {
        this.typeOfHolidayDao = typeOfHolidayDao;
    }

    @Override
    public List<TypeOfHoliday> findAll() throws ServiceException {
        try {
            log.info("transition to findAll Type Of Holiday");
            return typeOfHolidayDao.readAll();
        } catch (DaoException e) {
            log.error("transition to" + e.getMessage());
            throw new ServiceException(e);

        }
    }

    @Override
    public TypeOfHoliday findById(Long id) throws ServiceException {
        try {
            log.info("transition to findById Type Of Holiday");
            return typeOfHolidayDao.read(id);
        } catch (DaoException e) {
            log.error("Didn't find one" + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public TypeOfHoliday findByType(String type) throws ServiceException {
        try {
            log.info("transition to findByType Type Of Holiday");
            return typeOfHolidayDao.readByType(type);
        } catch (DaoException e) {
            log.error("Didn't find one" + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public void save(TypeOfHoliday typeOfHoliday) throws ServiceException {
        log.info("Beginning to save the Type Of Holiday");
        try {
            if (typeOfHoliday.getId() != null) {
                log.info("UPDATE Type Of Holiday");
                typeOfHolidayDao.update(typeOfHoliday);
            } else {
                log.info("CREATE Type Of Holiday");
                typeOfHolidayDao.create(typeOfHoliday);
            }
        } catch (DaoException e) {
            log.error("NOT CREATE Type Of Holiday");
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(Long id) throws ServiceException {
        try {
            log.info("Removal started");
            typeOfHolidayDao.delete(id);
        } catch (DaoException e) {
            log.error("delete doesn’t work maybe wrong id");
            throw new ServiceException(e);
        }
    }
}
