package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.DBConnecter;
import com.patikadev.Helper.Helper;
import com.patikadev.Helper.Item;
import com.patikadev.Model.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EducatorGUI extends JFrame{
    private JPanel wrapper;
    private JButton çıkışYapButton;
    private JPanel pnl_top;
    private JTabbedPane Quiz;
    private JTable tbl_content_list;
    private JTextField fld_lesson_name;
    private JTextField fld_content_title;
    private JButton btn_content_search;
    private JTextField fld_content_title_add;
    private JTextField fld_content_explanation_add;
    private JTextField fld_content_link_add;
    private JTextField fld_quiz_add;
    private JButton btn_content_add;
    private JComboBox cmb_content_lesson;
    private JTable tlb_quiz_list;
    private JTable tbl_quiz_list;
    private JTextField fld_quiz_id;
    private JButton btn_delete_quiz;
    private DefaultTableModel mdl_educator_list;
    private Object[] row_content_list;
    private JPopupMenu contentMenu;
    private final User educator;
    private DefaultTableModel mdl_quiz_list;
    private Object [] row_quiz_list;
    private String select_content_id;


    public EducatorGUI(User educator){
        this.educator=educator;
        add(wrapper);
        setSize(800, 500);
        int x = Helper.screenCenterPoint("x", getSize());
        int y = Helper.screenCenterPoint("y", getSize());
        setLocation(x, y);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITTLE);
        setVisible(true);
        //ModelContentList
        contentMenu=new JPopupMenu();
        JMenuItem updateMenu=new JMenuItem("güncelle");
        JMenuItem deleteMenu=new JMenuItem("sil");
        JMenuItem quizAddMenu=new JMenuItem("Quiz Ekle");
        contentMenu.add(updateMenu);
        contentMenu.add(deleteMenu);
        contentMenu.add(quizAddMenu);

        mdl_educator_list=new DefaultTableModel();
        Object [] col_educator_list={"ID","İçerik Adı","İçerik Açıklaması","Link","Ders Adı"};
        mdl_educator_list.setColumnIdentifiers(col_educator_list);
        row_content_list=new Object[col_educator_list.length];
        loadContentList();
        loadLessonCombo();
        tbl_content_list.setModel(mdl_educator_list);
        tbl_content_list.setComponentPopupMenu(contentMenu);
        tbl_content_list.getTableHeader().setReorderingAllowed(false);

        updateMenu.addActionListener(e -> {
            int select_id=Integer.parseInt(tbl_content_list.getValueAt(tbl_content_list.getSelectedRow(),0).toString());
            UpdateContentGUI update=new UpdateContentGUI(Content.getFetch(select_id));
            update.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadContentList();
                }
            });
        });

        deleteMenu.addActionListener(e -> {
            if (Helper.confirm("sure")) {
                int select_id = Integer.parseInt(tbl_content_list.getValueAt(tbl_content_list.getSelectedRow(), 0).toString());
                if (Content.delete(select_id)){
                    Helper.showMsg("done");
                    loadContentList();
                }else {
                    Helper.showMsg("error");
                }
            }
            });
        quizAddMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                select_content_id=tbl_content_list.getValueAt(tbl_content_list.getSelectedRow(),0).toString();
                dispose();
                AddQuizGUI quiz=new AddQuizGUI(educator,select_content_id);
            }
        });
        tbl_content_list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Point point=e.getPoint();
                int selectedrow=tbl_content_list.rowAtPoint(point);
                tbl_content_list.setRowSelectionInterval(selectedrow,selectedrow);
            }
        });
        //##ModelContentList

        //ModelQuizList
        mdl_quiz_list=new DefaultTableModel();
        Object[] col_quiz_list={"ID","İçerik Adı","Quiz Soruları","Quiz Cevapları"};
        mdl_quiz_list.setColumnIdentifiers(col_quiz_list);
        row_quiz_list=new Object[col_quiz_list.length];
        loadContentList();
        loadLessonCombo();
        loadQuizModel();
        tbl_quiz_list.setModel(mdl_quiz_list);
        tbl_quiz_list.getTableHeader().setReorderingAllowed(false);
        tbl_quiz_list.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    String select_user_id = tbl_quiz_list.getValueAt(tbl_quiz_list.getSelectedRow(), 0).toString();
                    fld_quiz_id.setText(select_user_id);
                }
                catch (Exception exc){

                }
            }
        });
        //##ModelQuizList
        çıkışYapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginGUI log=new LoginGUI();
            }
        });
        btn_content_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Item courseItem=(Item) cmb_content_lesson.getSelectedItem();
                if (Helper.isFieldEmpty(fld_content_title_add)||Helper.isFieldEmpty(fld_content_explanation_add)||Helper.isFieldEmpty(fld_content_link_add)){
                    Helper.showMsg("fill");
                }
                else {
                    if (Content.add(fld_content_title_add.getText(),courseItem.getKey(),fld_content_explanation_add.getText(),fld_content_link_add.getText(),courseItem.getValue())){
                        Helper.showMsg("done");
                        loadContentList();
                        loadLessonCombo();
                        fld_content_title_add.setText(null);
                        fld_content_explanation_add.setText(null);
                    }
                    else {
                        Helper.showMsg("error");
                    }
                }
            }
        });
        btn_content_search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lesson_name=fld_lesson_name.getText();
                String name=fld_content_title.getText();
                String query=Content.searchQuery(lesson_name,name);
                ArrayList<Content>searchList=Content.searchList(query);
                loadContentList(searchList);
            }
        });

        btn_delete_quiz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Helper.isFieldEmpty(fld_quiz_id)){
                    Helper.showMsg("fill");
                }
                else {
                    if (Helper.confirm("sure")){
                        int user_id=Integer.parseInt(fld_quiz_id.getText());
                        if (com.patikadev.Model.Quiz.quizDelete(user_id)){
                            Helper.showMsg("done");
                            loadContentList();
                            loadLessonCombo();
                            loadQuizModel();
                            fld_quiz_id.setText(null);
                        }
                    }
                    else {
                        Helper.showMsg("error");
                    }
                }
            }
        });
    }
    public void loadContentList() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_content_list.getModel();
        clearModel.setRowCount(0);
        for (Content obj : Content.getList()) {
            if (obj.getContentCourse().getUser_id() == educator.getId()) {
                row_content_list[0] = obj.getId();
                row_content_list[1] = obj.getName();
                row_content_list[2] = obj.getExplanation();
                row_content_list[3] = obj.getYoutube_link();
                row_content_list[4] = obj.getContentCourse().getName();
                mdl_educator_list.addRow(row_content_list);
            }
        }
    }
    public void loadQuizModel(){
        DefaultTableModel clearModel=(DefaultTableModel) tbl_quiz_list.getModel();
        clearModel.setRowCount(0);
        for (Quiz obj: com.patikadev.Model.Quiz.getList()){
            row_quiz_list[0]=obj.getId();
            row_quiz_list[1]=obj.getContent().getName();
            row_quiz_list[2]=obj.getQuiz_question();
            row_quiz_list[3]=obj.getQuiz_answer();
            mdl_quiz_list.addRow(row_quiz_list);
        }
    }
    public void loadContentList(ArrayList<Content> list){
        DefaultTableModel clearModel=(DefaultTableModel) tbl_content_list.getModel();
        clearModel.setRowCount(0);
        for (Content obj: list){
            row_content_list[0]=obj.getId();
            row_content_list[1]=obj.getName();
            row_content_list[2]=obj.getExplanation();
            row_content_list[3]=obj.getYoutube_link();
            row_content_list[4]=obj.getContentCourse().getName();
            mdl_educator_list.addRow(row_content_list);
        }
    }
    public void loadLessonCombo(){
        cmb_content_lesson.removeAllItems();
        for (Course obj:Course.getList()) {
            if (obj.getUser_id() == educator.getId()) {
                cmb_content_lesson.addItem(new Item(obj.getId(), obj.getName()));
            }
        }
    }
    public static Course getSelectedCourse(String course_name) {
        //tablodan ilgili course name'ine eşit olan satırı getir.
        String query = "SELECT * FROM public.course WHERE course.name=?";
        Course obj = null;
        try {
            PreparedStatement ps = DBConnecter.getInstance().prepareStatement(query);
            ps.setString(1, course_name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int user_id = rs.getInt("user_id");
                int patika_id = rs.getInt("patika_id");
                String name = rs.getString("name");
                String lang = rs.getString("language");
                obj = new Course(id, user_id, patika_id, name, lang);
            }
            return obj;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        Helper.setLayout();
        Educator e=new Educator();
        e.setId(16);
        e.setName("izzet");
        e.setPassword("1");
        e.setType("educator");
        e.setUname("izo");
        EducatorGUI eGUI=new EducatorGUI(e);
    }
}
