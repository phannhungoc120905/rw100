package com.vti.backend;

import com.vti.entity.*;
import java.time.LocalDate;

public class Exercise1 {

    // Question 1
    //Tạo constructor cho department:
    //không có parameters
    //Có 1 parameter là nameDepartment và default id của Department = 0
    //Khởi tạo 1 Object với mỗi constructor ở trên
    public void question1() {
        Department d1 = new Department();
        Department d2 = new Department("IT");

        System.out.println(d2.getDepartmentName());
    }

    // Question 2
    //Question 2:
    //Tạo constructor cho Account:
    //Không có parameters
    //Có các parameter là id, Email, Username, FirstName, LastName (với FullName = FirstName + LastName)
    //Có các parameter là id, Email, Username, FirstName, LastName (với FullName = FirstName + LastName) và
    //Position của User, default createDate = now
    //Có các parameter là id, Email, Username, FirstName, LastName (với FullName = FirstName + LastName) và Position của User, createDate
    public void question2() {
        Position pos = new Position();

        Account a1 = new Account();

        Account a2 = new Account(1, "a@gmail.com", "user1", "Ngoc", "Phan");

        Account a3 = new Account(2, "b@gmail.com", "user2",
                "Ngoc", "Phan", pos);

        Account a4 = new Account(3, "c@gmail.com", "user3",
                "Ngoc", "Phan", pos, LocalDate.now());

        System.out.println(a2.getUserName());
    }

    // Question 3
    // Question 3:
    //Tạo constructor cho Group:
    //không có parameters
    //Có các parameter là GroupName, Creator, array Account[] accounts, CreateDate
    //Có các parameter là GroupName, Creator, array String[] usernames , CreateDate
    //Với mỗi username thì sẽ khởi tạo 1 Account (chỉ có thông tin username, các thông tin còn lại = null). Khởi tạo 1 Object với mỗi constructor ở trên
    public void question3() {
        Account creator = new Account();

        String[] usernames = {"u1", "u2", "u3"};

        Group g1 = new Group("Team A", creator, usernames, LocalDate.now());

        System.out.println(g1.getAccounts()[0].getUserName());
    }
}