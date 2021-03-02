package by.electronicLibrary.service;


import by.electronicLibrary.dao.BookDao;
import by.electronicLibrary.dao.BookDaoHibernateMysql;
import by.electronicLibrary.entity.Book;

import java.util.List;

public class BookService {

    private BookDao allBooksDao;

    public BookService() {
        this.allBooksDao = new BookDaoHibernateMysql();
    }

    public List<Book> getAllBooks() {
        List<Book> allBooks = allBooksDao.getAllBooks();
        return allBooks;
    }

    public Book getBookById(int id) {
        Book bookById = allBooksDao.getBookById(id);
        return bookById;
    }

    public void createBook(int id, String name, String author, int year, String description) {
        Book book = new Book(id, name, author, year, description);
        allBooksDao.createBook(book);
    }

    public void deleteBookById(int bookId) {
        allBooksDao.deleteBookById(bookId);
    }

    public void updateBook(int id, String newName, String newAuthor, int newYear, String newDescription) {
        Book book = new Book(id, newName, newAuthor, newYear, newDescription);
        allBooksDao.updateBook(book);
    }


}
