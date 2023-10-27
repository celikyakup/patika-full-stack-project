package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Helper.Item;
import com.patikadev.Model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class EducatorGUI extends JFrame{
    private JPanel wrapper;
    private JButton çıkışYapButton;
    private JPanel pnl_top;
    private JTabbedPane tab_operator;
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
    private DefaultTableModel mdl_educator_list;
    private Object[] row_content_list;
    private JPopupMenu contentMenu;
    private final User educator;


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

        contentMenu=new JPopupMenu();
        JMenuItem updateMenu=new JMenuItem("güncelle");
        JMenuItem deleteMenu=new JMenuItem("sil");
        contentMenu.add(updateMenu);
        contentMenu.add(deleteMenu);

        mdl_educator_list=new DefaultTableModel();
        Object [] col_educator_list={"ID","İçerik Adı","İçerik Açıklaması","Link","Quiz","Ders Adı"};
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
        tbl_content_list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Point point=e.getPoint();
                int selectedrow=tbl_content_list.rowAtPoint(point);
                tbl_content_list.setRowSelectionInterval(selectedrow,selectedrow);
            }
        });

        çıkışYapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
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
                    if (Content.add(fld_content_title_add.getText(),courseItem.getKey(),fld_content_explanation_add.getText(),fld_content_link_add.getText(),fld_quiz_add.getText(),courseItem.getValue())){
                        Helper.showMsg("done");
                        loadContentList();
                        loadLessonCombo();
                        fld_content_title_add.setText(null);
                        fld_content_explanation_add.setText(null);
                        fld_quiz_add.setText(null);
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
        fld_quiz_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        fld_quiz_add.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                

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
                row_content_list[4] = obj.getQuiz();
                row_content_list[5] = obj.getContentCourse().getName();
                mdl_educator_list.addRow(row_content_list);
            }
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
            row_content_list[4]=obj.getQuiz();
            row_content_list[5]=obj.getContentCourse().getName();
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
