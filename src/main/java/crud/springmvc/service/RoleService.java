package crud.springmvc.service;

import crud.springmvc.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> listRole();

//    User getUserById(Long id);

    void addRole(Role role);

    void updateRole(Role role);

    void deleteRole(Role role);

    Role getRoleByRole(String role);
}
