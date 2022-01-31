package br.com.agls.utils;

import java.util.Objects;
import java.util.logging.Logger;

import br.com.agls.entity.User;
import br.com.agls.exception.EntityNotFoundException;

public class TodoUtils {

	private static final Logger LOGGER = Logger.getLogger(TodoUtils.class.getName());
	
	public static void checkIsNotNull(Object object, Long objectId, String className) {
		if (Objects.isNull(object)) {
			String message = String
					.format("Could not found %s with id: %d.", className, objectId);
			LOGGER.warning(message);
			throw new EntityNotFoundException(message);
		}
	}
	
	public static void updateFields(Object source, Object target) {
		if(source instanceof User && target instanceof User) {
			User sourceUser = (User)source;
			User targetUser = (User)target;
			
			targetUser.setEmail(sourceUser.getEmail());
			targetUser.setName(sourceUser.getName());
		}
	}
}
