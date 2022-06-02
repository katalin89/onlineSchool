package model;

import java.util.List;

public class Student extends  Person{

    private double medie;
    public Student(int id,String firstName,String lastName,String email,int age,String username,String password,double medie){
        super(id,firstName,lastName,email,age,"student",username,password);
        this.medie=medie;
    }

    public double getMedie() {
        return medie;
    }

    public void setMedie(double medie) {
        this.medie = medie;
    }

    @Override
    public  String toString(){
        String text=super.toString();
        text+=","+medie;
        return  text;

    }
    @Override

    public boolean equals(Object obj){
        Student student=(Student) obj;
        return  student.medie==this.medie;

    }
}
