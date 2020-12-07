package crud.springmvc.service;

import crud.springmvc.dao.UserDao;
import crud.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional
    @Override
    public void updateUser(Long id, User user) {
        user.setId(id);
        userDao.updateUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        User user = userDao.getUserById(id);
        userDao.deleteUser(user);
    }
}
