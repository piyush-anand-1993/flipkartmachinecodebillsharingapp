package com.flipkart.machinecode.flipkartapp.model;

public class UserContributionPair {

    private User user;
    private long contribution;

    public UserContributionPair(User user, long contribution) {
        this.user = user;
        this.contribution = contribution;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getContribution() {
        return contribution;
    }

    public void setContribution(long contribution) {
        this.contribution = contribution;
    }
}
