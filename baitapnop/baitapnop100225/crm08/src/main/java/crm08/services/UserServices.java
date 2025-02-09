package crm08.services;

import java.util.List;

import crm08.entity.RoleEntity;
import crm08.repository.RoleRepository;

// Xử lý logic code cho UserController
public class UserServices {

	private RoleRepository roleRepository = new RoleRepository();
	
	public List<RoleEntity> getRoles() {
		List<RoleEntity> roles = roleRepository.findAll();
		
		return roles;
	}
	
}
