package br.com.agls.service;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.agls.dao.UserDao;
import br.com.agls.entity.User;
import br.com.agls.exception.ExistingEntityException;
import br.com.agls.service.interfaces.UserService;
import br.com.agls.utils.TodoUtils;

@Stateless
public class UserServiceImpl implements UserService{
	
	private Logger LOGGER = Logger.getLogger(UserServiceImpl.class.getName());

	@Inject
	private UserDao userDao;

	@Override
	public void save(User user) {
		if (user.getId() != null) {
			User userFound = find(user.getId());
			TodoUtils.updateFields(user, userFound);
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
	public User find(Long userId) {
		User userFound = this.userDao.findById(userId);
		String className = User.class.getName();
		TodoUtils.checkIsNotNull(userFound, userId, className);
		return userFound;
	}
	
	@Override
	public List<User> list() {
		return this.userDao.list();
	}
	
	@Override
	public void delete(Long userId) {
		User userFound = find(userId);
		this.userDao.delete(userFound);
	}
}
