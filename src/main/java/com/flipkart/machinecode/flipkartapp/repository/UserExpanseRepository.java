package com.flipkart.machinecode.flipkartapp.repository;

import com.flipkart.machinecode.flipkartapp.model.User;

import java.util.Map;

public interface UserExpanseRepository extends ExpanseRepository {

    public void addUser(User user);
    public Map<User, Long> getAllExpanse();
}
