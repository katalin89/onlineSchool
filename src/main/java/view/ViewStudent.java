package view;


import model.*;

import java.util.List;
import java.util.Scanner;

public class ViewStudent extends View {

    Student student;

    public ViewStudent(Student student) {
        this.student = student;
        play();
    }

    public ViewStudent() {
        student = new Student(7, "Tatar", "Mihai", "mihai@yahoo.com", 21, "mihai", "2355", 8.50);
    }

    public void meniu() {
        System.out.println("Apasa tasta 1 pentru a afla cursurile studentului");
        System.out.println("Apasa tasta 2 pentru Inscrie la curs");
        System.out.println("Apasa tasta 3 sa se stearga de la un curs");
        System.out.println("Apasa tasta 4 pentru a vedea toate cursurile");
        //Managmentul cartilor
        System.out.println("Apasa tasta 5 pentru a vedea cartile obtinute unui student");
    }

    public void play() {
        boolean run = true;
        int alege = 0;
        Scanner scanner = new Scanner(System.in);
        while (run == true) {
            meniu();
            alege = Integer.parseInt(scanner.nextLine());
            switch (alege) {
                case 1:
                    cursurileStudentului();
                    break;
                case 2:
                    inscrieCurs();
                    break;
                case 3:
                    stergeCurs();
                    break;
                case 4:
                    cursurile();
                    break;
                case 5:
                    cartileStud();
                    break;
            }
        }
    }

    public void cursurileStudentului() {
        System.out.println("Sunt inscrisi la cursuri");
        List<String> cursuri = personRepository.allStudentCurses(student.getId());
        for (String c : cursuri) {
            System.out.println(c.toString());
        }
    }

    public void inscrieCurs() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indtroduceti numele cursului la care doriti sa va inscrieti");
        String name = scanner.nextLine();
        Course course = courseRepository.returnCursNume(name);

        if (course != null) {
            Enrolment e = new Enrolment(student.getId(), course.getId(), "1999-09-19");
            enrolmetRepository.insertEnrolment(e);

        }

        System.out.println(" V-ati inscris la " + course.getName());
    }

    public void stergeCurs() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceto id-ul studentului care doriti sa-l stergeti");
        int id = scanner.nextInt();
        personRepository.stergePersonById(id);
        System.out.println("S-a sters");


    }

    public void cursurile() {
        System.out.println("Cursurile institutiei sunt :");
        List<Course> courses = courseRepository.allCourses();
        for (Course c : courses) {
            System.out.println(c.toString());
        }
    }

    public void cartileStud() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introducet id ul studentului carui vrem sa vedem cartile");
        int id = scanner.nextInt();
        List<Book> books = bookRepository.cartileStudentului(id);
        for (Book b : books) {
            System.out.println(b.toString());
        }
    }
}

