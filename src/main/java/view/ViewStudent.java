package view;


import exception.BookNotFoundException;
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
        //managementul cursurilor
        System.out.println("Apasa tasta 1 pentru a afla cursurile studentului");
        System.out.println("Apasa tasta 2 pentru Inscrie la curs");
        System.out.println("Apasa tasta 3 sa se stearga de la un curs");
        System.out.println("Apasa tasta 4 pentru a vedea toate cursurile");
        //Managmentul cartilor
        System.out.println("Apasa tasta 5 pentru a vedea cartile obtinute unui student");
        System.out.println("Apasa tasta 6 pentru a adauga un carte");
        System.out.println("Apasa tasta 7 pentru a sterge un carte");
        //detalii student
        System.out.println("Apasa taste 8 pentru a lista profesorii");
        System.out.println("Apasa tasta 9 pentru a lista detaliile unei student");
        System.out.println("Apasa tasta 10 pentru a modifica parola");
        System.out.println("Apasa tasta 11 pentru a modifica adresa email");
        System.out.println("Apasa tasta 12 pentru afisare toti studenti");
        System.out.println("Apasa tasta 13 pentru afisare toti studenti inscrisi la un curs");
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
                case 6:
                    adaugaUnCarte();
                    break;
                case 7:
                    stergeUnCarte();
                    break;
                case 8:
                    listaProfesorii();
                    break;
                case 9:
                    listaDetalii();
                    break;
                case 10:
                    modificareParola();
                    break;
                case 11:
                    modificareAdresaEmail();
                    break;
                case 12:
                    afisareTotiStudenti();
                    break;
                case 13:
                    afisareStudentiiInscrisiLaCurs();
                    break;
            }
        }
    }

    private void afisareStudentiiInscrisiLaCurs() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti numele cursului:");
        String course = scanner.nextLine();
        System.out.println("Studentii inscrisi la curs:");
        List<String> students =personRepository.getStudentsCurs(course);
        for (String s : students) {
            System.out.println(s);
        }
    }

    private void afisareTotiStudenti() {
        System.out.println("Studentii in unitatea de invatamant: ");
        List<String> students =personRepository.getAllStudents();
        for (String s : students) {
            System.out.println(s);
        }
    }

    private void modificareParola() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti parola actuala: ");
        String parola = scanner.nextLine();
        if (parola.equals(student.getPassword())){
            System.out.println("Introduceti parola noua: ");
            String newParola = scanner.nextLine();
            personRepository.updatePassword(student.getId(),newParola);
            System.out.println("Parola modificata cu succes.");
        } else {
            System.out.println("Parola nu a fost modificata.");
        }
    }

    private void modificareAdresaEmail() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti adresa de email: ");
        String email = scanner.nextLine();
        personRepository.updateEmail(student.getId(),email);
        System.out.println("Email modificat cu success.");
    }

    private void listaDetalii() {
        System.out.println("Detaliile Studentului:");
        Student student2 = personRepository.getStudentById(student.getId());
        System.out.println("Nume: " + student2.getFirstName());
        System.out.println("Prenume: " + student2.getLastName());
        System.out.println("Email: " + student2.getEmail());
        System.out.println("Varsta: " + student2.getAge());
        System.out.println("Medie: " + student2.getMedie());
        System.out.println("Username:" + student2.getUsername());
    }

    private void listaProfesorii() {
        System.out.println("Profesorii studentului sunt:");
        List<String> profesorii =  personRepository.getProfesorStudent(student.getId());
        for (String p : profesorii) {
            System.out.println(p);
        }
    }

    private void stergeUnCarte() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti id-ul cartelui:");
        int id = scanner.nextInt();
        //bookRepository.stergeBookById(id);
        System.out.println("Cartea a fost stearsa cu succes.");
    }

    private void adaugaUnCarte() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti numele cartelui:");
        String nume = scanner.nextLine();
        System.out.println("Introduceti data crearii a cartelui:");
        String dateCreated = scanner.nextLine();

        Book book= new Book(nume,dateCreated, student.getId() );
        bookRepository.insertBook(book);

        System.out.println("Cartea a fost adaugata cu succes");
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

