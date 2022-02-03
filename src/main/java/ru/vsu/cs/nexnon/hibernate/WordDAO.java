package ru.vsu.cs.nexnon.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.vsu.cs.nexnon.hibernate.Word;
import java.util.List;

public class WordDAO {

    public Word findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Word.class, id);
    }

    public void save(Word word) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(word);
        tx1.commit();
        session.close();
    }

    public void update(Word word) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(word);
        tx1.commit();
        session.close();
    }

    public void delete(Word word) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(word);
        tx1.commit();
        session.close();
    }

    public List<Word> findAll() {
        return (List<Word>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("from Word").list();
    }
}
