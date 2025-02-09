package crm08.services;

import java.util.ArrayList;
import java.util.List;

import javax.management.relation.Role;

import crm08.entity.RoleEntity;
import crm08.repository.RoleRepository;

public class RoleServices {

private RoleRepository roleRepository = new RoleRepository();
	
	public List<RoleEntity> getAllRoles() {
		return roleRepository.findAll();
	}

	public boolean insertRole(String name, String description) {
		return roleRepository.insertRoles(name, description) > 0;
	}
	
	public boolean deleteRoleById(int roleId) {
		int count = roleRepository.deleteByRoleId(roleId);

		return count > 0;
	}
	
	public RoleEntity getRoleById(int roleId) {
        return roleRepository.findRoleById(roleId);
    }

    public boolean updateRole(int roleId, String name, String description) {
        return roleRepository.updateRole(roleId, name, description) > 0;
    }
}
