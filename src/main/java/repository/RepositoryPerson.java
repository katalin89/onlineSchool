package repository;

import model.Person;
import model.Profesor;
import model.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositoryPerson extends Repository {

    public RepositoryPerson() {
        super();
    }

    public void insertPerson(Person person) {
        String insertTo = "";


        if (person.getType() == "profesor") {
            Profesor profesor = (Profesor) person;
            insertTo = ("insert into person(first_name,last_name,email,age,type,numarDeCursuri)  values (");
            insertTo += String.format(" '%s', '%s', '%s', %d, '%s', %d", person.getFirstName(), person.getLastName(), person.getEmail(), person.getAge(), person.getType(), ((Profesor) person).getNrDeCursuri());
            insertTo += ")";
            executeStatement(insertTo);
        } else if (person.getType() == "student") {
            Student student = (Student) person;
            insertTo = ("insert into person (first_name,last_name,email,age,type,medie)  values (");
            //%.2f ->double doua decimale
            insertTo += String.format("'%s','%s','%s',%d,'%s',%.2f", person.getFirstName(), person.getLastName(), person.getEmail(), person.getAge(), person.getType(), ((Student) person).getMedie());
            insertTo += " ) ";
            executeStatement(insertTo);
        }

    }

    public void stergePersonById(int id) {
        String sterge = String.format("delete from person where id= %d", id);
        executeStatement(sterge);
    }

    public Student getStudentById(int id) {
        String login = String.format("select * from person where id ='%d'", id);
        executeStatement(login);
        try {
            ResultSet result = statement.getResultSet();
            if (result != null) {
                result.next();
                return new Student(result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getInt(5),
                        result.getString(6),
                        result.getString(7),
                        result.getDouble(8));
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Nu s-a executat schita");
            return null;
        }
    }

    public Profesor getProfesorById(int id) {
        String login = String.format("select * from person where id ='%d'", id);
        executeStatement(login);
        try {
            ResultSet result = statement.getResultSet();
            if (result != null) {
                result.next();
                return new Profesor(result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getInt(5),
                        result.getString(6),
                        result.getString(7),
                        result.getInt(8));
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Nu s-a executat schita");
            return null;
        }
    }

    public void udateNrDeOreProfesor(int id, int nrDeOre) {
        String update = "";
        update += String.format(" update person set numarDeCursuri = %d  where id= %d", nrDeOre, id);
        executeStatement(update);
    }


    private ResultSet allStudentCourse(int id) {
        executeStatement("select name from enrolment " +
                "join course c on c.id = enrolment.course_id " +
                "where student_id=" + id);
        try {
            return statement.getResultSet();
        } catch (Exception e) {
            System.out.println("Nu s-a execuat schita");
            return null;
        }
    }

    public List<String> allStudentCurses(int id) {
        ResultSet set = allStudentCourse(id);
        List<String> courses = new ArrayList<>();
        try {
            while (set.next()) {
                courses.add(set.getString(1));
            }

            return courses;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return Collections.emptyList();
    }

    public Person login(String username, String password) {
        String login = String.format("select * from person where username ='%s' and password='%s'", username, password);
        executeStatement(login);
        try {
            ResultSet result = statement.getResultSet();
            if (result != null) {
                result.next();
                return new Person(result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getInt(5),
                        result.getString(6),
                        result.getString(7),
                        result.getString(8));
            } else return null;
        } catch (Exception e) {
            System.out.println("Nu s-a executat schita");
            return null;
        }
    }

    private ResultSet allBook() {
        executeStatement("select * from book");
        try {
            return statement.getResultSet();
        } catch (Exception e) {
            System.out.println("Nu s-a executat schita");
            return null;
        }

    }

    private ResultSet allProdfesorsStudent(int id) {
        executeStatement(String.format("select first_name  from  enrolment join person p on enrolment.student_id = p.id join course c on c.id = enrolment.course_id where course_id in (select course_id from course where c.profesor_id=%d )", id));
        try {
            return statement.getResultSet();
        } catch (Exception e) {
            System.out.println("Nu s-a execuat schita");
            return null;
        }
    }

    public List<String> allProfesorStudents(int id) {
        ResultSet set = allProdfesorsStudent(id);
        List<String> studenti = new ArrayList<>();
        try {
            while (set.next()) {
                studenti.add(set.getString(1));
            }
            return studenti;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Collections.emptyList();
    }

    public List<String> getProfesorDepartment(String nume){
        executeStatement(String.format("select  first_name, last_name  from course c\n" +
                "join person p on p.id=c.profesor_id\n" +
                " where c.department='%s'", nume));
        try {
             ResultSet set = statement.getResultSet();
             ArrayList<String> numeProfesor = new ArrayList<>();
             while (set.next()) {
                numeProfesor.add(set.getString(1) + " " + set.getString(2));
            }
             return numeProfesor;
        } catch (Exception e) {
            System.out.println("Nu s-a executat schita");
            return null;
        }
    }

/*

    public List<String>allStudentCurses(int id){
        ResultSet set=allStudentCourse(id);
        List<String>courses=new ArrayList<>();
        try{
            while(set.next()){


                courses.add(set.getString(1));

            }

            return  courses;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return Collections.emptyList();
    }




select first_name  from  enrolment
join person p on enrolment.student_id = p.id
join course c on c.id = enrolment.course_id
where course_id in (select course_id from course where c.profesor_id=1 );*/


}
