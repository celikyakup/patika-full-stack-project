package com.patikadev.Model;

import com.patikadev.Helper.DBConnecter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.zip.CheckedOutputStream;

public class Patika {
    private int id;
    private String name;

    public Patika(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static ArrayList<Patika> getList(){
        ArrayList<Patika> patikaList=new ArrayList<>();
        Patika obj;
        try {
            Statement st= DBConnecter.getInstance().createStatement();
            ResultSet rs=st.executeQuery("select * from patika");
            while (rs.next()){
                obj=new Patika(rs.getInt("id"),rs.getString("name"));
                patikaList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return patikaList;
    }
    public static boolean add(String name){
        String query="INSERT INTO patika (name) VALUES (?)";
        boolean key=true;
        try {
            PreparedStatement pr=DBConnecter.getInstance().prepareStatement(query);
            pr.setString(1,name);
            key=pr.executeUpdate()!=-1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return key;
    }
    public static boolean update(int id,String name){
        String query="UPDATE patika SET name = ? WHERE id=?";
        boolean key=true;
        try {
            PreparedStatement pr=DBConnecter.getInstance().prepareStatement(query);
            pr.setString(1,name);
            pr.setInt(2,id);
            key=pr.executeUpdate()!=-1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return key;
    }
    public static Patika getFetch(int id){
        Patika obj=null;
        String sql="SELECT * FROM patika WHERE id=? ";
        try {
            PreparedStatement pr=DBConnecter.getInstance().prepareStatement(sql);
            pr.setInt(1,id);
            ResultSet rs=pr.executeQuery();
            if (rs.next()){
               obj=new Patika(rs.getInt("id"),rs.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }
    public static Patika getFetch(String  name){
        Patika obj=null;
        String sql="SELECT * FROM patika WHERE name=? ";
        try {
            PreparedStatement pr=DBConnecter.getInstance().prepareStatement(sql);
            pr.setString(1,name);
            ResultSet rs=pr.executeQuery();
            if (rs.next()){
                obj=new Patika(rs.getInt("id"),rs.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }
    public static boolean delete(int id){
        String query="DELETE FROM patika WHERE id=?";
        boolean key=true;
        ArrayList<Course> courseList= Course.getList();
        for (Course obj:Course.getList()){
            if (obj.getPatika().getId()==id){
                Course.delete(obj.getId());
            }
        }
        try {
            PreparedStatement pr=DBConnecter.getInstance().prepareStatement(query);
            pr.setInt(1,id);
            key= pr.executeUpdate()!=-1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return key;
    }
}
