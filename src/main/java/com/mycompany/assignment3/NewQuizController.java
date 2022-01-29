/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment3;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

/**
 *
 * @author letranngocmy
 */
public class NewQuizController implements Initializable {
    
    private QuizDAO dao;
    private QuizDAO temp;
    private FXMLDocumentController controller;
    
    @FXML
    private Button cancel;
    @FXML
    private Button OK;
    @FXML
    private ChoiceBox quizChoice;
    

    @FXML
    private void acceptDialog(ActionEvent event) {
        quizChoice.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->setQuiz((String) newValue));
        controller.setQuiz((String) quizChoice.getSelectionModel().getSelectedItem());
        quizChoice.getScene().getWindow().hide();
    }

    @FXML
    private void cancelDialog(ActionEvent event) {
        quizChoice.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->setQuiz((String) oldValue));
        quizChoice.getScene().getWindow().hide();
    }
    
    public void setQuiz(String title) {
        dao.set(title);
    }

    public void setDAO(QuizDAO d, FXMLDocumentController c) {
        dao = d;
        controller = c;
        ArrayList<String> titles = dao.getQuizTitles();
        quizChoice.getItems().addAll(titles);
        dao.set(controller.toString());
        quizChoice.setValue(dao.getTitle());
        //quizChoice.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->setQuiz((String) newValue));
    }
    
    public QuizDAO getDAO() {
        return dao;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
}
