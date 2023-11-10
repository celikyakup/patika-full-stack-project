package com.patikadev.View;

import com.patikadev.Helper.Helper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentQuizGUI extends JFrame{
    private JPanel pnl_top;
    private JPanel pnl_bottom;
    private JButton btn_back;
    private JButton quizSorularıButton;
    private JTextArea textArea1;
    private JPanel wrapper;
    private JButton yorumuPaylaşButton;
    private String selected_content_id;

    public StudentQuizGUI(String selected_content_id){
        this.selected_content_id=selected_content_id;
        add(wrapper);
        setSize(500,500);
        setLocation(Helper.screenCenterPoint("x",getSize()),Helper.screenCenterPoint("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        btn_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        yorumuPaylaşButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Helper.showMsg("Yorumun iletildi.");
            }
        });
        quizSorularıButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SolveQuizGUI s=new SolveQuizGUI(selected_content_id);
            }
        });
    }
}
