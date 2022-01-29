/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment3;

import java.sql.*;
import java.util.ArrayList;

public class QuizDAO {

    private Connection connection;
    private Statement statement;
    private String questionsSQL = "select * from questions where quiz=?";
    private PreparedStatement questionsStmt;
    private String insertSQL = "insert into questions(subject,question,choices,answer,quiz) values(?,?,?,?,?)";
    private PreparedStatement insertStmt;
    private String deleteSQL = "delete from questions where id=?";
    private PreparedStatement deleteStmt;
    private String quizzesSQL = "select * from quizzes where id=?";
    private PreparedStatement quizzesStmt;
    private String insertQuizSQL = "insert into quizzes(title) values(?)";
    private PreparedStatement insertQuizStmt;
    private String deleteQuizSQL = "delete from quizzes where id=?";
    private PreparedStatement deleteQuizStmt;
    private String deleteQuestionsSQL = "delete from questions where quiz=?";
    private PreparedStatement deleteQuestionsStmt;
    private String responsesSQL = "select * from responses where correct=(?)";
    private PreparedStatement responsesStmt;
    private String studentsSQL = "select * from students";
    private PreparedStatement studentsStmt;
    
    private ArrayList<Question> questions;
    private ArrayList<Student> students;
    private String title;
    private int id;
    
    // The constructor opens the database connection
    public QuizDAO() {
        // Load the database driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Could not load database driver.");
        }
        // Open the connection and set up statements
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz?user=student&password=cmsc250!");
            statement = connection.createStatement();
            questionsStmt = connection.prepareStatement(questionsSQL);
            quizzesStmt = connection.prepareStatement(quizzesSQL);
            insertStmt = connection.prepareStatement(insertSQL);
            deleteStmt = connection.prepareStatement(deleteSQL);
            insertQuizStmt = connection.prepareStatement(insertQuizSQL);
            deleteQuizStmt = connection.prepareStatement(deleteQuizSQL);
            deleteQuestionsStmt = connection.prepareStatement(deleteQuestionsSQL);
            responsesStmt = connection.prepareStatement(responsesSQL);
            studentsStmt = connection.prepareStatement(studentsSQL);
        } catch (SQLException ex) {
            System.out.println("Could not connect to database.");
            ex.printStackTrace();
        }
        questions = new ArrayList();
        students = new ArrayList();
    }
    
    public void close() {
        try {
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void set(String title) {
        this.title = title;
        questions.clear();
        students.clear();
        try {
            ResultSet resultSet = statement.executeQuery("select id from quizzes where title=\"" + title + "\"");
            if (resultSet.next()) {
                id = resultSet.getInt(1);
            }
            questionsStmt.setInt(1, id);
            resultSet = questionsStmt.executeQuery();
            while (resultSet.next()) {
                Question q = new Question();
                q.setId(resultSet.getInt("id"));
                q.setSubject(resultSet.getString("subject"));
                q.setQuestion(resultSet.getString("question"));
                q.setChoices(resultSet.getString("choices"));
                q.setAnswer(resultSet.getString("answer"));
                q.setQuiz(resultSet.getInt("quiz"));
                questions.add(q);
            }
            resultSet = studentsStmt.executeQuery();
            while (resultSet.next()) {
                Student s = new Student();
                s.setId(resultSet.getInt("id"));
                s.setName(resultSet.getString("name"));
                students.add(s);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
      
    public String getTitle() {return title;}
    public int getId() {return id;}
    
    public ArrayList<String> getQuizTitles() {
        ArrayList<String> results = new ArrayList<String>();
        try {
            ResultSet resultSet = statement.executeQuery("select title from quizzes");
            while (resultSet.next()) {
                results.add(resultSet.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return results;
    }
    
    public ArrayList<Student> getStudents() {
        return students;
    }
    
    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void grade() {
        try {
            float maxStudentPoints = 0;
            float maxQuestionPoints = 0;
            responsesStmt.setInt(1, 1);
            ResultSet resultSet = responsesStmt.executeQuery();
            while (resultSet.next()) {
                int i=0;
                for (Question q : questions) {
                    if (resultSet.getInt("question") == q.getId()) {
                        Question temp1 = q;
                        temp1.increasePoints();
                        questions.set(i,temp1);
                        if (temp1.getPoints() > maxQuestionPoints) {
                            maxQuestionPoints = temp1.getPoints();
                        }
                        int j=0;
                        for (Student s : students) {
                            if (resultSet.getInt("student") == s.getId()) {
                                Student temp2 = s;
                                temp2.increasePoints();
                                students.set(j,temp2);
                                if (temp2.getPoints() > maxStudentPoints) {
                                    maxStudentPoints = temp2.getPoints();
                                }
                                break;
                            }
                            j++;
                        }
                        break;
                    }
                    i++;
                }
            }
            //System.out.println(maxQuestionPoints);
            //System.out.println(maxStudentPoints);
            if (maxQuestionPoints != 0) {
                for (Question q : questions) {
                    //System.out.println(q.getPoints());
                    q.setPoints(q.getPoints()/maxQuestionPoints);
                }
            }
            if (maxStudentPoints != 0) {
                for (Student s : students) {
                    //System.out.println(s.getPoints());
                    s.setPoints(s.getPoints()/maxStudentPoints);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public String toString() {return title;}
    
}
