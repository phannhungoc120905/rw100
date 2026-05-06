package com.vti.entity;

import java.time.LocalDate;

public class Account {
    private int accountId;
    private String email;
    private String userName;
    private String fullName;

    private Position position;
    private LocalDate createDate;

    // Tạo constructor cho Account:
    // Không có parameters
    public Account() {
    }

    // Có các parameter là id, Email, Username, FirstName, LastName (với FullName = FirstName + LastName)
    public Account(int id, String email, String userName,
                   String firstName, String lastName) {

        this.accountId = id;
        this.email = email;
        this.userName = userName;
        this.fullName = firstName + " " + lastName;
    }

    // Có các parameter là id, Email, Username, FirstName, LastName (với FullName = FirstName + LastName) và
    // Position của User, default createDate = now
    public Account(int id, String email, String userName,
                   String firstName, String lastName,
                   Position position) {

        this(id, email, userName, firstName, lastName);
        this.position = position;
        this.createDate = LocalDate.now();
    }

    // Có các parameter là id, Email, Username, FirstName, LastName (với FullName = FirstName + LastName) và Position của User, createDate
    public Account(int id, String email, String userName,
                   String firstName, String lastName,
                   Position position, LocalDate createDate) {

        this(id, email, userName, firstName, lastName);
        this.position = position;
        this.createDate = createDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}