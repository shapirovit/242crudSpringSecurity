package crud.springmvc.service;

import crud.springmvc.dao.RoleDao;
import crud.springmvc.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Transactional(readOnly = true)
    @Override
    public List<Role> listRole() {
        return roleDao.listRole();
    }

    @Transactional
    @Override
    public void addRole(Role role) {
        roleDao.addRole(role);
    }

    @Transactional
    @Override
    public void updateRole(Role role) {
        roleDao.updateRole(role);
    }

    @Transactional
    @Override
    public void deleteRole(Role role) {
        roleDao.deleteRole(role);
    }

    @Transactional(readOnly = true)
    @Override
    public Role getRoleByRole(String role) {
        return roleDao.getRoleByRole(role);
    }
}
