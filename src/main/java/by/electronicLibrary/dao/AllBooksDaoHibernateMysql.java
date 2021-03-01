package by.electronicLibrary.dao;

import by.electronicLibrary.entity.Book;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class AllBooksDaoHibernateMysql implements AllBooksDao {

    @Override
    public List<Book> getAllBooks() {
        return null;
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
        Transaction transaction = null;
        Session session = null;
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null){
                session.close();
            }
        }
    }

    @Override
    public void deleteBookById(int id) {

    }

    @Override
    public void updateBook(Book book) {

    }
}
