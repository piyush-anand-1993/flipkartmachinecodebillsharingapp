package com.flipkart.machinecode.flipkartapp.model;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private String groupId;
    private String groupName;
    private List<User> members;

    public Group(String groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
        members = new ArrayList<>();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public void addUser(User user) {
        if(user == null) {
            System.out.println("null not acceptable user. Please try again");
            return;
        }
        members.add(user);
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId='" + groupId + '\'' +
                '}';
    }
}
