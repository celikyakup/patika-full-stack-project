package com.patikadev.Model;

import com.patikadev.Helper.DBConnecter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Student extends User{

    public Student() {
    }

    public Student(int id, String name, String uname, String password, String type) {
        super(id, name, uname, password, type);
    }
}
