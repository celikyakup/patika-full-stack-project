package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Patika;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.LinkOption;

public class StudentGUI extends JFrame{
    private JLabel lbl_welcome;
    private JTable tbl_patika_student;
    private JButton btn_sign_up;
    private JPanel wrapper;
    private JButton btn_logout;
    private DefaultTableModel mdl_patika_list;
    private Object[] row_patika_list;
    String select_name;
    String select_id;
    public StudentGUI() {
        add(wrapper);
        setSize(600, 400);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setTitle(Config.PROJECT_TITTLE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        lbl_welcome.setText("Giriş yapmak istediğin patikayı seç.");
        mdl_patika_list = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0 ) {
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };
        Object[] col_patika_list = {"Patika Adı"};
        mdl_patika_list.setColumnIdentifiers(col_patika_list);
        row_patika_list = new Object[col_patika_list.length];
        loadPatikaModel();
        tbl_patika_student.setModel(mdl_patika_list);
        tbl_patika_student.getTableHeader().setReorderingAllowed(false);
        tbl_patika_student.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                select_name=tbl_patika_student.getValueAt(tbl_patika_student.getSelectedRow(),0).toString();
                select_id= String.valueOf(Patika.getFetch(select_name).getId());
            }
        });
        btn_sign_up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                StudentCourseGUI s=new StudentCourseGUI(select_id);
            }
        });
        btn_logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginGUI log=new LoginGUI();
            }
        });
    }
    private void loadPatikaModel() {
        DefaultTableModel clearModel= (DefaultTableModel) tbl_patika_student.getModel();
        clearModel.setRowCount(0);
        for (Patika obj:Patika.getList()){
            row_patika_list[0]=obj.getName();
            mdl_patika_list.addRow(row_patika_list);
        }
    }

    public static void main(String[] args) {
        StudentGUI s=new StudentGUI();
    }
}

