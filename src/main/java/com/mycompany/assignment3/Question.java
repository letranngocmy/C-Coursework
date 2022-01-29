/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment3;

public class Question {

    private String subject;
    private String question;
    private String choices;
    private String answer;
    private int id;
    private int quiz;
    private float points;

    public Question() {
        points = 0;
    }

    public Question(String subject, String question, String choices, String answer, int quiz) {
        this.subject = subject;
        this.question = question;
        this.choices = choices;
        this.answer = answer;
        this.quiz = quiz;
        points = 0;
    }

    public String getSubject() {return subject;}
    public String getQuestion() {return question;}
    public String getChoices() {return choices;}
    public String getAnswer() {return answer;}
    public int getId() {return id;}
    public int getQuiz() {return quiz;}
    public float getPoints() { return points; }
    
    public void setSubject(String s) {subject = s;}
    public void setQuestion(String s) {question = s;}
    public void setChoices(String s) {choices = s;}
    public void setAnswer(String s) {answer = s;}
    public void setId(int n) {id = n;}
    public void setQuiz(int n) {quiz = n;}
    public void setPoints(float points) { this.points = points; }
    public void increasePoints() { points = points+1; }
    
}