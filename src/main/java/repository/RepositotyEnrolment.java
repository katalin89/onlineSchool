package repository;

import model.Enrolment;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RepositotyEnrolment extends  Repository {
    public RepositotyEnrolment(){
        super();
    }

    public  void insertEnrolment(Enrolment enrolment){
        String insertTo="";
        insertTo+="insert into enrolment ( student_id, course_id,created_at) values(";
        insertTo+=String.format("%d, %d, '%s'",enrolment.getStudentId(),enrolment.getCourseId(),enrolment.getCreatedAt());
        insertTo+=")";
        executeStatement(insertTo);

    }

    public  void stergeEnrolmentById(int id){
        String delete=String.format("delete from enrolment where id = %d",id);
        executeStatement(delete);


    }
    public  void updateCreatedAt(int id,String created_at){
        String  update=String.format("update enrolment set created_at = '%s'",created_at);
        update+=String.format("where id= %d",id);
        executeStatement(update);
    }
    private ResultSet allEnrolment(){
        executeStatement("select * from enrolment");
        try {
            return  statement.getResultSet();

        }catch (Exception e){
            System.out.println("Nu s-a executat schita");
            return  null;
        }
    }

    public List<Enrolment> allEnrolments(){
        ResultSet set=allEnrolment();
        List<Enrolment>enrolments=new ArrayList<>();
        try{
            while(set.next()){
                enrolments.add(new Enrolment(set.getInt(1),set.getInt(2),set.getInt(3),set.getString(4)));
            }
        }catch (Exception e){
            System.out.println("Nu s-a creat lista");
        }
        return  enrolments;
    }
}

