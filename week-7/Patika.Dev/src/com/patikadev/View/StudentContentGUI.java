package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Content;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class StudentContentGUI extends JFrame{
    private JPanel wrapper;
    private JPanel pnl_top;
    private JPanel pnl_bottom;
    private JButton btn_back;
    private JTable tbl_student_content_list;
    private DefaultTableModel mdl_student_content_list;
    private Object[] row_student_content_list;
    private String select_course_id;
    private String selected_content_id;
    public StudentContentGUI(String select_course_id){
        this.select_course_id=select_course_id;
        add(wrapper);
        setSize(750,500);
        setLocation(Helper.screenCenterPoint("x",getSize()),Helper.screenCenterPoint("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITTLE);
        setVisible(true);

        mdl_student_content_list=new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column==0 || column==1 || column==2 ||column==3){
                    return false;
                }
                return super.isCellEditable(row,column);
            }
        };
        Object[] col_student_content_list={"Ad","Açıklama","Youtube Link","Ders Adı"};
        mdl_student_content_list.setColumnIdentifiers(col_student_content_list);
        row_student_content_list=new Object[col_student_content_list.length];
        loadStudentContentList();
        tbl_student_content_list.setModel(mdl_student_content_list);
        tbl_student_content_list.getTableHeader().setReorderingAllowed(false);

        btn_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

                StudentGUI stu=new StudentGUI();
            }
        });
        tbl_student_content_list.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String selected_content_name=tbl_student_content_list.getValueAt(tbl_student_content_list.getSelectedRow(),0).toString();
                selected_content_id= String.valueOf(Content.getFetch(selected_content_name).getId());
            }
        });
        tbl_student_content_list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Point point=e.getPoint();
                int selected_row= tbl_student_content_list.rowAtPoint(point);
                tbl_student_content_list.setRowSelectionInterval(selected_row,selected_row);
                if (e.getClickCount()==2){
                    StudentQuizGUI stu=new StudentQuizGUI(selected_content_id);
                }
            }
        });
    }
    public void loadStudentContentList(){
        DefaultTableModel clearModel=(DefaultTableModel) tbl_student_content_list.getModel();
        clearModel.setRowCount(0);
        for (Content obj:Content.getListByCourseID(Integer.parseInt(select_course_id))){
            row_student_content_list[0]=obj.getName();
            row_student_content_list[1]=obj.getExplanation();
            row_student_content_list[2]=obj.getYoutube_link();
            row_student_content_list[3]=obj.getLesson_name();
            mdl_student_content_list.addRow(row_student_content_list);
        }
    }
}
