package com.patikadev.Model;

import com.patikadev.Helper.DBConnecter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Course {
    private int id;
    private int user_id;
    private int patika_id;
    private String name;
    private String language;
    private Patika patika;
    private User educator;

    public Course(int id, int user_id,int patika_id,String name,String language) {
        this.id = id;
        this.user_id=user_id;
        this.patika_id=patika_id;
        this.name = name;
        this.language=language;
        this.patika=Patika.getFetch(patika_id);
        this.educator=User.getFetch(user_id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Patika getPatika() {
        return patika;
    }

    public void setPatika(Patika patika) {
        this.patika = patika;
    }

    public User getEducator() {
        return educator;
    }

    public void setEducator(User educator) {
        this.educator = educator;
    }
    public static ArrayList<Course> getList(){
        ArrayList<Course> courseList=new ArrayList<>();
        Course obj;
        try {
            Statement st= DBConnecter.getInstance().createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM course");
            while (rs.next()){
                int id=rs.getInt("id");
                int user_id=rs.getInt("user_id");
                int patika_id=rs.getInt("patika_id");
                String name=rs.getString("name");
                String language=rs.getString("language");
                obj=new Course(id,user_id,patika_id,name,language);
                courseList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return courseList;
    }
    public static Course getFetch(int id){
        Course obj=null;
        String sql="SELECT * FROM course WHERE id=? ";
        try {
            PreparedStatement pr=DBConnecter.getInstance().prepareStatement(sql);
            pr.setInt(1,id);
            ResultSet rs=pr.executeQuery();
            if (rs.next()){
                obj=new Course(rs.getInt("id"),rs.getInt("user_id"),rs.getInt("patika_id"),rs.getString("name"),rs.getString("language"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }
    public static Course getFetchByName(String name){
        Course obj=null;
        String sql="SELECT * FROM course WHERE name=? ";
        try {
            PreparedStatement pr=DBConnecter.getInstance().prepareStatement(sql);
            pr.setString(1,name);
            ResultSet rs=pr.executeQuery();
            if (rs.next()){
                obj=new Course(rs.getInt("id"),rs.getInt("user_id"),rs.getInt("patika_id"),rs.getString("name"),rs.getString("language"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }

    public static ArrayList<Course> getListByUser(int user_id){
        ArrayList<Course> courseList=new ArrayList<>();
        Course obj;
        try {
            Statement st= DBConnecter.getInstance().createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM course WHERE user_id= "+user_id);
            while (rs.next()){
                int id=rs.getInt("id");
                int userID=rs.getInt("user_id");
                int patika_id=rs.getInt("patika_id");
                String name=rs.getString("name");
                String language=rs.getString("language");
                obj=new Course(id,userID,patika_id,name,language);
                courseList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return courseList;
    }

    public static ArrayList<Course> getListByPatikaID(int patika_id){
        ArrayList<Course> courseList=new ArrayList<>();
        Course obj;
        try {
            Statement st= DBConnecter.getInstance().createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM course WHERE patika_id= "+patika_id);
            while (rs.next()){
                int id=rs.getInt("id");
                int userID=rs.getInt("user_id");
                int patikaID=rs.getInt("patika_id");
                String name=rs.getString("name");
                String language=rs.getString("language");
                obj=new Course(id,userID,patikaID,name,language);
                courseList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return courseList;
    }

    public static boolean add(int user_id,int patika_id,String name,String language){
        String query="INSERT INTO course (user_id, patika_id,name,language ) VALUES (?,?,?,?) ";
        boolean key=true;
        try {
            PreparedStatement pr=DBConnecter.getInstance().prepareStatement(query);
            pr.setInt(1,user_id);
            pr.setInt(2,patika_id);
            pr.setString(3,name);
            pr.setString(4,language);
            key=pr.executeUpdate()!=-1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return key;
    }
    public static boolean delete(int id){
        boolean key=true;
        String query="DELETE FROM course WHERE id=?";
        try {
            PreparedStatement pr=DBConnecter.getInstance().prepareStatement(query);
            pr.setInt(1,id);
            key=pr.executeUpdate() !=-1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return key;
    }
}
