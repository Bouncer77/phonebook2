package phone.book.dao;

import org.hibernate.SessionFactory;
import phone.book.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/*
 *   Created by Kosenkov Ivan on 09 8:42
 */
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(User user) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(user);
        tx.commit();
        session.close();
    }

    @Override
    public List<User> getUserList() {
        Session session = this.sessionFactory.openSession();
        String hql = "from User";
        List<User> userList = session.createQuery(hql).list();
        session.close();
        return userList;
    }
}
