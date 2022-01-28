package br.com.agls.service;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.agls.dao.UserDao;
import br.com.agls.entity.User;
import br.com.agls.exception.ExistingEntityException;
import br.com.agls.service.interfaces.UserService;

@Stateless
public class UserServiceImpl implements UserService{
	
	private Logger LOGGER = Logger.getLogger(UserServiceImpl.class.getName());

	@Inject
	private UserDao userDao;

	@Override
	public void save(User user) {
		if (user.getId() != null) {
			// Implementar lógica da atualização.
		} else {
			if(this.userDao.existsByEmail(user.getEmail())) {
				this.userDao.save(user);				
			} else {
				String message = "there is already a user record with the email: " + user.getEmail();
				LOGGER.warning(message);
				throw new ExistingEntityException(message);
			}
		}
	}
	
	@Override
	public List<User> list() {
		return this.userDao.list();
	}



}
