package phone.book.dao;

import phone.book.model.User;

import java.util.List;

public interface UserDao {
    void save(User user);

    List<User> getUserList();
}
