package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.dao.IUser;
import user.model.User;

@Service
public class UserService implements IUserService{

	@Autowired
	IUser userService;
	
	@Override
	public User getUserById(int id) {
		return userService.getUserById(id);
	}

	@Override
	public void registerUser(User user) {
		userService.registerUser(user);
	}

	@Override
	public User getUserByUserID(String id) {
		return userService.getUserByUserID(id);
	}

}
