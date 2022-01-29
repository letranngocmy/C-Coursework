package com.mycompany.assignment3;

public class Student {
    
    private int id;
    private String name;
    private float points;
    
    public Student() {
        points = 0;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public float getPoints() { return points; }
    
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPoints(float points) { this.points = points; }
    public void increasePoints() { points = points+1; }
    
}
