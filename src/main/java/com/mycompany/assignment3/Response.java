package com.mycompany.assignment3;

public class Response {
    
    private int id;
    private int student;
    private int question;
    private String response;
    private int correct;
    
    public Response() {}
    
    public int getId() { return id; }
    public int getStudent() { return student; }
    public int getQuestion() { return question; }
    public String getResponse() { return response; }
    public int getResult() { return correct; }
    
    public void setId(int id) { this.id = id; }
    public void setStudent(int student) { this.student = student; }
    public void setQuestion(int question) { this.question = question; }
    public void setResponse(String response) { this.response = response; }
    public void setResult(int correct) { this.correct = correct; }

}
