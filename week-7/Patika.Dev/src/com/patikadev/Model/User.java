package com.patikadev.Model;

import com.patikadev.Helper.DBConnecter;
import com.patikadev.Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private String uname;
    private String password;
    private String type;
    public User(){}

    public User(int id, String name, String uname, String password, String type) {
        this.id = id;
        this.name = name;
        this.uname = uname;
        this.password = password;
        this.type = type;
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

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public static ArrayList<User> getList(){
        ArrayList<User> userList=new ArrayList<>();
        String query="SELECT * FROM user";
        User obj;
        try {
            Statement st= DBConnecter.getInstance().createStatement();
            ResultSet rs=st.executeQuery(query);
            while (rs.next()){
                obj=new User();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setPassword(rs.getString("password"));
                obj.setType(rs.getString("type"));
                obj.setUname(rs.getString("uname"));
                userList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }
    public static boolean add(String name, String uname,String pass,String type){
        String query="INSERT INTO user (name,uname,password,type) VALUES (?,?,?,?)";
        boolean key=true;
        User findUser=User.getFetch(uname);
        if (findUser!=null){
            Helper.showMsg("Bu kullanıcı adı daha önceden eklenmiş.");
            return false;
        }
        try {
            PreparedStatement pr=DBConnecter.getInstance().prepareStatement(query);
            pr.setString(1,name);
            pr.setString(2,uname);
            pr.setString(3,pass);
            pr.setString(4,type);
            int response=pr.executeUpdate();
            if (response==-1){
                Helper.showMsg("error");
            }
            key= response !=-1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return key;
    }
    public static User getFetch(String uname){
        User obj=null;
        String sql="SELECT * FROM user WHERE uname=?";
        try {
            PreparedStatement pr=DBConnecter.getInstance().prepareStatement(sql);
            pr.setString(1,uname);
            ResultSet rs=pr.executeQuery();
            if (rs.next()){
                obj=new User();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setPassword(rs.getString("password"));
                obj.setType(rs.getString("type"));
                obj.setUname(rs.getString("uname"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }
    public static User getFetch(int id){
        User obj=null;
        String sql="SELECT * FROM user WHERE id=?";
        try {
            PreparedStatement pr=DBConnecter.getInstance().prepareStatement(sql);
            pr.setInt(1,id);
            ResultSet rs=pr.executeQuery();
            if (rs.next()){
                obj=new User();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setPassword(rs.getString("password"));
                obj.setType(rs.getString("type"));
                obj.setUname(rs.getString("uname"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }
    public static User getFetch(String uname,String password){
        User obj=null;
        String sql="SELECT * FROM user WHERE uname=? AND password=?";
        try {
            PreparedStatement pr=DBConnecter.getInstance().prepareStatement(sql);
            pr.setString(1,uname);
            pr.setString(2,password);
            ResultSet rs=pr.executeQuery();
            if (rs.next()){
                switch (rs.getString("type")){
                    case "operator"->{
                        obj=new Operator();
                    }
                    default -> obj=new User();
                }
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setPassword(rs.getString("password"));
                obj.setType(rs.getString("type"));
                obj.setUname(rs.getString("uname"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }
    public static boolean userDelete(int id){
        boolean key=true;
        String query="DELETE FROM user WHERE id=?";
        ArrayList<Course> courseList=Course.getListByUser(id);
        ArrayList<Content> contentList=Content.getList(id);
        for (Course c:courseList){
            Course.delete(c.getId());
        }
        for (Content con:contentList){
            Content.delete(con.getContentCourse().getUser_id());
        }
        try {
            PreparedStatement pr=DBConnecter.getInstance().prepareStatement(query);
            pr.setInt(1,id);
            key=pr.executeUpdate() !=-1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return key;
    }
    public static boolean userUpdate(int id,String name,String uname,String password, String type){
        boolean key=true;
        String query="UPDATE user SET name=?,uname=?,password=?,type=? WHERE id=?";
        User findUser=User.getFetch(uname);
        if (findUser!=null && findUser.getId()!=id){
            Helper.showMsg("Bu kullanıcı adı daha önceden eklenmiş.");
            return false;
        }
        try {
            PreparedStatement pr=DBConnecter.getInstance().prepareStatement(query);
            pr.setString(1,name);
            pr.setString(2,uname);
            pr.setString(3,password);
            pr.setString(4,type);
            pr.setInt(5,id);
            key=pr.executeUpdate() !=-1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return key;
    }
    public static ArrayList<User> searchUserList(String query){
        ArrayList<User> userList=new ArrayList<>();
        User obj;
        try {
            Statement st= DBConnecter.getInstance().createStatement();
            ResultSet rs=st.executeQuery(query);
            while (rs.next()){
                obj=new User();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setPassword(rs.getString("password"));
                obj.setType(rs.getString("type"));
                obj.setUname(rs.getString("uname"));
                userList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }
    public static String searchQuery(String name,String uname,String type){
        String query="SELECT * FROM user WHERE uname LIKE '%{{uname}}%' and name LIKE '%{{name}}%'";
        query=query.replace("{{uname}}",uname);
        query=query.replace("{{name}}",name);
        if (!type.isEmpty()){
            query+="AND type='{{type}}'";
            query=query.replace("{{type}}",type);
        }
        return query;
    }
    public static int getPatikaID(String patikaName){
        String query = "SELECT id FROM patika WHERE name = ?";
        int id = 0;
        try {
            PreparedStatement pr = DBConnecter.getInstance().prepareStatement(query);
            pr.setString(1,patikaName);
            ResultSet rs = pr.executeQuery();
            while (rs.next()){
                id = rs.getInt("id");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }
}
