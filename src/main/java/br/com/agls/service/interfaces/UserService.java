package br.com.agls.service.interfaces;

import java.util.List;

import br.com.agls.entity.User;

public interface UserService {
	
	public void save(User user);

	public List<User> list();
}
