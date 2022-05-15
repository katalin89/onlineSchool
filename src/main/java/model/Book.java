package model;

import java.time.LocalDate;

public class Book {
    private int id;
    private String name;
    private String createdAt;
    private int studentId;

    public Book(){};
    public  Book(int id,String name,String createdAt,int studentId){
        this.id=id;
        this.name=name;
        this.createdAt=createdAt;
        this.studentId =studentId;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreated_at() {
        return createdAt;
    }

    public void setCreated_at(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    @Override
    public  String toString(){
        String text="";
        text+=id+","+name+","+createdAt+","+ studentId;
        return  text;
    }

    @Override
    public  boolean equals(Object obj){
        Book book=(Book) obj;
        return book.createdAt==this.createdAt;
    }
}
