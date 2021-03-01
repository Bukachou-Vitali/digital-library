package by.electronicLibrary.entity;


import javax.persistence.*;

@Entity
@Table(name = "all_books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book")
    private int idBook;

    @Column(name = "name_book")
    private String  nameBook;

    @Column(name = "book_author")
    private String bookAuthor;

    public Book() {
    }

    public Book(String nameBook, String bookAuthor) {
        this.nameBook = nameBook;
        this.bookAuthor = bookAuthor;
    }

    public Book(int idBook, String nameBook, String bookAuthor) {
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.bookAuthor = bookAuthor;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }
}
