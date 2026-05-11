package com.vti.frontend;

import com.vti.backend.Exercise6;
import com.vti.backend.QLDepartment;

import java.sql.SQLException;

import static com.vti.backend.QLDepartment.findByNameAndId;

public class Program6 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Exercise6 ex = new Exercise6();

        //ex.question1();
        //ex.question2_3();
        //QLDepartment ql = new QLDepartment();
        findByNameAndId("Sale", 2);
    }
}