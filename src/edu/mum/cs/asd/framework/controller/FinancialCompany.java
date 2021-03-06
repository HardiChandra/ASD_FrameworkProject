package edu.mum.cs.asd.framework.controller;

import edu.mum.cs.asd.framework.model.*;
import edu.mum.cs.asd.framework.model.functor.IFunctor;
import edu.mum.cs.asd.framework.model.predicate.IPredicate;
import edu.mum.cs.asd.framework.view.ActionButton;
import edu.mum.cs.asd.framework.view.GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

public class FinancialCompany implements ActionListener {

    protected List<Customer> customers;
    protected FinancialProperties fProperties;
    protected GUI gui;
    
    //load data files
    private static EventHandler dbHandler;
    
    public FinancialCompany() {
        customers = new LinkedList<>();
        
    }

    public FinancialCompany(GUI gui) {
        this.gui = gui;
        initGui(gui);
    }
    
    protected void loadDbData(){
        if(dbHandler == null){
            dbHandler = new LoadDBHandler();
            dbHandler.handle(gui, this, null);
        }
    }

    private void initGui(GUI gui) {
        this.gui = gui;
        this.gui.setVisible(true);
    }

    public void setGui(GUI gui) {
        initGui(gui);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public boolean isCustomerExist(String name) {
        for (Customer customer : customers) {
            if (customer.toString().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void addAccount() {
        //
    }

    public void addEntry() {
        //
    }

    public void doAll(IFunctor functor) {
        for (Customer customer : customers) {
            functor.compute(customer);
        }
    }

    public Account searchBy(IPredicate predicate) {
        for (Customer customer : customers) {
            for (Account account : customer.getAccounts()) {
                if (predicate.check(account)) {
                    return account;
                }
            }
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        EventHandler action = ((ActionButton) e.getSource()).getHandler();
        action.handle(gui, this, e);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public Customer getCustomer(String name) {
        for (Customer customer : customers) {
            if (customer.toString().equals(name)) {
                return customer;
            }
        }
        return null;
    }
}
