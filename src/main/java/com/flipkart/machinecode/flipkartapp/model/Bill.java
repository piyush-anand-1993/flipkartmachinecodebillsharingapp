package com.flipkart.machinecode.flipkartapp.model;

import java.util.ArrayList;
import java.util.List;

public class Bill {

    private String desc;
    private long totalAmount;
    private Group group;
    private List<UserContributionPair> contributions;
    private List<UserContributionPair> paidBy;

    public Bill(String desc, long totalAmount, Group group) {
        this.desc = desc;
        this.totalAmount = totalAmount;
        this.group = group;
        this.contributions = new ArrayList<>();
        this.paidBy = new ArrayList<>();
    }

    public void addContribution(User user, long amount) {
        contributions.add(new UserContributionPair(user, amount));
    }

    public void addContributionByShare(User user, int pct) {
        contributions.add(new UserContributionPair(user, ((pct/100) * totalAmount)));
    }

    public void addPaidBy(User user, long amount) {
        paidBy.add(new UserContributionPair(user, amount));
    }

    public String getDesc() {
        return desc;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public Group getGroup() {
        return group;
    }

    public List<UserContributionPair> getContributions() {
        return contributions;
    }

    public List<UserContributionPair> getPaidBy() {
        return paidBy;
    }
}

