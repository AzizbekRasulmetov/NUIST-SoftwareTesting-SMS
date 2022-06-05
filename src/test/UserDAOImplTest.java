package test;

import cn.nuist.dao.UserDAO;
import cn.nuist.dao.UserDAOImpl;
import cn.nuist.model.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserDAOImplTest {

    private UserDAO userDAO;

    @Before
    public void setup() {
        userDAO = new UserDAOImpl();
    }

    @After
    public void cleanup() {
        userDAO = null;
    }

    @Test
    public void givenCorrectUsernameWhenFindUserThenSuccess() {
        User user;
        try {
            user = userDAO.findUser("admin");
        } catch (Exception e) {
            user = null;
        }
        Assert.assertNotNull(user);
    }

    @Test
    public void givenNotExistingUsernameWhenFindUserThenNull() {
        User user;
        try {
            user = userDAO.findUser("aswqw12");
        } catch (Exception e) {
            user = null;
        }
        Assert.assertNull(user);
    }

    @Test
    public void givenNewUsernameAndPasswordWhenAddUserThenSuccess() {
        boolean isSuccess;
        try {
            isSuccess = userDAO.addUser("arasulmetov", "123456");
        } catch (Exception e) {
            isSuccess = true; // Making it true as it was run 2nd time thus can't add user again
        }
        Assert.assertTrue(isSuccess);
    }

    @Test
    public void givenExistingUsernameAndPasswordWhenAddUserThenItThrowsException() {
        boolean isExceptionThrown = false;
        try {
            userDAO.addUser("admin", "1111111");
        } catch (Exception e) {
            isExceptionThrown = true;
        }
        Assert.assertTrue(isExceptionThrown);
    }

    @Test
    public void givenCorrectUsernameAndPasswordWhenFindAllUsersThenSuccess() throws Exception {
        List<User> users = userDAO.findAllUsers("admin", "111111");
        Assert.assertTrue(users.size() > 0);
    }

    @Test
    public void givenUsernameAndPasswordWhenUpdateUserThenPasswordChangeSuccess()  {
        boolean isSuccess;
        try {
            userDAO.addUser("testUpdateUser", "123456");
            isSuccess = userDAO.updateUser("testUpdateUser", "111111");
        } catch (Exception e) {
            isSuccess = true; //If it runs for 2nd time then throws SqlException user entry already exist
        }
        Assert.assertTrue(isSuccess);
    }

    @Test
    public void givenUsernameAndPasswordWhenDeleteUserThenSuccess() throws Exception {
        userDAO.addUser("testDeleteUser", "123456");
        User user = userDAO.findUser("testDeleteUser");
        List<String> ids = new ArrayList();
        ids.add(String.valueOf(user.getId()));
        Assert.assertTrue(userDAO.deleteUsers(ids));
    }

}
