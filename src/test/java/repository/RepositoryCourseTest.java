package repository;

import model.Course;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryCourseTest {

    @Test
    public void insertCourse() {
        RepositoryCourse repositoryCourse = new RepositoryCourse();
        Course course = new Course(1, "Geometrie", "Matematica", 2);
        repositoryCourse.insertCourse(course);
    }

    @Test
    public void deleteById() {
        RepositoryCourse repositoryCourse = new RepositoryCourse();
        repositoryCourse.stergeCourseById(5);

    }

    @Test
    public void update() {
        RepositoryCourse repositoryCourse = new RepositoryCourse();
        repositoryCourse.updateDepartament(1, "informatica");

    }

    @Test
    public void delete() {
        RepositoryCourse repositoryCourse = new RepositoryCourse();
        repositoryCourse.deleteName("Geometrie");

    }

    @Test
    public void allList() {
        RepositoryCourse repositoryCourse = new RepositoryCourse();
        List<Course>courses=repositoryCourse.allCourses();
        for(Course c:courses){
            System.out.println(c.toString());
        }

    }

    @Test
    public  void returnCurs(){
        RepositoryCourse repositoryCourse = new RepositoryCourse();

        Course curs=repositoryCourse.returnCursNume("matematica");
        System.out.println(curs.toString());
    }

}