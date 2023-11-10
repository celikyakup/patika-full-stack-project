package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Quiz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SolveQuizGUI extends JFrame{
    private JPanel wrapper;
    private JLabel lbl_quiz_question;
    private JTextArea area_quiz_answer;
    private JButton kaydetButton;
    String selected_content_id;
    public SolveQuizGUI(String selected_content_id){
        this.selected_content_id=selected_content_id;
        add(wrapper);
        setLocation(Helper.screenCenterPoint("x",getSize()),Helper.screenCenterPoint("y",getSize()));
        setSize(400,400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITTLE);
        setVisible(true);

        lbl_quiz_question.setText(Quiz.getFetchbyContent(Integer.parseInt(selected_content_id)).getQuiz_question());
        kaydetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Helper.showMsg("Cevabın sisteme kaydedildi.");
                dispose();
            }
        });
    }
}
