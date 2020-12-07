package crud.springmvc.dao;

import crud.springmvc.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

//    @Autowired
//    private EntityManagerFactory entityManagerFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> listUsers() {
        Query query = entityManager.createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User getUserById(Long id) {
        return entityManager
                .createQuery("from User u where u.id = :id", User.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(User user) {
        entityManager.merge(user);
        entityManager.remove(user);
    }
}
