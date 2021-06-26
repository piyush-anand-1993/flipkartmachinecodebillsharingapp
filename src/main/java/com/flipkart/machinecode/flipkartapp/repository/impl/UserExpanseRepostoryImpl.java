package com.flipkart.machinecode.flipkartapp.repository.impl;

import com.flipkart.machinecode.flipkartapp.model.Bill;
import com.flipkart.machinecode.flipkartapp.model.Group;
import com.flipkart.machinecode.flipkartapp.model.User;
import com.flipkart.machinecode.flipkartapp.model.UserContributionPair;
import com.flipkart.machinecode.flipkartapp.repository.UserExpanseRepository;

import java.util.HashMap;
import java.util.Map;

public class UserExpanseRepostoryImpl implements UserExpanseRepository {

    private static Map<User, Long> userBalanceMap = new HashMap<>();

    @Override
    public void addUser(User user) {

        if(userBalanceMap.containsKey(user)) {
            System.out.println("user already avaialble. No action");
            return;
        }

        userBalanceMap.put(user, 0L);
    }

    @Override
    public Map<User, Long> getAllExpanse() {
        return userBalanceMap;
    }

    @Override
    public void addBill(Bill bill) {

        //adding expected contributions, amount will be added as negative
        for(UserContributionPair c: bill.getContributions()) {
            Long currBal = userBalanceMap.getOrDefault(c.getUser(), 0L);
            userBalanceMap.put(c.getUser(), currBal-c.getContribution());
        }

        //adding acted expenditures, amount will be added as positive
        for(UserContributionPair c: bill.getPaidBy()) {
            Long currBal = userBalanceMap.getOrDefault(c.getUser(), 0L);
            userBalanceMap.put(c.getUser(), currBal + c.getContribution());
        }
    }
}
