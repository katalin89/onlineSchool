package repository;

import model.Course;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RepositoryCourse extends Repository {

    public RepositoryCourse() {
        super();
    }

    public void insertCourse(Course course) {
        String insertTo = "";
        insertTo += "insert into course ( name , department , profesor_id )  values(";
        insertTo += String.format(" '%s' , '%s', %d", course.getName(), course.getDepartment(), course.getProfesorId());
        insertTo += ")";
        executeStatement(insertTo);
    }

    public void stergeCourseById(int id) {
        String text = String.format("delete from course where id = %d", id);
        executeStatement(text);
    }

    public void updateDepartament(int id, String department) {
        String update = "";
        update += String.format("update course set department= '%s '", department);
        update += String.format("where  id = %d", id);
        executeStatement(update);
    }

    public void deleteName(String nume) {
        String delete = "";
        delete += String.format("delete from course where name = '%s'", nume);
        executeStatement(delete);
    }

    private ResultSet allCourse() {
        executeStatement("select * from course");
        try {
            return statement.getResultSet();
        } catch (Exception e) {
            System.out.println("Nu s-a executat schita");
            return null;
        }
    }

    public List<Course> allCourses() {
        ResultSet set = allCourse();
        List<Course> courses = new ArrayList<>();
        try {
            while (set.next()) {
                courses.add(new Course(set.getInt(1), set.getString(2), set.getString(3), set.getInt(4)));
            }
        } catch (Exception e) {
            System.out.println("Nu s-a creat lista");
        }
        return courses;
    }


    private ResultSet returnCursName(String name) {

        executeStatement(String.format(" select  *  from  course  where  name = '%s'", name));
        try {
            return statement.getResultSet();
        } catch (Exception e) {
            System.out.println("Nu s-a execuat schita");
            return null;
        }
    }

    public Course returnCursNume(String nume) {
        ResultSet set = returnCursName(nume);

        List<Course> courses = new ArrayList<>();
        try {
            while (set.next()) {
                courses.add(new Course(set.getInt(1), set.getString(2), set.getString(3), set.getInt(4)));
            }
            return courses.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;


    }

    private ResultSet returnCursulProf(String firstName) {
        executeStatement(String.format("select name from course\n" +
                "join person p on course.profesor_id = p.id\n" +
                "where  first_name='%s'", firstName));
        try {
            return statement.getResultSet();
        } catch (Exception e) {
            System.out.println("Nu s-a executat schita");
            return null;
        }
    }

    public List getCoursesProfByName(String firstName) {
        ResultSet set = returnCursulProf(firstName);
        List<String> cursuri = new ArrayList<>();
        try {
            while (set.next()) {
                cursuri.add(set.getString(1));

            }
            return cursuri;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    //return departametul la care preda prodesorul
    private ResultSet returnDepartament(String firstName){
        executeStatement(String.format("select department from course join person p on course.profesor_id = p.id where first_name='%s'",firstName));

        try{
            return statement.getResultSet();

        }catch (Exception e){
            System.out.println("Nu s-a executat schita");
            return  null;
        }
    }

    public  List getDepartmetsProf(String firstName){
       ResultSet set=returnDepartament(firstName);
       List<String>departments=new ArrayList<>();
       try{
           while(set.next()){
               departments.add(set.getString(1));

           }
           return  departments;
       }catch ( Exception e){
           e.printStackTrace();
           return  null;
       }
    }


}
