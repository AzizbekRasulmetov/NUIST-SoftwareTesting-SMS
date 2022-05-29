package cn.nuist.service;

import cn.nuist.util.Message;

import java.util.List;

public interface UserService {
    /**
     * Login operation of User
     * @param userName name of user
     * @param password password
     * @return message of login operation
     */
    Message login(String userName, String password);

    /**
     * Register operation of User
     * @param userName name of user
     * @param password password
     * @return message of register operation
     */
    Message register(String userName, String password);

    /**
     * Modify password of User
     * @param userName name of user
     * @param password password
     * @return message of modify operation
     */
    Message modify(String userName, String password);

    /**
     * Query users
     * @param userName name of user
     * @param password password
     * @return message of query operation
     */
    Message query(String userName, String password);

    /**
     * Delete users
     * @param ids all ids of users to be deleted
     * @return message of query operation
     */
    Message deleteAll(List<String> ids);
}
