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
    private String nameBook;

    @Column(name = "book_author")
    private String bookAuthor;

    @Column(name = "year")
    private int year;

    @Column(name = "description")
    private String description;

    public Book() {
    }

    public Book(int idBook, String nameBook, String bookAuthor, int year, String description) {
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.bookAuthor = bookAuthor;
        this.year = year;
        this.description = description;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
