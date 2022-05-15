import model.*;

public class Main {
     public static void main(String[] args) {
        Student student=new Student(1,"Tatar","Vlad","vlad@yahoo.com",23,8.50);
         Student student2=new Student(1,"Tatar","Vlad","vlad@yahoo.com",23,8.50);

         System.out.println(student.equals(student2));

    }
}
