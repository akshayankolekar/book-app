package user.service;

import user.model.User;

public interface IUserService {

	public User getUserById(int id);
	public void registerUser(User user);
	public User getUserByUserID(String id);
}
