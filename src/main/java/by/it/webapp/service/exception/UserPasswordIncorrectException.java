package by.it.webapp.service.exception;

public class UserPasswordIncorrectException extends ServiceException{
    private Long id;

    public UserPasswordIncorrectException(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
