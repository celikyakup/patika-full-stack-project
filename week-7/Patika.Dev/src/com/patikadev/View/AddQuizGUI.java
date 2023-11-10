package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddQuizGUI extends JFrame{
    private JPanel wrapper;
    private JTextArea area_quiz_question_add;
    private JTextArea area_quiz_answer_add;
    private JButton btn_quiz_add;
    private JLabel lbl_field_name;
    private JButton btn_back;
    private User educator;
    private String select_content_id;

    public AddQuizGUI(User educator,String select_content_id){
        this.educator=educator;
        this.select_content_id=select_content_id;
        add(wrapper);
        setSize(600,600);
        int x= Helper.screenCenterPoint("x",getSize());
        int y=Helper.screenCenterPoint("y",getSize());
        setLocation(x,y);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITTLE);
        setVisible(true);
        lbl_field_name.setText(Content.getFetch(Integer.parseInt(select_content_id)).getName()+" İçeriği Quiz Hazırlama");

        btn_quiz_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Helper.isFieldArea(area_quiz_question_add)||Helper.isFieldArea(area_quiz_answer_add)){
                    Helper.showMsg("fill");
                }
                else {
                    if (Quiz.quizAdd(Integer.parseInt(select_content_id),area_quiz_question_add.getText(),area_quiz_answer_add.getText())){

                        Helper.showMsg("done");
                    }
                    dispose();
                    EducatorGUI edu=new EducatorGUI(educator);
                }
            }
        });
        btn_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                EducatorGUI ed=new EducatorGUI(educator);
            }
        });
    }
}
