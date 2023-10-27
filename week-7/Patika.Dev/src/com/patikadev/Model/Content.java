package com.patikadev.Model;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.DBConnecter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Content {
    private int id;
    private int course_id;
    private String name;
    private String explanation;
    private String youtube_link;
    private String quiz;
    private String lesson_name;
    private Course contentCourse;
    private Course contentLessonName;

    public Course getContentLessonName() {
        return contentLessonName;
    }

    public void setContentLessonName(Course contentLessonName) {
        this.contentLessonName = contentLessonName;
    }
    public Content(){}

    public Content(int id, int course_id, String name, String explanation, String youtube_link, String quiz, String lesson_name) {
        this.id=id;
        this.course_id=course_id;
        this.contentCourse= Course.getFetch(course_id);
        this.name = name;
        this.explanation = explanation;
        this.youtube_link = youtube_link;
        this.quiz = quiz;
        this.lesson_name = lesson_name;
        this.contentLessonName=Course.getFetchByName(lesson_name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getYoutube_link() {
        return youtube_link;
    }

    public void setYoutube_link(String youtube_link) {
        this.youtube_link = youtube_link;
    }

    public String getQuiz() {
        return quiz;
    }

    public void setQuiz(String quiz) {
        this.quiz = quiz;
    }

    public String getLesson_name() {
        return lesson_name;
    }

    public void setLesson_name(String lesson_name) {
        this.lesson_name = lesson_name;
    }

    public Course getContentCourse() {
        return contentCourse;
    }

    public void setContentCourse(Course contentCourse) {
        this.contentCourse = contentCourse;
    }
    public static ArrayList<Content> getList(){
        ArrayList<Content> contentList=new ArrayList<>();
        Content obj;
        try {
            Statement st= DBConnecter.getInstance().createStatement();
            ResultSet rs=st.executeQuery("select * from content");
            while (rs.next()){
                obj=new Content(rs.getInt("id"),rs.getInt("course_id"),rs.getString("name"),rs.getString("explanation"),rs.getString("youtube_link"),rs.getString("quiz"),rs.getString("lesson_name"));
                contentList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contentList;
    }
    public static boolean add(String name,int course_id,String explanation,String youtube_link,String quiz,String lesson_name){
        String query="INSERT INTO content (name,course_id,explanation,youtube_link,quiz,lesson_name ) VALUES (?,?,?,?,?,?) ";
        boolean key=true;
        try {
            PreparedStatement pr=DBConnecter.getInstance().prepareStatement(query);
            pr.setString(1,name);
            pr.setInt(2,course_id);
            pr.setString(3,explanation);
            pr.setString(4,youtube_link);
            pr.setString(5,quiz);
            pr.setString(6,lesson_name);
            key=pr.executeUpdate()!=-1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return key;
    }
    public static boolean update(int id,String name,String explanation,String youtube_link,String quiz){
        String query="UPDATE content SET name=?,explanation=?,youtube_link=?,quiz=? WHERE id=? ";
        boolean key=true;
        try {
            PreparedStatement pr=DBConnecter.getInstance().prepareStatement(query);
            pr.setString(1,name);
            pr.setString(2,explanation);
            pr.setString(3,youtube_link);
            pr.setString(4,quiz);
            pr.setInt(5,id);
            key=pr.executeUpdate()!=-1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return key;
    }
    public static Content getFetch(int id){
        Content obj=null;
        String sql="SELECT * FROM content WHERE id=?";
        try {
            PreparedStatement pr=DBConnecter.getInstance().prepareStatement(sql);
            pr.setInt(1,id);
            ResultSet rs=pr.executeQuery();
            if (rs.next()){
                obj=new Content();
                obj.setId(rs.getInt("id"));
                obj.setCourse_id(rs.getInt("course_id"));
                obj.setName(rs.getString("name"));
                obj.setExplanation(rs.getString("explanation"));
                obj.setYoutube_link(rs.getString("youtube_link"));
                obj.setQuiz(rs.getString("quiz"));
                obj.setLesson_name(rs.getString("lesson_name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }
    public static boolean delete(int id){
        String query="DELETE FROM content WHERE id=?";
        boolean key=true;
        try {
            PreparedStatement pr=DBConnecter.getInstance().prepareStatement(query);
            pr.setInt(1,id);
            key=pr.executeUpdate()!=-1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return key;
    }
    public static boolean quizAdd(String quiz){
        String query="INSERT INTO content quiz VALUES ? ";
        boolean key=true;
        try {
            PreparedStatement pr=DBConnecter.getInstance().prepareStatement(query);

            pr.setString(1,quiz);
            key=pr.executeUpdate()!=-1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return key;
    }
    public static ArrayList<Content> searchList(String query){
        ArrayList <Content> contentList=new ArrayList<>();
        Content obj;
        try {
            Statement st= DBConnecter.getInstance().createStatement();
            ResultSet rs=st.executeQuery(query);
            while (rs.next()){
                obj=new Content(rs.getInt("id"),rs.getInt("course_id"),rs.getString("name"),rs.getString("explanation"),rs.getString("youtube_link"),rs.getString("quiz"),rs.getString("lesson_name"));
                contentList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contentList;
    }
    public static String searchQuery(String lesson_name,String name){
        String query="SELECT * FROM content WHERE lesson_name LIKE '%{{lesson_name}}%' AND name LIKE '%{{name}}%'";
        query=query.replace("{{lesson_name}}",lesson_name);
        query=query.replace("{{name}}",name);
        return query;
    }
}

