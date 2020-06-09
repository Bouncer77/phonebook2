package phone.book.main;

import phone.book.dao.UserDao;
import phone.book.model.Phone;
import phone.book.model.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kosenkov Ivan on 09.06
 */
public class Main
{
    public static void main( String[] args ) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/beans.xml");

        UserDao userDAO = context.getBean(UserDao.class);

        ArrayList<Phone> personArrayList = new ArrayList<>();
        personArrayList.add(new Phone("89682255654"));

        User user1 = new User("Anton", personArrayList);
        //User user2 = new User("Ivan", personArrayList);
        //User user3 = new User("Marina", personArrayList);

        userDAO.save(user1);
        //userDAO.save(user2);
        //userDAO.save(user3);

        System.out.println("user1 : " + user1);
        //System.out.println("user2 : " + user2);
        //System.out.println("user3 : " + user3);

        List<User> list = userDAO.getUserList();
        //list.forEach(user -> System.out.println(user));
        for(User user : list){
            System.out.println("User List::"+user);
        }

        //close resources
        context.close();
    }
}
