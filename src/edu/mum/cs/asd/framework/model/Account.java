package edu.mum.cs.asd.framework.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import edu.mum.cs.asd.framework.model.functor.IFunctor;
import edu.mum.cs.asd.framework.model.predicate.IPredicate;

public abstract class Account implements IAccount {

    protected String accountNumber;
    protected double balance;
    protected double interestRate;
    protected Customer customer;
    protected List<Entry> entries;


    private void init() {
        accountNumber = UUID.randomUUID().toString();
        balance = 0;
        entries = new ArrayList<>();
    }

    public Account(Customer customer) {
        this.customer = customer;
        init();
    }

    @Override
    public void addEntry(Entry entry) {
        entries.add(entry);
    }

    public double getCustomerBalance() {
        return balance;
    }

    @Override
    public void notifyCustomer(String message) {
        if (message != null) {
            customer.sendEmail(message);
        }
    }

    @Override
    public double getInterestValue() {
        return getInterestRate() * balance;
    }

    @Override
    public <R> R searchEntries(IPredicate<Entry> predicate, IFunctor<Entry, R> functor) {
        for (Entry e : entries) {
            if (predicate.check(e)) {
                functor.compute(e);
            }
        }
        return functor.getValue();
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public abstract String getAcctType();

    public abstract double getInterestRate();

    public abstract String createNotification(Entry e);

    public abstract String generateMonthlyReport();

    @Override
    public abstract void withdraw(Entry e);

    @Override
    public abstract void deposit(Entry e);

    @Override
    public abstract IPredicate<Account> getInsufficientPredicate();

    @Override
    public String toString() {
        return getAcctType();
    }

    @Override
    public String getVal(String key) {
        switch (key) {
            case "accountNumbr":
                return accountNumber;
            case "balance":
                return "" + balance;
            case "interestRate":
                return "" + interestRate;
            default:
                return null;
        }
    }

}
