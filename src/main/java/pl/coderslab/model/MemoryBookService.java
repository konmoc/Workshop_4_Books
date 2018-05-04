package pl.coderslab.model;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemoryBookService implements BookService {

    private List<Book> list;
    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    //zwraca listę książek
    public List<Book> getList() {
        return list;
    }
    public void setList(List<Book> list) {
        this.list = list;
    }
    //zwraca książkę o konkretnym id
    public Book selectBookById(long id) {
        int intId = (int) id;
        Book book1 = null;
        for (Book book : list) {
            if (intId == book.getId()) {
                book1 = book;
            }
        }
        return book1;
    }

    //edytuje ksiażkę
    public void updateBook(long id,String isbn, String title, String author, String publisher, String type) {
        Book book = selectBookById(id);
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setType(type);
    }

    public void removeBook(long id){
        for (Book book: list) {
            if(book.getId()==id){
                list.remove(book);
            }
        }
    }

    public void addBook(long id,String isbn, String title, String author, String publisher, String type) {
        Book book = new Book();
        book.setId(id);
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setType(type);
        list.add(book);
    }




}

