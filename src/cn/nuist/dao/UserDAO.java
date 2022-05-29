package cn.nuist.dao;

import cn.nuist.model.User;

import java.util.List;


public interface UserDAO{
	/**
	 * Find user with user name
	 * @param userName name of user
	 * @return User instance
	 * @throws Exception
	 */
	User findUser(String userName) throws Exception;

	/**
	 * Add one user to database
	 * @param userName name of user
	 * @param password password of user
	 * @return if success
	 * @throws Exception
	 */
	boolean addUser(String userName, String password) throws Exception;

	/**
	 * Update one user to database
	 * @param userName name of user
	 * @param password password of user
	 * @return if success
	 * @throws Exception
	 */
	boolean updateUser(String userName, String password) throws Exception;

	/**
	 * Find users from database
	 * @param userName part name of user
	 * @param password part password of user
	 * @return Users within conditions
	 * @throws Exception
	 */
	List<User> findAllUsers(String userName, String password) throws Exception;

	/**
	 * Delete users from database
	 * @param ids all ids of records
	 * @return if success
	 * @throws Exception
	 */
    boolean deleteUsers(List<String> ids) throws Exception;
}
