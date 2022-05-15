package repository;

import model.Book;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryBookTest {

    @Test
    public  void insert(){
        RepositoryBook repositoryBook=new RepositoryBook();
        Book book=new Book(10,"Matematica","2003-02-02",2);
        repositoryBook.insertBook(book);
    }


    @Test
    public  void stergeById(){
        RepositoryBook repositoryBook=new RepositoryBook();
       repositoryBook.stergeBookById(5);
    }


    @Test
    public  void updateCreatedAt(){
        RepositoryBook repositoryBook=new RepositoryBook();
        repositoryBook.updateCreatedAt(1,"2022-12-12");
    }
    @Test
    public  void deleteNume(){
        RepositoryBook repositoryBook=new RepositoryBook();
        repositoryBook.deleteNume("ceva");
    }

    @Test
    public  void listBook(){
        RepositoryBook repositoryBook=new RepositoryBook();
        List<Book> books=repositoryBook.allBooks();
        for(Book b:books){
            System.out.println(b.toString());
        }
    }

}