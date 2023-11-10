package com.patikadev.Model;

import com.patikadev.Helper.DBConnecter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Quiz {
    private int id;
    private int content_id;
    private String quiz_question;
    private String quiz_answer;
    private Content content;
    public Quiz(){}

    public Quiz(int id,int content_id, String quiz_question, String quiz_answer) {
        this.id = id;
        this.content_id=id;
        this.quiz_question = quiz_question;
        this.quiz_answer = quiz_answer;
        content=Content.getFetch(content_id);
    }

    public int getContent_id() {
        return content_id;
    }

    public void setContent_id(int content_id) {
        this.content_id = content_id;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuiz_question() {
        return quiz_question;
    }

    public void setQuiz_question(String quiz_question) {
        this.quiz_question = quiz_question;
    }

    public String getQuiz_answer() {
        return quiz_answer;
    }

    public void setQuiz_answer(String quiz_answer) {
        this.quiz_answer = quiz_answer;
    }
    public static ArrayList<Quiz> getList(){
        ArrayList<Quiz> quizList=new ArrayList<>();
        Quiz obj=null;
        try {
            Statement st= DBConnecter.getInstance().createStatement();
            ResultSet rs=st.executeQuery("select * from quiz");
            while (rs.next()){
                obj=new Quiz(rs.getInt("id"),rs.getInt("content_id"),rs.getString("quiz_question"),rs.getString("quiz_answer"));
                quizList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return quizList;
    }
    public static ArrayList<Quiz> getList(int content_id){
        ArrayList<Quiz> quizList=new ArrayList<>();
        Quiz obj=null;
        try {
            Statement st= DBConnecter.getInstance().createStatement();
            ResultSet rs=st.executeQuery("select * from quiz where content_id="+content_id);
            while (rs.next()){
                obj=new Quiz(rs.getInt("id"),rs.getInt("content_id"),rs.getString("quiz_question"),rs.getString("quiz_answer"));
                quizList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return quizList;
    }
    public static Quiz getFetchbyContent(int content_id){
        Quiz obj=null;
        String sql="SELECT * FROM quiz WHERE content_id=?";
        try {
            PreparedStatement pr=DBConnecter.getInstance().prepareStatement(sql);
            pr.setInt(1,content_id);
            ResultSet rs=pr.executeQuery();
            if (rs.next()){
                obj=new Quiz();
                obj.setId(rs.getInt("id"));
                obj.setContent_id(rs.getInt("content_id"));
                obj.setQuiz_question(rs.getString("quiz_question"));
                obj.setQuiz_answer(rs.getString("quiz_answer"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }
    public static boolean quizAdd(int content_id,String quiz_question,String quiz_answer){
        String query="INSERT INTO quiz (content_id,quiz_question,quiz_answer) VALUES (?,?,?)";
        boolean key=true;
        try {
            PreparedStatement pr=DBConnecter.getInstance().prepareStatement(query);
            pr.setInt(1,content_id);
            pr.setString(2,quiz_question);
            pr.setString(3,quiz_answer);
            key=pr.executeUpdate()!=-1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return key;
    }
    public static boolean quizDelete(int id){
        boolean key=true;
        String query="DELETE FROM quiz WHERE id=?";
        try {
            PreparedStatement pr=DBConnecter.getInstance().prepareStatement(query);
            pr.setInt(1,id);
            key=pr.executeUpdate()!=-1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return key;
    }
}
