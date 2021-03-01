package by.electronicLibrary.dao;

import by.electronicLibrary.entity.Book;

import java.util.List;

public interface AllBooksDao {

    List<Book> getAllBooks();
    Book getBookById(int id);
    void createBook(Book book);
    void deleteBookById(int id);
    void updateBook(Book book);
}
