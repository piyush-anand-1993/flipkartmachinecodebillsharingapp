package com.flipkart.machinecode.flipkartapp.services.impl;

import com.flipkart.machinecode.flipkartapp.exceptions.IncorrectBillException;
import com.flipkart.machinecode.flipkartapp.model.Bill;
import com.flipkart.machinecode.flipkartapp.model.Group;
import com.flipkart.machinecode.flipkartapp.model.User;
import com.flipkart.machinecode.flipkartapp.model.UserContributionPair;
import com.flipkart.machinecode.flipkartapp.repository.GroupExpanseRepository;
import com.flipkart.machinecode.flipkartapp.repository.UserExpanseRepository;
import com.flipkart.machinecode.flipkartapp.services.ExpanseService;

import java.util.Map;

public class ExpanseServiceImpl implements ExpanseService {

    //TODO:
    //should have used listener
    private GroupExpanseRepository groupExpanseRepository;
    private UserExpanseRepository userExpanseRepository;

    public ExpanseServiceImpl(GroupExpanseRepository groupExpanseRepository,
                              UserExpanseRepository userExpanseRepository) {
        this.groupExpanseRepository = groupExpanseRepository;
        this.userExpanseRepository = userExpanseRepository;
    }


    @Override
    public void addUser(User user) {
        userExpanseRepository.addUser(user);
    }

    @Override
    public void addGroup(Group group) {
        groupExpanseRepository.addGroup(group);
    }

    @Override
    public Map<User, Long> getGroupBalance(Group group) {
        return groupExpanseRepository.getGroupBalance(group);
    }

    @Override
    public void addBill(Bill bill) throws IncorrectBillException {

        //check for bill validity, total contributions & paidAmt == total amount

        long totCon = 0L;
        for(UserContributionPair c: bill.getContributions()) {
            totCon = totCon + c.getContribution();
        }

        if(totCon != bill.getTotalAmount()) {
            System.out.println("Incorrect bill. Contributions do not match total amount. Fix bill try again");
            throw new IncorrectBillException("Incorrect bill. Contributions do not match total amount. Fix bill try again");
        }

        long totPaidBy = 0L;
        for(UserContributionPair c: bill.getContributions()) {
            totPaidBy = totPaidBy + c.getContribution();
        }

        if(totPaidBy != bill.getTotalAmount()) {
            System.out.println("Incorrect bill. Total Paid By do not match total amount. Fix bill try again");
            throw new IncorrectBillException("Incorrect bill. Total Paid By do not match total amount. Fix bill try again");

        }

        groupExpanseRepository.addBill(bill);
        userExpanseRepository.addBill(bill);
    }

    @Override
    public Map<Group, Map<User, Long>> getAllExpanse() {
        return groupExpanseRepository.getAllExpanse();
    }

    @Override
    public Map<User, Long> getAllExpansesByUsers() {
        return userExpanseRepository.getAllExpanse();
    }


}
