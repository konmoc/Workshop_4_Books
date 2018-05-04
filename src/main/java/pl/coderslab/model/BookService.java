package pl.coderslab.model;

import java.util.List;

public interface BookService {
    public Book selectBookById(long id);
   // public void addNewBook(long id, String isbn, String title, String author, String publisher, String type);
    public void updateBook(long id,String isbn, String title, String author, String publisher, String type);
    public void removeBook(long id);
    public List<Book> getList();
    public void setList(List<Book> list);
}
