package crud.springmvc.dao;

import crud.springmvc.model.Role;
import crud.springmvc.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class RoleDaoImp implements RoleDao {

//    @Autowired
//    private EntityManagerFactory entityManagerFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> listRole() {
        Query query = entityManager.createQuery("select distinct r from Role r join fetch r.users");
        return query.getResultList();
    }

    @Override
    public Role getRoleByRole(String role) {
        return entityManager
                .createQuery("from Role r join fetch r.users where r.role = :role", Role.class)
                .setParameter("role", role)
                .getSingleResult();
    }

    @Override
    public void addRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void updateRole(Role role) {
        entityManager.merge(role);
    }

    @Override
    public void deleteRole(Role role) {
        entityManager.remove(role);
    }
}
