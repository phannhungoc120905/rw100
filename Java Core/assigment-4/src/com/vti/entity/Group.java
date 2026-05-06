package com.vti.entity;

import java.time.LocalDate;

public class Group {
    private int groupId;
    private String groupName;

    private Account creator;
    private Account[] accounts;
    private LocalDate createDate;

    // Tạo constructor cho Group:
    // không có parameters
    public Group() {
    }

    // Có các parameter là GroupName, Creator, array Account[] accounts, CreateDate
    public Group(String groupName, Account creator,
                 Account[] accounts, LocalDate createDate) {

        this.groupName = groupName;
        this.creator = creator;
        this.accounts = accounts;
        this.createDate = createDate;
    }

    // Có các parameter là GroupName, Creator, array String[] usernames , CreateDate
    // Với mỗi username thì sẽ khởi tạo 1 Account (chỉ có thông tin username, các thông tin còn lại = null). Khởi tạo 1 Object với mỗi constructor ở trên
    public Group(String groupName, Account creator,
                 String[] usernames, LocalDate createDate) {

        this.groupName = groupName;
        this.creator = creator;
        this.createDate = createDate;

        this.accounts = new Account[usernames.length];

        for (int i = 0; i < usernames.length; i++) {
            Account acc = new Account();
            acc.setUserName(usernames[i]); // chỉ set username
            this.accounts[i] = acc;
        }
    }

    public Account[] getAccounts() {
        return accounts;
    }
}