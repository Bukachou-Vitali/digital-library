package by.electronicLibrary.service;


import by.electronicLibrary.dao.AllBooksDao;
import by.electronicLibrary.dao.AllBooksDaoHibernateMysql;
import by.electronicLibrary.entity.Book;

import java.util.List;

public class AllBooksService {

    private AllBooksDao allBooksDao;

    public AllBooksService() {
        this.allBooksDao = new AllBooksDaoHibernateMysql();
    }

    public List<Book> getAllBooks() {
        List<Book> allBooks = allBooksDao.getAllBooks();
        return allBooks;
    }

    public Book getBookById(int id) {
        Book bookById = allBooksDao.getBookById(id);
        return bookById;
    }

    public void createBook(int id, String name, String author) {
        Book book = new Book(id, name, author);
        allBooksDao.createBook(book);
    }

    public void deleteBookById(int bookId){
        allBooksDao.deleteBookById(bookId);
    }

    public void updateBook(int id, String newName, String newAuthor){
        Book book = new Book(id, newName, newAuthor);
        allBooksDao.updateBook(book);
    }


}
