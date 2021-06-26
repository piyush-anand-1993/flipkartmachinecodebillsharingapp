package com.flipkart.machinecode.flipkartapp;

import com.flipkart.machinecode.flipkartapp.exceptions.IncorrectBillException;
import com.flipkart.machinecode.flipkartapp.model.Bill;
import com.flipkart.machinecode.flipkartapp.model.Group;
import com.flipkart.machinecode.flipkartapp.model.User;
import com.flipkart.machinecode.flipkartapp.repository.impl.GroupExpanseRepositoryImpl;
import com.flipkart.machinecode.flipkartapp.repository.impl.UserExpanseRepostoryImpl;
import com.flipkart.machinecode.flipkartapp.services.ExpanseService;
import com.flipkart.machinecode.flipkartapp.services.impl.ExpanseServiceImpl;

public class ApplicationRunner {

    public static void main(String args[]) {

        ExpanseService expanseService = new ExpanseServiceImpl(new GroupExpanseRepositoryImpl()
                , new UserExpanseRepostoryImpl());

        User person1 = new User("person1", "person1@xyz.com");
        User person2 = new User("person2", "person2@xyz.com");
        User person3 = new User("person3", "person3@xyz.com");

        //expanseService.addUser(person1);
        //expanseService.addUser(person2);
        //expanseService.addUser(person3);

        Group group1 = new Group("group1", "Group 1");
        group1.addUser(person1);
        group1.addUser(person2);

        Group group2 = new Group("group2", "Group 2");
        group2.addUser(person2);
        group2.addUser(person3);

        expanseService.addGroup(group1);
        expanseService.addGroup(group2);

        //Bills

        Bill bill1 = new Bill("Bill 1", 300, group1);
        //Bill bill1 = new Bill("Bill 1", 300, null);
        bill1.addContribution(person1, 100);
        bill1.addContribution(person2, 200);
        //bill1.addContributionByShare(person1, 33);
        bill1.addPaidBy(person1, 300);


        try {
            expanseService.addBill(bill1);
        }
        catch (IncorrectBillException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(expanseService.getAllExpanse().toString());
        System.out.println("------------------------------------------");

        /**
         *
         * {
         * 	desc: Bill 2,
         * 	totalAmount: 500,
         * 	groupId: group1,
         * 	contribution: [{person: person1@xyz.com, share: 250},{person: person2@xyz.com, share: 250}],
         * 	paidBy: [{person: person2@xyz.com, share: 500}]
         * }
         */
        Bill bill2 = new Bill("Bill 2", 500, group1);
        bill2.addContribution(person1, 250);
        bill2.addContribution(person2, 250);
        bill2.addPaidBy(person2, 500);

        try {
            expanseService.addBill(bill2);
        }
        catch (IncorrectBillException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(expanseService.getAllExpanse().toString());
        System.out.println("------------------------------------------");

        /**
         *
         {
         desc: Bill 3,
         totalAmount: 100,
         groupId: group2,
         contribution: [{person: person2@xyz.com, share: 10},{person: person3@xyz.com, share: 90}],
         paidBy: [{person: person3@xyz.com, share: 100}]
         }
         */
        Bill bill3 = new Bill("Bill 3", 100, group2);
        bill3.addContribution(person2, 10);
        bill3.addContribution(person3, 90);
        bill3.addPaidBy(person3, 100);

        try {
            expanseService.addBill(bill3);
        }
        catch (IncorrectBillException ex) {
            System.out.println(ex.getMessage());
        }
        //expanseService.getAllExpansesByUsers();
        System.out.println(expanseService.getAllExpanse().toString());
        System.out.println("------------------------------------------");



        /**
         *
         {
         desc: Bill 4,
         totalAmount: 300,
         groupId: group2,
         contribution: [{person: person2@xyz.com, share: 150},{person: person3@xyz.com, share: 150}],
         paidBy: [{person: person3@xyz.com, share: 100},{person: person2@xyz.com, share: 200}]
         }
         */
        Bill bill4 = new Bill("Bill 4", 300, group2);
        bill4.addContribution(person2, 150);
        bill4.addContribution(person3, 150);
        bill4.addPaidBy(person3, 100);
        bill4.addPaidBy(person2, 200);

        try {
            expanseService.addBill(bill4);
        }
        catch (IncorrectBillException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(expanseService.getAllExpanse().toString());
        System.out.println("------------------------------------------");


        System.out.println("Expanses by each user");
        System.out.println(expanseService.getAllExpansesByUsers().toString());

    }
}
