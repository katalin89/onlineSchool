package repository;

import model.Enrolment;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RepositotyEnrolmentTest {

    @Test
    public  void insert(){
        RepositotyEnrolment repositotyEnrolment=new RepositotyEnrolment();
        Enrolment enrolment=new Enrolment(1,2,1,"2022-04-15");
        repositotyEnrolment.insertEnrolment(enrolment);
    }

    @Test
    public  void sterge(){
        RepositotyEnrolment repositotyEnrolment=new RepositotyEnrolment();
       repositotyEnrolment.stergeEnrolmentById(6);
    }

    @Test
    public  void updateCreatedAt(){
        RepositotyEnrolment repositotyEnrolment=new RepositotyEnrolment();
        repositotyEnrolment.updateCreatedAt(7,"1999-09-09");
    }

    @Test
    public  void allEnrolment(){
        RepositotyEnrolment repositotyEnrolment=new RepositotyEnrolment();
       List<Enrolment> enrolments=repositotyEnrolment.allEnrolments();
       for(Enrolment e:enrolments){
           System.out.println(e.toString());

       }
    }

}