package user.dao;

import user.model.User;

public interface IUser {

	public User getUserById(int id);
	public void registerUser(User user);
	public User getUserByUserID(String id);
}
