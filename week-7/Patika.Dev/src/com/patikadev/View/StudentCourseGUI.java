package com.patikadev.View;

import com.patikadev.Helper.Helper;
import com.patikadev.Model.Course;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentCourseGUI extends JFrame{
    private JPanel wrapper;
    private JTable tbl_course_student;
    private JButton btn_back;
    private JButton btn_sign_up;
    public String select_id;
    private DefaultTableModel mdl_student_course_list;
    private Object[] row_student_course_list;
    public String select_name;
    public String select_course_id;
    public StudentCourseGUI(String select_id){
        this.select_id=select_id;
        add(wrapper);
        setSize(750,500);
        setLocation(Helper.screenCenterPoint("x",getSize()),Helper.screenCenterPoint("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        mdl_student_course_list=new DefaultTableModel();
        Object[] col_student_course_list={"Ders Adı","Ders Dili"};
        mdl_student_course_list.setColumnIdentifiers(col_student_course_list);
        row_student_course_list=new Object[col_student_course_list.length];
        loadStudentCourseModel();
        tbl_course_student.setModel(mdl_student_course_list);
        tbl_course_student.getTableHeader().setReorderingAllowed(false);
        btn_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                StudentGUI student=new StudentGUI();
            }
        });
        tbl_course_student.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                select_name=tbl_course_student.getValueAt(tbl_course_student.getSelectedRow(),0).toString();
                select_course_id= String.valueOf(Course.getFetchByName(select_name).getId());
            }
        });
        btn_sign_up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                StudentContentGUI stu=new StudentContentGUI(select_course_id);
            }
        });
    }
    public void loadStudentCourseModel(){
        DefaultTableModel clearModel=(DefaultTableModel) tbl_course_student.getModel();
        clearModel.setRowCount(0);
        for (Course obj: Course.getListByPatikaID(Integer.parseInt(select_id))){
            row_student_course_list[0]=obj.getName();
            row_student_course_list[1]=obj.getLanguage();
            mdl_student_course_list.addRow(row_student_course_list);
        }
    }
}
