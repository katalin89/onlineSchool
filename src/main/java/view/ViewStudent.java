package view;


import model.Course;
import model.Enrolment;
import model.Student;


import static view.View.*;

import java.util.List;
import java.util.Scanner;

public class ViewStudent {

    Student student;
    public  ViewStudent(){

        student= new Student(7,"Tatar","Mihai","mihai@yahoo.com",21,8.50);
    }

    public  void meniu(){
        System.out.println("Apasa tasta 1 pentru a afla cursurile studentului");
        System.out.println("Apasa tasta 2 pentru Inscrie la curs");
        System.out.println("Apasa tasta 3 sa se stearga de la un curs");




    }

    public  void play(){
        boolean run=true;
        int alege=0;
        Scanner scanner=new Scanner(System.in);
        while(run==true){
            meniu();
            alege=Integer.parseInt(scanner.nextLine());
            switch (alege){
                case 1: cursurileStudentului();
                break;
                case 2:inscrieCurs();
                break;

            }

        }
    }

    public void cursurileStudentului(){
        System.out.println("Sunt inscrisi la cursuri");
       List<String>cursuri=personRepository.allStudentCurses(student.getId());
       for(String c:cursuri){
           System.out.println(c.toString());
       }
    }

    public  void inscrieCurs(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Indtroduceti numele cursului la care doriti sa va inscrieti");
        String name=scanner.nextLine();
         Course course= courseRepository.returnCursNume(name);

         if(course!=null){
             Enrolment e=new Enrolment(student.getId(),course.getId(),"1999-09-19");
                     enrolmetRepository.insertEnrolment(e);

         }

        System.out.println(" V-ati inscris la "+course.getName());

    }
}

