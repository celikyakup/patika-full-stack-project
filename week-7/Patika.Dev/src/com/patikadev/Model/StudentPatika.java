package com.patikadev.Model;

import com.patikadev.Helper.DBConnecter;
import com.patikadev.Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentPatika {
    private int user_id;
    private int patika_id;



    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPatika_id() {
        return patika_id;
    }

    public void setPatika_id(int patika_id) {
        this.patika_id = patika_id;
    }


    public StudentPatika(int user_id, int patika_id){
        this.user_id=user_id;
        this.patika_id=patika_id;

    }
    public static ArrayList<StudentPatika> getListByStudendID(int user_id){
        ArrayList<StudentPatika> getList=new ArrayList<>();
        String query="SELECT * FROM student_patika WHERE user_id="+user_id;
        StudentPatika stu=null;
        try {
            Statement st=DBConnecter.getInstance().createStatement();
            ResultSet rs=st.executeQuery(query);
            while (rs.next()){
                int patika_id=rs.getInt("patika_id");
                stu=new StudentPatika(user_id,patika_id);
                getList.add(stu);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return getList;
    }
    public static boolean add(int user_id,int patika_id){
        String query="INSERT INTO student_patika (user_id,patika_id) VALUES (?,?)";
        boolean key=true;
        try {
            PreparedStatement pr=DBConnecter.getInstance().prepareStatement(query);
            pr.setInt(1,user_id);
            pr.setInt(2,patika_id);
            key=pr.executeUpdate()!=-1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (!key){
            Helper.showMsg("Error");
        }
        return key;
    }
    public static boolean isStudentPath(int user_id,int patika_id){
        String query="SELECT * FROM student_patika WHERE user_id=? AND patika_id=?";
        boolean key=true;
        try {
            PreparedStatement pr=DBConnecter.getInstance().prepareStatement(query);
            pr.setInt(1,user_id);
            pr.setInt(2,patika_id);
            key=pr.executeUpdate()!=-1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return key;
    }
}
