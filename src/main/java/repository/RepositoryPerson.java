package repository;

import model.Course;
import model.Person;
import model.Profesor;
import model.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositoryPerson extends Repository{

    public RepositoryPerson(){
        super();
    }

    public  void insertPerson(Person person){
        String insertTo="";


        if (person.getType() == "profesor") {
            Profesor profesor=(Profesor) person;
            insertTo=("insert into person(first_name,last_name,email,age,type,numarDeCursuri)  values (" );
            insertTo+=String.format(" '%s', '%s', '%s', %d, '%s', %d",person.getFirstName(),person.getLastName(),person.getEmail(),person.getAge(),person.getType(),((Profesor) person).getNrDeCursuri());
            insertTo+=")";
            executeStatement(insertTo);
        }else if(person.getType()=="student"){
            Student student=(Student)person;
            insertTo=("insert into person (first_name,last_name,email,age,type,medie)  values (");
            //%.2f ->double doua decimale
            insertTo+=String.format("'%s','%s','%s',%d,'%s',%.2f",person.getFirstName(),person.getLastName(),person.getEmail(),person.getAge(),person.getType(),((Student) person).getMedie());
            insertTo+=" ) ";
            executeStatement(insertTo);
        }

    }

    public void stergePersonById(int id){
        String sterge=String.format("delete from person where id= %d",id);
        executeStatement(sterge);
    }

    private ResultSet allStudentCourse(int id){
        executeStatement("select name from enrolment " +
                "join course c on c.id = enrolment.course_id " +
                "where student_id="+id);

        try{
            return  statement.getResultSet();
        }catch (Exception e){
            System.out.println( "Nu s-a execuat schita");
            return null;
        }
    }

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






}
