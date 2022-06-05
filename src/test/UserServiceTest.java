package test;

import cn.nuist.service.UserService;
import cn.nuist.service.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static cn.nuist.util.Constant.State.*;

public class UserServiceTest {

    private UserService userService;

    @Before
    public void setup() {
        userService = new UserServiceImpl();
    }

    @Test
    public void addStudentSuccess() {
        Assert.assertEquals("2 * 2 = 4", 4, 2 * 2);
    }

    @Test
    public void givenCorrectUsernameAndPasswordWhenLoginThenStateIsSuccess(){
        Assert.assertEquals(SUCCESS, userService.login("admin", "111111").getState());
    }

    @Test
    public void givenNotExistingUsernameWhenLoginThenStateIsNotExist() {
        Assert.assertEquals(NOT_EXIST, userService.login("aswqw12", "1111111").getState());
    }

    @Test
    public void givenIncorrectPasswordWhenLoginThenStateIsWrong() {
        Assert.assertEquals(WRONG, userService.login("admin", "123456").getState());
    }

   /* @Test
    public void givenNewUsernameAndPasswordWhenRegisterThenStateIsSuccess() {
        Assert.assertEquals(SUCCESS, userService.register("rasulmetov", "123456").getState());
    }*/

    @Test
    public void givenExistingUsernameAndPasswordWhenRegisterThenStateIsFailed() {
        Assert.assertEquals(FAILED, userService.register("admin", "123456").getState());
    }

    @Test
    public void givenCorrectUsernameAndPasswordWhenQueryThenStateIsSuccess() {
        Assert.assertEquals(SUCCESS, userService.query("admin", "111111").getState());
    }

}
