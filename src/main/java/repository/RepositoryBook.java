package repository;

import model.Book;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RepositoryBook extends  Repository{

    public RepositoryBook (){
      super();
    }

    public  void insertBook(Book book){
        String insertTo="";
        insertTo+=" insert into book(student_id,book_name,created_at)  values (";
        insertTo+=String.format(" %d, '%s','%s'",book.getStudentId(),book.getName(),book.getCreated_at());
        insertTo+=")";
        executeStatement(insertTo);

    }

    public void  stergeBookById(int id){
        String  text=String.format("delete from book where id= %d ",id);
        executeStatement(text);
    }

    public  void updateCreatedAt(int id,String created_at){

        String update="";
        update+=String.format("update book set created_at='%s'",created_at);
        update+=String.format("where id=%d",id);
        executeStatement(update);




    }


    public  void deleteNume(String nume){
        String delete="";
        delete+=String.format(" delete from book where book_name = '%s'",nume);
        executeStatement(delete);
    }

    private ResultSet allBook(){
        executeStatement("select * from book");
        try{
            return  statement.getResultSet();
        }catch (Exception e){
            System.out.println("Nu s-a executat schita");
            return  null;
        }
    }

    private ResultSet studentsBook(int id){
        executeStatement(String.format("select * from book where student_id=%d",id));
        try{
            return  statement .getResultSet();
        }catch (Exception e){
            System.out.println("Nu s-a executat schita");

            return  null;
        }



}

    public List<Book> allBooks(){
        ResultSet set= allBook();
        List<Book>books=new ArrayList<>();
        try{
            while(set.next()){
                books.add(new Book(set.getInt(1),set.getString(3),set.getString(4),set.getInt(2)));
            }
        }catch (Exception e){
            System.out.println("Nu sa creat lista");
        }
        return  books;

    }

    public List<Book>cartileStudentului(int id){
        ResultSet set=studentsBook(id);
        List<Book>books=new ArrayList<>();
        try{
            while(set.next()){
                books.add(new Book(set.getInt(1),set.getString(3),set.getString(4), set.getInt(2)));

            }
        }catch (Exception e){
            System.out.println("Nu s-a creat lista");
        }
        return  books;
    }
}
