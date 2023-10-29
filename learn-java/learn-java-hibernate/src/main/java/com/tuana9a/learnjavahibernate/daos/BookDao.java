package com.tuana9a.learnjavahibernate.daos;

import com.tuana9a.learnjavahibernate.HibernateApplication;
import com.tuana9a.learnjavahibernate.models.Book;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class BookDao {
    private static final BookDao instance = new BookDao();

    public static BookDao getInstance() {
        return instance;
    }

    private BookDao() {

    }

    public void save(Book book) {
        SessionFactory factory = HibernateApplication.getInstance().getSessionFactory();
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(book);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public List<Book> findAll() {
        SessionFactory factory = HibernateApplication.getInstance().getSessionFactory();
        try (Session session = factory.openSession()) {
            return session.createQuery("SELECT b FROM Book b", Book.class).list();
        }
    }

    public List<Book> findByName(String name) {
        SessionFactory factory = HibernateApplication.getInstance().getSessionFactory();
        try (Session session = factory.openSession()) {
            String sql = "SELECT b FROM Book b WHERE b.name='" + name + "'";
            return session.createQuery(sql, Book.class).list();
        }
    }

    public Book findById(long id) {
        SessionFactory factory = HibernateApplication.getInstance().getSessionFactory();
        try (Session session = factory.openSession()) {
            String sql = "SELECT b FROM Book b WHERE b.id='" + id + "'";
            return session.createQuery(sql, Book.class).getSingleResult();
        }
    }

    public void update(Book newBook) {
        SessionFactory factory = HibernateApplication.getInstance().getSessionFactory();
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            Book existBook = session.get(Book.class, newBook.getId());
            existBook.setName(newBook.getName());
            existBook.setPublisher(newBook.getPublisher());
            session.update(existBook);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void delete(Long id) {
        SessionFactory factory = HibernateApplication.getInstance().getSessionFactory();
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            Book existBook = session.get(Book.class, id);
            if (existBook != null) {
                session.delete(existBook);
            }
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }


}
