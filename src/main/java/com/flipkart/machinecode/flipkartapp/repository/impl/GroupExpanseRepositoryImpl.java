package com.flipkart.machinecode.flipkartapp.repository.impl;

import com.flipkart.machinecode.flipkartapp.model.Bill;
import com.flipkart.machinecode.flipkartapp.model.Group;
import com.flipkart.machinecode.flipkartapp.model.User;
import com.flipkart.machinecode.flipkartapp.model.UserContributionPair;
import com.flipkart.machinecode.flipkartapp.repository.GroupExpanseRepository;

import java.util.HashMap;
import java.util.Map;

public class GroupExpanseRepositoryImpl implements GroupExpanseRepository {

    static Map<Group, Map<User, Long>> groupBalanceMap = new HashMap<>();

    @Override
    public void addGroup(Group group) {
        if(groupBalanceMap.containsKey(group)) {
            System.out.println("Group already avaialble. No action");
            return;
        }

        groupBalanceMap.put(group, new HashMap<>());
    }

    @Override
    public Map<User, Long> getGroupBalance(Group group) {
        return groupBalanceMap.get(group);
    }

    @Override
    public void addBill(Bill bill) {

        Map<User, Long> groupUsers = groupBalanceMap.get(bill.getGroup());

        //adding expected contributions, amount will be added as negative
        for(UserContributionPair c: bill.getContributions()) {
            Long currBal = groupUsers.getOrDefault(c.getUser(), 0L);
            groupUsers.put(c.getUser(), currBal-c.getContribution());
        }

        //adding acted expenditures, amount will be added as positive
        for(UserContributionPair c: bill.getPaidBy()) {
            Long currBal = groupUsers.getOrDefault(c.getUser(), 0L);
            groupUsers.put(c.getUser(), currBal + c.getContribution());
        }
    }

    @Override
    public Map<Group, Map<User, Long>> getAllExpanse() {
        return groupBalanceMap;
    }


}
