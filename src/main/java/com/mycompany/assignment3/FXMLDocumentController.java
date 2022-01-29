/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment3;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TabPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FXMLDocumentController implements Initializable {

    private QuizDAO dao;
    private NewQuizController dlgController;
    private ArrayList <Label> studentLabels;
    private ArrayList <ProgressBar> studentBars;
    private ArrayList <Label> questionLabels;
    private ArrayList <ProgressBar> questionBars;
    
    @FXML
    private Label student1;
    @FXML
    private Label student2;
    @FXML
    private Label student3;
    @FXML
    private Label student4;
    @FXML
    private Label student5;
    @FXML
    private Label student6;
    @FXML
    private Label student7;
    @FXML
    private Label student8;
    @FXML
    private ProgressBar sBar1;
    @FXML
    private ProgressBar sBar2;
    @FXML
    private ProgressBar sBar3;
    @FXML
    private ProgressBar sBar4;
    @FXML
    private ProgressBar sBar5;
    @FXML
    private ProgressBar sBar6;
    @FXML
    private ProgressBar sBar7;
    @FXML
    private ProgressBar sBar8;
    @FXML
    private Label question1;
    @FXML
    private Label question2;
    @FXML
    private Label question3;
    @FXML
    private Label question4;
    @FXML
    private Label question5;
    @FXML
    private Label question6;
    @FXML
    private Label question7;
    @FXML
    private Label question8;
    @FXML
    private ProgressBar qBar1;
    @FXML
    private ProgressBar qBar2;
    @FXML
    private ProgressBar qBar3;
    @FXML
    private ProgressBar qBar4;
    @FXML
    private ProgressBar qBar5;
    @FXML
    private ProgressBar qBar6;
    @FXML
    private ProgressBar qBar7;
    @FXML
    private ProgressBar qBar8;
    
    @FXML
    private TabPane tabPane;
    
    public void setQuiz(String newQuiz) {
        dao.set(newQuiz);
    }
    
    public QuizDAO getDAO() {
        return dao;
    }
    
    @FXML
    private void exit(ActionEvent event) {
        dao.close();
        Platform.exit();
    }
    
    @FXML
    private void selectQuiz(ActionEvent event) {
        Stage parent = (Stage) tabPane.getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("tertiary.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage dialog = new Stage();
            dialog.setScene(scene);
            dialog.setTitle("Select Quiz");
            dialog.initOwner(parent);
            dialog.initModality(Modality.WINDOW_MODAL);
            dialog.initStyle(StageStyle.UTILITY);
            dialog.setX(parent.getX() + parent.getWidth() / 4);
            dialog.setY(parent.getY() + parent.getHeight() / 3);
            dlgController = (NewQuizController) loader.getController();
            dlgController.setDAO(dao, this);
            dialog.show();
        } catch (Exception ex) {
            System.out.println("Could not open dialog.");
            ex.printStackTrace();
        }
    }
    
    @FXML
    private void gradeQuiz(ActionEvent event) {
        dao = dlgController.getDAO();
        dao.grade();
    }
    
    @FXML
    private void viewResults(ActionEvent event) {
        ArrayList <Student> students = dao.getStudents();
        ArrayList <Question> questions = dao.getQuestions();
        for (int n = 0; n < 8; n++) {
            if (n < students.size()) {
                Student s = students.get(n);
                studentLabels.get(n).setText(s.getName());
                //System.out.println(s.getPoints());
                studentBars.get(n).setProgress(s.getPoints());
                studentBars.get(n).setVisible(true);
            } else {
                studentLabels.get(n).setText("");
                studentBars.get(n).setVisible(false);
            }
            if (n < questions.size()) {
                Question q = questions.get(n);
                questionLabels.get(n).setText(q.getSubject());
                //System.out.println(q.getPoints());
                questionBars.get(n).setProgress(q.getPoints());
                questionBars.get(n).setVisible(true);
            } else {
                questionLabels.get(n).setText("");
                questionBars.get(n).setVisible(false);
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dao = new QuizDAO();
        dlgController = new NewQuizController();
        sBar1.setVisible(false);
        sBar2.setVisible(false);
        sBar3.setVisible(false);
        sBar4.setVisible(false);
        sBar5.setVisible(false);
        sBar6.setVisible(false);
        sBar7.setVisible(false);
        sBar8.setVisible(false);
        qBar1.setVisible(false);
        qBar2.setVisible(false);
        qBar3.setVisible(false);
        qBar4.setVisible(false);
        qBar5.setVisible(false);
        qBar6.setVisible(false);
        qBar7.setVisible(false);
        qBar8.setVisible(false);
        student1.setText("");
        student2.setText("");
        student3.setText("");
        student4.setText("");
        student5.setText("");
        student6.setText("");
        student7.setText("");
        student8.setText("");
        question1.setText("");
        question2.setText("");
        question3.setText("");
        question4.setText("");
        question5.setText("");
        question6.setText("");
        question7.setText("");
        question8.setText("");
        studentLabels = new ArrayList<Label>();
        studentLabels.add(student1);
        studentLabels.add(student2);
        studentLabels.add(student3);
        studentLabels.add(student4);
        studentLabels.add(student5);
        studentLabels.add(student6);
        studentLabels.add(student7);
        studentLabels.add(student8);
        studentBars = new ArrayList<ProgressBar>();
        studentBars.add(sBar1);
        studentBars.add(sBar2);
        studentBars.add(sBar3);
        studentBars.add(sBar4);
        studentBars.add(sBar5);
        studentBars.add(sBar6);
        studentBars.add(sBar7);
        studentBars.add(sBar8);
        questionLabels = new ArrayList<Label>();
        questionLabels.add(question1);
        questionLabels.add(question2);
        questionLabels.add(question3);
        questionLabels.add(question4);
        questionLabels.add(question5);
        questionLabels.add(question6);
        questionLabels.add(question7);
        questionLabels.add(question8);
        questionBars = new ArrayList<ProgressBar>();
        questionBars.add(qBar1);
        questionBars.add(qBar2);
        questionBars.add(qBar3);
        questionBars.add(qBar4);
        questionBars.add(qBar5);
        questionBars.add(qBar6);
        questionBars.add(qBar7);
        questionBars.add(qBar8);
    }
    
}
