package view;

import repository.Repository;
import repository.RepositoryBook;
import repository.RepositoryCourse;
import repository.RepositoryPerson;

public  abstract class View {


    public  static final RepositoryBook bookRepository= new RepositoryBook();
    public  static final RepositoryCourse courseRepository=new RepositoryCourse();
    public  static  final RepositoryPerson personRepository=new RepositoryPerson();



}
