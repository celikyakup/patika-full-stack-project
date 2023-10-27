package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Content;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddQuizGUI extends JFrame{
    private JPanel wrapper;
    private JTextField fld_quiz_add;
    private JTextField fld_quiz_answer_add;
    private JButton btn_quiz_add;
    private Content content;
    public AddQuizGUI(Content content){
        this.content=content;
        add(wrapper);
        setSize(500,500);
        setLocation(Helper.screenCenterPoint("x",getSize()),Helper.screenCenterPoint("y",getSize()));
        setTitle(Config.PROJECT_TITTLE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        fld_quiz_add.setText(content.getQuiz());
        fld_quiz_answer_add.setText(content.getQuiz());
        btn_quiz_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Helper.isFieldEmpty(fld_quiz_add)||Helper.isFieldEmpty(fld_quiz_answer_add)){
                    Helper.showMsg("fill");
                }
                else {
                    dispose();
                }
            }
        });
    }
}
