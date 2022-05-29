package cn.nuist.util;

/**
 * @author whb
 */
public interface Constant {
    interface State{
        String SUCCESS = " successfully";
        String FAILED = " failed";
        String WRONG = " wrong";
        String NOT_EXIST = " not exist";
    }

    interface Item{
        String USER = "User ";
        String PASSWORD = "Password ";
    }

    interface Operation{
        String LOGIN = "login";
        String REGISTER = "register";
        String ADD_STUDENT = "addStudent";
        String QUERY = "query";
        String IS = "is";
        String MODIFY = "modify";
        String DELETE = "delete";
    }

}
