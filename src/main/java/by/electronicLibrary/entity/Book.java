package by.electronicLibrary.entity;


import javax.persistence.*;

@Entity
@Table(name = "all_books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book")
    private int id;

    @Column(name = "name_book")
    private String name;

    @Column(name = "book_author")
    private String author;

    @Column(name = "year")
    private int year;

    @Column(name = "description")
    private String description;

    public Book() {
    }

    public Book(String name, String author, int year, String description) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.description = description;
    }

    public Book(int idBook, String nameBook, String bookAuthor, int year, String description) {
        this.id = idBook;
        this.name = nameBook;
        this.author = bookAuthor;
        this.year = year;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
