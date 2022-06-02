package model;

public class Profesor  extends  Person{


    private  int nrDeCursuri;

    public  Profesor(int id,String firstName,String lastName,String email,int age,String username,String password,int nrDeCursuri){
        super(id,firstName,lastName,email,age,"profesor",username,password);
        this.nrDeCursuri=nrDeCursuri;
    }

    public int getNrDeCursuri() {
        return nrDeCursuri;
    }

    public void setNrDeCursuri(int nrDeCursuri) {
        this.nrDeCursuri = nrDeCursuri;
    }

    @Override
    public  String toString(){
        String text=super.toString();
        text+=","+nrDeCursuri;
        return  text;
    }

    @Override
    public  boolean equals(Object obj){
        Profesor profesor=(Profesor)obj;
        return profesor.nrDeCursuri==this.nrDeCursuri;
    }
}
