package crud.springmvc.service;

import crud.springmvc.dao.UserDao;
import crud.springmvc.model.Role;
import crud.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImp implements UserService, UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleService roleService;

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
        System.out.println("in addUser UserServiceImp");
        System.out.println("user= " + user);
        Role role = roleService.getRoleByRole("ROLE_USER");
        System.out.println("role =" + role);
        user.addRole(role);
        userDao.addUser(user);
    }

    @Transactional
    @Override
    public void updateUser(Long id, User user) {
//        Set<Role> roles = new HashSet<>();
//        Role role = new Role("ROLE_USER", "Пользователь");
//        roles.add(role);
//        user.setRoles(roles);
        System.out.println("id = " + id);
        System.out.println("user " + user);
        user.setId(id);
//        user.setRoles(userDao.getUserById(id).getRoles());
        Role role = roleService.getRoleByRole("ROLE_USER");
        user.addRole(role);
        userDao.updateUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        User user = userDao.getUserById(id);
        userDao.deleteUser(user);
    }

    @Transactional
    @Override
    public User getUserByLogin(String login) {
        return userDao.getUserByLogin(login);
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userDao.getUserByLogin(s);
    }
}
