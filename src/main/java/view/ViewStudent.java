package view;

import java.util.Scanner;

public class ViewStudent extends  View{
    public  ViewStudent(){
        super();
    }

    public  void meniu(){
        System.out.println("Apasa tasta 1 pentru a  insera un student");
        System.out.println("Apasa tasta 2 pentru a sterge un student");


    }

    public  void play(){
        boolean run=true;
        int alege=0;
        Scanner scanner=new Scanner(System.in);
        while(run==true){
            meniu();
            alege=Integer.parseInt(scanner.nextLine());
            switch (alege){
                case 1: insertStudent();
                break;
            }

        }
    }

    public  void insertStudent(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Introduceti id-ul studentului");
        int id=Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti first_name");
        String firrst_name=scanner.nextLine();

    }
}

