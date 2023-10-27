package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Content;

import javax.swing.*;

public class UpdateContentGUI extends JFrame {
    private JPanel wrapper;
    private JTextField fld_update_content_name;
    private JTextField fld_update_content_explanation;
    private JTextField fld_update_content_link;
    private JTextField fld_update_content_quiz;
    private JButton btn_content_update;
    private Content content;

    public UpdateContentGUI(Content content) {
        add(wrapper);
        this.content = content;
        setSize(300, 300);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITTLE);
        setVisible(true);

        fld_update_content_name.setText(content.getName());
        fld_update_content_explanation.setText(content.getExplanation());
        fld_update_content_link.setText(content.getYoutube_link());
        fld_update_content_quiz.setText(content.getQuiz());

        btn_content_update.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_update_content_name) || Helper.isFieldEmpty(fld_update_content_explanation) || Helper.isFieldEmpty(fld_update_content_link) || Helper.isFieldEmpty(fld_update_content_quiz)) {
                Helper.showMsg("fill");
            } else {
                if (Content.update(content.getId(), fld_update_content_name.getText(), fld_update_content_explanation.getText(), fld_update_content_link.getText(), fld_update_content_quiz.getText())) {
                    Helper.showMsg("done");

                }
                dispose();
            }
        });
    }
}

