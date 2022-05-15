package repository;

import model.Person;
import model.Profesor;
import model.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryPersonTest {

    @Test
    void insertPerson() {
        RepositoryPerson repositoryPerson=new RepositoryPerson();
        Student student= new Student(1,"Dumitrescu","Alessia","alessia@yahoo.com",19,8.80);
        repositoryPerson.insertPerson(student);
    }


    @Test
    void insertProfesor() {
        RepositoryPerson repositoryPerson=new RepositoryPerson();
Profesor profesor=new Profesor(1,"Anton","Valeriu","vali@yahoo.com",20,18);
        repositoryPerson.insertPerson(profesor);
    }

    @Test
    void stergeById() {
        RepositoryPerson repositoryPerson=new RepositoryPerson();
        repositoryPerson.stergePersonById(9);
    }
}