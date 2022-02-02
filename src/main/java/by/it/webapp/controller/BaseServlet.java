package by.it.webapp.controller;


import by.it.webapp.service.Transaction;

abstract public class BaseServlet {

    private Transaction transaction;

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

}
