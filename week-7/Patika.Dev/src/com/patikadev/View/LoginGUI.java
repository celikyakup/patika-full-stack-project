package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Educator;
import com.patikadev.Model.Operator;
import com.patikadev.Model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame{
    private JPanel wrapper;
    private JPanel pnl_top;
    private JPanel pnl_bot;
    private JTextField fld_login_uname;
    private JPasswordField fld_login_pass;
    private JButton btn_login;

    public LoginGUI(){
        add(wrapper);
        setSize(450,400);
        setLocation(Helper.screenCenterPoint("x",getSize()),Helper.screenCenterPoint("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITTLE);
        setResizable(false);
        setVisible(true);

        btn_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Helper.isFieldEmpty(fld_login_uname)||Helper.isFieldEmpty(fld_login_pass)){
                    Helper.showMsg("fill");
                }
                else {
                    User u= User.getFetch(fld_login_uname.getText(),fld_login_pass.getText());
                    if (u==null){
                        Helper.showMsg("Kullanıcı bulunamadı !");
                    }else {
                        switch (u.getType()){
                            case "operator"->{
                                OperatorGUI opGUI=new OperatorGUI((Operator) u);
                            }
                            case "educator"->{
                                EducatorGUI edGUI=new EducatorGUI( u);
                            }
                            case "student"->{
                                StudentGUI stGUI=new StudentGUI();
                            }
                        }
                        dispose();
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        Helper.setLayout();
        LoginGUI login =new LoginGUI();
    }
}
