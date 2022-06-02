package view;

import model.Person;

import java.util.Scanner;

public class ViewLogin extends View{

    public  ViewLogin(){
        login();
    }

    public  void meniu(){
        System.out.println("Apasa tasta 1 pentru login");
        System.out.println("Apasa tasta 2 pentru logout");
    }

    public  void play(){
        Scanner scanner= new Scanner(System.in);
        boolean run=true;
        int alegere=0;
        while(run==true){
            meniu();
            alegere=Integer.parseInt(scanner.nextLine());
            switch (alegere){
                case 1:login();
                break;
                case 2:logout();
                break;
            }
        }

    }
    public  void login(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Introduceti usernameul");
        String username= scanner.nextLine();
        System.out.println("Introduceti passwordul");
        String password=scanner.nextLine();
        System.out.println("Logare: ");
        Person logat=personRepository.login(username,password);
        if(logat==null){
            System.out.println("Nu este persoana");
        } else {
            if(logat.getType()=="student"){
                ViewStudent viewStudent = new ViewStudent();
            }else{
                ViewProfesor viewProfesor= new ViewProfesor();
            }
        }

    }

    public void logout(){
        System.out.println("Sunteti disconectat");
        String username="";
        String password="";
    }
}
/*


    }*/