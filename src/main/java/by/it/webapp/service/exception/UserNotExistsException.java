package by.it.webapp.service.exception;

public class UserNotExistsException extends ServiceException {
    Long id;

    public UserNotExistsException(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
