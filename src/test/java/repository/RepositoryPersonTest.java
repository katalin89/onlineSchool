package repository;

import model.Course;
import model.Person;
import model.Profesor;
import model.Student;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryPersonTest {

    @Test
    void insertPerson() {
        RepositoryPerson repositoryPerson = new RepositoryPerson();
        Student student = new Student(1, "Dumitrescu", "Alessia", "alessia@yahoo.com", 19, "allesia","23645",8.80);
        repositoryPerson.insertPerson(student);
    }


    @Test
    void insertProfesor() {
        RepositoryPerson repositoryPerson = new RepositoryPerson();
        Profesor profesor = new Profesor(1, "Anton", "Valeriu", "vali@yahoo.com", 20, "vali","653654",18);
        repositoryPerson.insertPerson(profesor);
    }

    @Test
    void stergeById() {
        RepositoryPerson repositoryPerson = new RepositoryPerson();
        repositoryPerson.stergePersonById(9);
    }

    @Test
    public void cursurileStudentului() {
        RepositoryPerson repositoryPerson = new RepositoryPerson();
        List<String> cursuri = repositoryPerson.allStudentCurses(2);

    }

    @Test
    public  void login(){
        RepositoryPerson repositoryPerson = new RepositoryPerson();
        System.out.println(repositoryPerson.login("rebe","335"));
    }
    //moraru es profesor
    @Test
    public void allStudents(){
        RepositoryPerson repositoryPerson = new RepositoryPerson();
        List<String>students=repositoryPerson.allProfesorStudents(1);
        for(String a:students){
            System.out.println(a.toString());
        }
    }


}