package view;

import model.Course;
import model.Person;
import model.Profesor;

import java.util.List;
import java.util.Scanner;

public class ViewProfesor extends View {
    Profesor profesor;

    public ViewProfesor(Profesor profesor) {
        this.profesor = profesor;
        play();
    }

    public ViewProfesor() {
        profesor = new Profesor(10, "Tudor", "Alin", "alin@yahoo.com", 45, "alin", "3435", 20);
    }

    public void meniu() {
        System.out.println("Apasa tasta 1 pentru a afisa cursurile profesorului");
        System.out.println("Apasa tasta 2 pentru a modifica numarul orelor");
        System.out.println("Apasa tasta 3 pentru a afla la ce departament preda profesorul");
        System.out.println("Apasa tasta 4 pentru a afla cati elevi are profesorul");
        System.out.println("Apasa tasta 5 pentru a afla cati elevi are in cursul respectiv ");
        System.out.println("Apasa tasta 6 pentru a modifica profesorul alocat unei curs ");
        System.out.println("Apasa tasta 7 pentru a afisa toti profesori a unui departament ");
        System.out.println("Apasa tasta 8 pentru a modifica parola ");
        System.out.println("Apasa tasta 9 pentru a lista toate profesorii ");
        System.out.println("Apasa tasta 10 pentru a lista studentii in ordine descrescator dupa medie ");
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
                    afiseazaCursProf();
                    break;
                case 2:
                    updateNrOrelor();
                    break;
                case 3:
                    returnDepartmentsProf();
                    break;
                case 4:
                    allStudentiiProfesorului();
                    break;
                case 5:
                    printStudentNumberOfCourse();
                    break;
                case 6:
                    inscriereProfesorLaCurs();
                    break;
                case 7:
                    printProfesoriLaDepartament();
                    break;
                case 8:
                    modificareParola();
                    break;
                case 9:
                    printTotiProfesori();
                    break;
                case 10:
                    printMedieElevilor();
                    break;
            }
        }
    }

    private void printMedieElevilor() {
        System.out.println("Studenti in ordine descrescator dupa medie:");
        List<String> students = personRepository.getAllStudentsOrdonatMedie();
        for (String s : students) {
            System.out.println(s);
        }
    }

    private void printTotiProfesori() {
        System.out.println("Profesorii din unitatea de invatamant: ");
        List<String> profesors= personRepository.getAllProfesors();
        for (String p : profesors) {
            System.out.println(p);
        }
    }

    private void modificareParola() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti parola actuala: ");
        String parola = scanner.nextLine();
        if (parola.equals(profesor.getPassword())){
            System.out.println("Introduceti parola noua: ");
            String newParola = scanner.nextLine();
            personRepository.updatePassword(profesor.getId(),newParola);
            System.out.println("Parola modificata cu succes.");
        } else {
            System.out.println("Parola nu a fost modificata.");
        }
    }

    private void printProfesoriLaDepartament() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introdiceti numele departamentului:");
        String nume = scanner.nextLine();
        List<String> departamente = personRepository.getProfesorDepartment(nume);
        for (String d : departamente) {
            System.out.println(d);
        }
    }

    private void inscriereProfesorLaCurs() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introdiceti numele cursului:");
        String nume = scanner.nextLine();
        Course course = courseRepository.getCourseByName(nume);
        if (course != null) {
            System.out.println("Cursul este alocat profesorului cu id: " + course.getProfesorId() + " suprascriem ?");
            System.out.println("1. Da");
            System.out.println("2. Nu");

            String alegere = scanner.nextLine();
            if (alegere.equals("1")) {
                courseRepository.updateProfesor(course.getId(), profesor.getId());
                System.out.println("Cursul cu nume: " + course.getName() + " a fost alocat la profesor:"
                        + profesor.getFirstName() + " " + profesor.getLastName());
            } else {
                System.out.println("Alocare nu a fost facuta.");
            }
        }
    }

    private void printStudentNumberOfCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introdiceti numele cursului:");
        String nume = scanner.nextLine();

        int studentCount = courseRepository.getStudentNumberOfCourse(nume);

        System.out.println("Numarul elevilor inscrisi la curs:" + studentCount);
    }

    public void afiseazaCursProf() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introdiceti numele profesorului carui doriti sa vedeti cursurile");
        String nume = scanner.nextLine();
        List<String> courses = courseRepository.getCoursesProfByName(nume);
        for (String c : courses) {
            System.out.println(c);
        }
    }

    public void updateNrOrelor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti id ul profesorului ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Introduceti numarul orelor actualizat");
        int nrDeOre = scanner.nextInt();
        personRepository.udateNrDeOreProfesor(id, nrDeOre);
        System.out.println("Orele actualizate!");
    }

    public void returnDepartmentsProf() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inroduceti first nameul profesorului de care ne interesam");
        String firstName = scanner.nextLine();
        List<String> departments = courseRepository.getDepartmetsProf(firstName);
        for (String d : departments) {
            System.out.println(d);
        }
    }

    public void allStudentiiProfesorului() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti idul profesorului:");
        int id = scanner.nextInt();
        List<String> studenti = personRepository.allProfesorStudents(id);
        for (String s : studenti) {
            System.out.println(s);
        }
    }

}