package by.it.webapp.service.impl;

import by.it.webapp.service.Transaction;

abstract public class BaseService {
    private Transaction transaction;

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
