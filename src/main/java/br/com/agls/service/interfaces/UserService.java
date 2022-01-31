package br.com.agls.service.interfaces;

import java.util.List;

import br.com.agls.entity.User;

public interface UserService {
	
	public void save(User user);
	
	public void delete(Long userId);

	public List<User> list();

	public User find(Long userId);
}
