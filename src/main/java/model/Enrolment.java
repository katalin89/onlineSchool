package model;

public class Enrolment {
    private  int id;
    private  int studentId;
    private int courseId;
    private String  createdAt;

    public  Enrolment(int studentId,int courseId,String createdAt){
        this.studentId=studentId;
        this.courseId=courseId;
        this.createdAt=createdAt;
    }

    public  Enrolment(int  id,int studentId,int courseId,String createdAt){
        this.id=id;
        this.studentId=studentId;
        this.courseId=courseId;
        this.createdAt=createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAtString (String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public  String toString(){
        String text="";
        text+=id+","+studentId+","+courseId+","+createdAt;
        return  text;
    }

    @Override
    public  boolean equals(Object obj){
        Enrolment enrolment=(Enrolment) obj;
        return  enrolment.createdAt==this.createdAt;
    }
}
