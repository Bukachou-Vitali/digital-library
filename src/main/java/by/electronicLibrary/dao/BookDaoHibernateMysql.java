package by.electronicLibrary.dao;


import by.electronicLibrary.entity.Book;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import java.util.List;
import java.util.function.Consumer;

public class BookDaoHibernateMysql implements BookDao {

    @Override
    public List<Book> getAllBooks() {
        List<Book> allBooks = null;
        Transaction transaction = null;
        Session session = null;
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();
            session = factory.openSession();
            transaction = session.beginTransaction();
            allBooks = session.createQuery("FROM Book").list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return allBooks;
    }

    @Override
    public Book getBookById(int id) {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
             Session session = factory.openSession()) {
            Book book = session.get(Book.class, id);
            return book;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void createBook(Book book) {
        sessionCreate(session -> {
            session.save(book);
        });
    }

    @Override
    public void deleteBookById(int id) {
        sessionCreate(session -> {
            Book bookId = session.get(Book.class, id);
            session.delete(bookId);
        });
    }

    @Override
    public void updateBook(Book book) {
        sessionCreate(session -> {
            Book bookUpdate = (Book) session.get(Book.class, book.getId());
            bookUpdate.setName(book.getName());
            bookUpdate.setAuthor(book.getAuthor());
            bookUpdate.setYear(book.getYear());
            bookUpdate.setDescription(book.getDescription());
            session.update(bookUpdate);
        });
    }

    public void sessionCreate(Consumer<Session> s) {

        Transaction transaction = null;
        Session session = null;
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();
            session = factory.openSession();
            transaction = session.beginTransaction();
            s.accept(session);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
