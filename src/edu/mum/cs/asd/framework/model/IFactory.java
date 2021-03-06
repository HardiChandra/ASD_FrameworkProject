package edu.mum.cs.asd.framework.model;

import java.util.Map;

import edu.mum.cs.asd.framework.model.command.ICommand;

public interface IFactory {

    public Customer createCustomer(Map<String, String> attributes);

    public Account createAccount(Map<String, String> attributes, Customer customer);

    public Entry createEntry(Account account, double amount, TransactionTypeEnum type);

    public ICommand createTransaction(Entry entry, int type);
}
