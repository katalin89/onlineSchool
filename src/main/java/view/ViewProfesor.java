package view;

import model.Course;
import model.Profesor;

import java.util.List;
import java.util.Scanner;

public class ViewProfesor extends  View{
    Profesor profesor;
    public  ViewProfesor(){
        profesor=new Profesor(10,"Tudor","Alin","alin@yahoo.com",45,"alin","3435",20);

    }

    public  void meniu(){
        System.out.println("Apasa tasta 1 pentru a afisa cursurile profesorului");
        System.out.println("Apasa tasta 2 pentru a modifica numarul orelor");
        System.out.println("Apasa tasta 3 pentru a afla la ce departament preda profesorul");
        //cat elevi are in total
        //cati elevi are in cursul respectiv


    }

    public  void play(){
        boolean run=true;
        int  alege=0;
        Scanner scanner=new Scanner(System.in);
        while ( run == true){
            meniu();
            alege=Integer.parseInt(scanner.nextLine());
            switch (alege){
                case 1:afiseazaCursProf();
                break;
                case 2:updateNrOrelor();
                break;
                case 3:returnDepartmentsProf();
                break;
            }
        }
    }
    public  void afiseazaCursProf(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Introdiceti numele profesorului carui doriti sa vedeti cursurile");
        String nume= scanner.nextLine();
        List<String>courses=courseRepository.getCoursesProfByName(nume);
        for(String  c:courses){
            System.out.println(c);
        }

    }

    public  void updateNrOrelor(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Introduceti id ul profesorului ");
        int id=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Introduceti numarul orelor actualizat");
        int nrDeOre= scanner.nextInt();
        personRepository.udateNrDeOreProfesor(id,nrDeOre);

    }

    public  void returnDepartmentsProf(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Inroduceti first nameul profesorului de care ne interesam");
        String firstName=scanner.nextLine();
        List<String >departments=courseRepository.getDepartmetsProf(firstName);
        for(String d:departments){
            System.out.println(d);
        }

    }

}
/*select first_name  from  enrolment
join person p on enrolment.student_id = p.id
join course c on c.id = enrolment.course_id
where course_id in (select course_id from course where c.profesor_id=1 );*/

/*select first_name  from  enrolment
join person p on enrolment.student_id = p.id
join course c on c.id = enrolment.course_id
where course_id in (select course_id from course where c.profesor_id=1 );
*/