package model;

public class Course {
    private int id;
    private String name;
    private String department;
    private int profesorId;//foregn key sa se vada ca profesorul ce curs a creat

    public  Course(int id,String name,String department,int profesorId){
        this.id=id;
        this.name=name;
        this.department=department;
        this.profesorId=profesorId;
    }

    public int getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(int profesorId) {
        this.profesorId = profesorId;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    @Override
    public  String toString(){
        String text="";
        text+=id+","+name+","+department+","+profesorId;
        return  text;

    }

    @Override
    public  boolean equals(Object obj){
        Course course=(Course) obj;
        return  course.name==this.name;
    }
}
