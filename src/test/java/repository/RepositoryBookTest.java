package repository;

import exception.BookNotFoundException;
import model.Book;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryBookTest {

    @Test
    public  void insert(){
        RepositoryBook repositoryBook=new RepositoryBook();
        Book book=new Book(10,"Engleza","2003-02-02",2);
//        assertThrows(BookNotFoundException.class,()->{
//            repositoryBook.allBooks();
//        });
//        try {
//            repositoryBook.insertBook(book);
//        }catch (BookNotFoundException e){
//            e.printStackTrace();
//        }
//    }
/*assertThrows(MasinaExistsException.class, () -> {
            controllerMasina.delete("Opel");
        });*/

    @Test
    public  void stergeById(){
        RepositoryBook repositoryBook=new RepositoryBook();
        assertThrows(BookNotFoundException.class,()->{
            repositoryBook.stergeBookById(8);
        });

    }

    @Test
    public  void isBook(){
        RepositoryBook repositoryBook=new RepositoryBook();
        assertThrows(BookNotFoundException.class,()->{
            System.out.println( repositoryBook.findBooks(15).toString());
        });
        try {
            System.out.println(repositoryBook.findBooks(6).toString());
        }catch (BookNotFoundException e){
            e.printStackTrace();
        }


    }

    @Test
    public  void updateCreatedAt(){
        RepositoryBook repositoryBook=new RepositoryBook();
        repositoryBook.updateCreatedAt(1,"2022-12-12");
    }

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