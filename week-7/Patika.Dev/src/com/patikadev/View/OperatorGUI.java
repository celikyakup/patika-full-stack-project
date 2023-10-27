package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Helper.Item;
import com.patikadev.Model.Course;
import com.patikadev.Model.Operator;
import com.patikadev.Model.Patika;
import com.patikadev.Model.User;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class OperatorGUI extends JFrame {
    private JPanel wrapper;
    private JTabbedPane tab_operator;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JButton btn_logout;
    private JPanel pnl_user_list;
    private JTable tbl_user_list;
    private JPanel pnl_user_form;
    private JTextField fld_user_name;
    private JTextField fld_user_uname;
    private JPasswordField fld_user_pass;
    private JComboBox cmb_user_type;
    private JButton btn_user_add;
    private JTextField fld_user_id;
    private JButton btn_user_delete;
    private JTextField fld_sh_user_name;
    private JTextField fld_sh_user_uname;
    private JComboBox combo_sh_user_type;
    private JButton btn_user_sh;
    private JPanel pnl_patika_list;
    private JScrollPane scrl_patika_list;
    private JTable tbl_patika_list;
    private JPanel pnl_patika_add;
    private JTextField fld_patika_name;
    private JButton btn_patika_add;
    private JPanel pnl_course_list;
    private JScrollPane scrl_course_list;
    private JTable tbl_course_list;
    private JPanel pnl_course_add;
    private JTextField fld_course_name;
    private JTextField fld_course_lang;
    private JComboBox cmb_course_user;
    private JButton btn_course_add;
    private JComboBox cmb_course_patika;
    private DefaultTableModel mdl_user_list;
    private Object[] row_user_list;
    private final Operator operator;
    private DefaultTableModel mdl_patika_list;
    private Object[] row_patika_list;
    private JPopupMenu patikaMenu;
    private DefaultTableModel mdl_course_list;
    private Object[] row_course_list;
    public OperatorGUI(Operator operator) {
        this.operator = operator;

        add(wrapper);
        setSize(1000, 500);
        int x = Helper.screenCenterPoint("x", getSize());
        int y = Helper.screenCenterPoint("y", getSize());
        setLocation(x, y);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITTLE);
        setVisible(true);

        lbl_welcome.setText("Hoşgeldin " + operator.getName());

        //Model User List
        mdl_user_list = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column==0){
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };
        Object[] col_user_list = {"ID", "Ad Soyad", "Kullanıcı Adı", "Şifre", "Kullanıcı Tipi"};
        mdl_user_list.setColumnIdentifiers(col_user_list);
        row_user_list=new Object[col_user_list.length];
        loadUserModel();
        tbl_user_list.setModel(mdl_user_list);
        tbl_user_list.getTableHeader().setReorderingAllowed(false);

        tbl_user_list.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    String select_user_id = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 0).toString();
                    fld_user_id.setText(select_user_id);
                }
                catch (Exception exc){

                }
            }
        });
        tbl_user_list.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType()==TableModelEvent.UPDATE){
                    int user_id=Integer.parseInt(tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(),0).toString());
                    String user_name=tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(),1).toString();
                    String user_uname=tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(),2).toString();
                    String user_password=tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(),3).toString();
                    String user_type=tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(),4).toString();
                    if (User.userUpdate(user_id,user_name,user_uname,user_password,user_type)){
                        Helper.showMsg("done");
                        loadUserModel();
                    }
                    loadUserModel();
                    loadEducatorCombo();
                    loadCourseModel();
                }
            }
        });
        //## ModelUserList

        //ModelPatikaList
        patikaMenu =new JPopupMenu();
        JMenuItem updateMenu=new JMenuItem("güncelle");
        JMenuItem deleteMenu=new JMenuItem("silme");
        patikaMenu.add(updateMenu);
        patikaMenu.add(deleteMenu);

        updateMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int select_id=Integer.parseInt(tbl_patika_list.getValueAt(tbl_patika_list.getSelectedRow(),0).toString());
                UpdatePatikaGui updateGUI=new UpdatePatikaGui(Patika.getFetch(select_id));
                updateGUI.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        loadPatikaModel();
                        loadPatikaCombo();
                        loadCourseModel();
                    }
                });
            }
        });
        deleteMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Helper.confirm("sure")) {
                    int select_id = Integer.parseInt(tbl_patika_list.getValueAt(tbl_patika_list.getSelectedRow(), 0).toString());
                    if (Patika.delete(select_id)){
                        Helper.showMsg("done");
                        loadPatikaModel();
                        loadPatikaCombo();
                        loadCourseModel();
                    }else {
                        Helper.showMsg("error");
                    }
                }
            }
        });

        mdl_patika_list=new DefaultTableModel();
        Object[] col_patika_list={"ID","Patika Adı"};
        mdl_patika_list.setColumnIdentifiers(col_patika_list);
        row_patika_list=new Object[col_patika_list.length];
        loadPatikaModel();
        loadPatikaCombo();

        tbl_patika_list.setModel(mdl_patika_list);
        tbl_patika_list.setComponentPopupMenu(patikaMenu);
        tbl_patika_list.getTableHeader().setReorderingAllowed(false);
        tbl_patika_list.getColumnModel().getColumn(0).setMaxWidth(100);

        tbl_patika_list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Point point=e.getPoint();
                int selected_row=tbl_patika_list.rowAtPoint(point);
                tbl_patika_list.setRowSelectionInterval(selected_row,selected_row);
            }
        });
        //## ModelPatikaList
        //ModelCourseList
        mdl_course_list=new DefaultTableModel();
        Object [] col_course_list={"ID","Ders Adı","Programlama Dili","Patika","Eğitmen"};
        mdl_course_list.setColumnIdentifiers(col_course_list);
        row_course_list=new Object[col_course_list.length];
        loadCourseModel();
        //Oluşturduğumuz modeli tbl_course_list e atıyoruz.
        tbl_course_list.setModel(mdl_course_list);
        //Id sütununun genişliğini sınırlıyoruz.
        tbl_course_list.getColumnModel().getColumn(0).setMaxWidth(75);
        tbl_course_list.getTableHeader().setReorderingAllowed(false);

        loadPatikaCombo();
        loadEducatorCombo();

        //##ModelCourseList
        btn_user_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Helper.isFieldEmpty(fld_user_name) || Helper.isFieldEmpty(fld_user_uname) || Helper.isFieldEmpty(fld_user_pass)) {
                    Helper.showMsg("fill");
                } else {
                    String name = fld_user_name.getText();
                    String uname = fld_user_uname.getText();
                    String password = fld_user_pass.getText();
                    String type = cmb_user_type.getSelectedItem().toString();
                    if (User.add(name, uname, password, type)) {
                        Helper.showMsg("done");
                        loadUserModel();
                        loadEducatorCombo();
                        fld_user_name.setText(null);
                        fld_user_uname.setText(null);
                        fld_user_pass.setText(null);
                    }
                }
            }
        });
        btn_user_delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Helper.isFieldEmpty(fld_user_id)){
                    Helper.showMsg("fill");
                }else {
                    if (Helper.confirm("sure")){
                        int user_id=Integer.parseInt(fld_user_id.getText());
                        if (User.userDelete(user_id)){
                            Helper.showMsg("done");
                            loadUserModel();
                            loadEducatorCombo();
                            loadCourseModel();
                            fld_user_id.setText(null);
                        }
                        else {
                            Helper.showMsg("error");
                        }
                    }
                }
            }
        });
        btn_user_sh.addActionListener(e ->  {
            String name=fld_sh_user_name.getText();
            String uname=fld_sh_user_uname.getText();
            String type=combo_sh_user_type.getSelectedItem().toString();
            String query=User.searchQuery(name,uname,type);
            loadUserModel(User.searchUserList(query));
            fld_sh_user_name.setText(null);
            fld_sh_user_uname.setText(null);

        });
        btn_logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginGUI login=new LoginGUI();
            }
        });
        btn_patika_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Helper.isFieldEmpty(fld_patika_name)){
                    Helper.showMsg("fill");
                }
                else {
                    if (Patika.add(fld_patika_name.getText())){
                        Helper.showMsg("done");
                        loadPatikaModel();
                        loadPatikaCombo();
                        fld_patika_name.setText(null);
                    }
                    else {
                        Helper.showMsg("error");
                    }
                }
            }
        });
        btn_course_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Item patikaItem= (Item) cmb_course_patika.getSelectedItem();
                Item userItem=(Item) cmb_course_user.getSelectedItem();
                if (Helper.isFieldEmpty(fld_course_name) || Helper.isFieldEmpty(fld_course_lang)){
                    Helper.showMsg("fill");
                }
                else {
                    if (Course.add(userItem.getKey(),patikaItem.getKey(),fld_course_name.getText(),fld_course_lang.getText())){
                        Helper.showMsg("done");
                        loadCourseModel();
                        fld_course_name.setText(null);
                        fld_course_lang.setText(null);
                    }else {
                        Helper.showMsg("error");
                    }
                }
            }
        });
    }

    private void loadCourseModel() {
        DefaultTableModel clearModel= (DefaultTableModel) tbl_course_list.getModel();
        clearModel.setRowCount(0);
        for (Course obj:Course.getList()){
            row_course_list[0]=obj.getId();
            row_course_list[1]=obj.getName();
            row_course_list[2]=obj.getLanguage();
            row_course_list[3]=obj.getPatika().getName();
            row_course_list[4]=obj.getEducator().getName();
            mdl_course_list.addRow(row_course_list);
        }
    }

    private void loadPatikaModel() {
        DefaultTableModel clearModel= (DefaultTableModel) tbl_patika_list.getModel();
        clearModel.setRowCount(0);
        for (Patika obj:Patika.getList()){
            row_patika_list[0]=obj.getId();
            row_patika_list[1]=obj.getName();
            mdl_patika_list.addRow(row_patika_list);
        }
    }

    public void loadUserModel (){
            DefaultTableModel clearModel= (DefaultTableModel) tbl_user_list.getModel();
            clearModel.setRowCount(0);
            for (User obj:User.getList()){

                row_user_list[0]=obj.getId();
                row_user_list[1]=obj.getName();
                row_user_list[2]=obj.getUname();
                row_user_list[3]=obj.getPassword();
                row_user_list[4]=obj.getType();
                mdl_user_list.addRow(row_user_list);
            }
        }
    public void loadUserModel (ArrayList<User> list){
        DefaultTableModel clearModel= (DefaultTableModel) tbl_user_list.getModel();
        clearModel.setRowCount(0);
        for (User obj:list){

            row_user_list[0]=obj.getId();
            row_user_list[1]=obj.getName();
            row_user_list[2]=obj.getUname();
            row_user_list[3]=obj.getPassword();
            row_user_list[4]=obj.getType();
            mdl_user_list.addRow(row_user_list);
        }
    }
    public void loadPatikaCombo(){
        cmb_course_patika.removeAllItems();
        for (Patika obj: Patika.getList()){
            cmb_course_patika.addItem(new Item(obj.getId(),obj.getName()));
        }
    }
    public void loadEducatorCombo(){
        cmb_course_user.removeAllItems();
        for (User obj: User.getList()){
            if (obj.getType().equals("educator")) {
                cmb_course_user.addItem(new Item(obj.getId(), obj.getName()));
            }
        }
    }

    public static void main(String[] args) {
        Helper.setLayout();
        Operator op=new Operator();
        op.setId(1);
        op.setName("Mustafa Çetindağ");
        op.setPassword("1234");
        op.setType("operator");
        op.setUname("mustafa");
        OperatorGUI opGUI=new OperatorGUI(op);
    }

}
