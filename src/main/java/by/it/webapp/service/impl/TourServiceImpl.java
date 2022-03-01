package by.it.webapp.service.impl;

import by.it.webapp.dao.DaoException;
import by.it.webapp.dao.TourDao;
import by.it.webapp.dao.TransferDao;
import by.it.webapp.dao.TypeOfHolidayDao;
import by.it.webapp.domain.Tour;
import by.it.webapp.domain.Transfer;
import by.it.webapp.domain.TypeOfHoliday;
import by.it.webapp.service.TourService;
import by.it.webapp.service.TypeOfHolidayService;
import by.it.webapp.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TourServiceImpl extends BaseService implements TourService {
    private TourDao tourDao;
    private TypeOfHolidayDao typeOfHolidayDao;
    private TransferDao transferDao;
    private TypeOfHolidayServiceImpl typeOfHolidayService;

    private static final Logger log = LogManager.getLogger(TourServiceImpl.class);


    public void setTourDao(TourDao tourDao) {
        this.tourDao = tourDao;
    }


    @Override
    public List<Tour> findAll() throws ServiceException {
        try {
            log.info("transition to findAll User");
            List<Tour> tourAll = new ArrayList<>();
            List<TypeOfHoliday> typeOfHolidayAll = new ArrayList<>();
            List<Transfer> transferAll = new ArrayList<>();

            log.info("read to tour database");
            tourAll.addAll(tourDao.readAll());
            log.info("read to typeOfHoliday database");
//            typeOfHolidayService.findAll();
            typeOfHolidayDao.readAll();
            System.out.println("trewtwe");
//            typeOfHolidayAll.addAll(typeOfHolidayDao.readAll());
//            log.info("read to transfer database");
//            transferAll.addAll(transferDao.readAll());


            for (Tour tour : tourAll) {
                tour.setTypeOfHoliday(typeOfHolidayAll.get(Math.toIntExact(tour.getTypeOfHoliday().getId())));
                tour.setTransfer(transferAll.get(Math.toIntExact(tour.getTransfer().getId())));
            }

            return tourAll;
        } catch (DaoException e) {
            log.error("transition to" + e.getMessage());
            throw new ServiceException(e);

        }
    }

    @Override
    public Tour findById(Long id) throws ServiceException {
        try {
            log.info("transition to findById User");
            Tour tour = tourDao.read(id);
            tour.setTypeOfHoliday(typeOfHolidayDao.read(tour.getTypeOfHoliday().getId()));
            tour.setTransfer(transferDao.read(tour.getTransfer().getId()));
            return tour;
        } catch (DaoException e) {
            log.error("Didn't find one" + e.getMessage());
            throw new ServiceException(e);
        }

    }

    @Override
    public void save(Tour tour) throws ServiceException {

    }

    @Override
    public void delete(Long id) throws ServiceException {
        try {
            log.info("Removal started");
            tourDao.delete(id);
        } catch (DaoException e) {
            log.error("delete doesn’t work maybe wrong id");
            throw new ServiceException(e);
        }
    }
}
