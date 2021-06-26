package com.flipkart.machinecode.flipkartapp.services;

import com.flipkart.machinecode.flipkartapp.model.Bill;
import com.flipkart.machinecode.flipkartapp.model.Group;
import com.flipkart.machinecode.flipkartapp.model.User;

import java.util.Map;

public interface ExpanseService {

    public void addUser(User user);

    public void addGroup(Group group);

    public Map<User, Long> getGroupBalance(Group group);

    public void addBill(Bill bill);

    public Map<Group, Map<User, Long>> getAllExpanse();

    public Map<User, Long> getAllExpansesByUsers();

}
