package pl.coderslab.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.model.MemoryBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    MemoryBookService memo1;

    @RequestMapping("/hello")
    public String hello(){
        return "{hello: World}";
    }

    @RequestMapping("/helloBook")
    public Book helloBook(){
        return new Book(1,"9788324631766","Thinking in Java",
                "Bruce Eckel","Helion","programming");
    }

    //pobiera wszystkie książki - ok
    @GetMapping
    public List<Book> getAllBooks() throws JsonProcessingException {
        List<Book> books =  memo1.getList();
        return books;
    }

    //pobiera wszystkie książki - ok
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable long id) throws JsonProcessingException {
        Book book =  memo1.selectBookById(id);
        return book;
    }

    //dodaje książkę na podstawie parametrów z formularza
    @PostMapping
    public List<Book> postNewBook(@RequestParam("id") long id, @RequestParam("isbn") String isbn, @RequestParam("title") String title,
                                  @RequestParam("author") String author, @RequestParam("publisher") String publisher,
                                  @RequestParam("type") String type) {
        memo1.addBook(id,isbn,title,author,publisher,type);
        List<Book> list = memo1.getList();
        return list;
    }

    //edytuje daną książkę -ok
    @PutMapping("/{id}")
    public List<Book> updateBook(@RequestParam("id") long id, @RequestParam("isbn") String isbn, @RequestParam("title") String title,
                                 @RequestParam("author") String author, @RequestParam("publisher") String publisher, @RequestParam("type") String type) {
        memo1.updateBook(id,isbn,title,author,publisher,type);
        List<Book> list = memo1.getList();
        return list;
    }

    //usuwa książkę - ok
    @DeleteMapping("/{id}")
    public List<Book> deleteBook(long id) {
        memo1.removeBook(id);
        List<Book> list = memo1.getList();
        return list;
    }
}
