package cn.nuist.service;

import cn.nuist.dao.UserDAOImpl;
import cn.nuist.model.User;
import cn.nuist.dao.UserDAO;
import cn.nuist.util.Constant;
import cn.nuist.util.Message;


import java.util.List;

import static cn.nuist.util.Constant.State.*;

public class UserServiceImpl implements UserService{
    @Override
    public Message login(String userName, String password) {
        String result;
        String state;
        UserDAO dao = new UserDAOImpl();
        User user = null;
        try {
            user = dao.findUser(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user != null){
            if (!password.equals(user.getPassword())){
                state = WRONG;
                result = Constant.Item.PASSWORD + Constant.Operation.IS + Constant.State.WRONG;
            }else{
                state = SUCCESS;
                result = Constant.Item.USER + Constant.Operation.LOGIN + SUCCESS;
            }
        }else {
            state = NOT_EXIST;
            result = Constant.Item.USER + Constant.Operation.IS + Constant.State.NOT_EXIST;
        }
        Message message = new Message();
        message.setState(state);
        message.setDetail(result);
        message.setData(user);
        return message;
    }

    @Override
    public Message register(String userName, String password) {
        String detail;
        String state;
        boolean isSuccess = false;
        UserDAO dao = new UserDAOImpl();
        try {
            isSuccess = dao.addUser(userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        state = isSuccess ? SUCCESS : FAILED;
        detail = Constant.Operation.REGISTER + state;
        Message message = new Message();
        message.setState(state);
        message.setDetail(detail);

        return message;
    }

    @Override
    public Message modify(String userName, String password) {
        String detail;
        String state;
        boolean isSuccess = false;
        UserDAO dao = new UserDAOImpl();
        try {
            isSuccess = dao.updateUser(userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        state = isSuccess ? SUCCESS : FAILED;
        detail = Constant.Operation.MODIFY + state;
        Message message = new Message();
        message.setState(state);
        message.setDetail(detail);

        return message;
    }

    @Override
    public Message query(String userName, String password) {
        String result;
        String state;
        UserDAO dao = new UserDAOImpl();
        List<User> users = null;
        try {
            users = dao.findAllUsers(userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        state = SUCCESS;
        Message message = new Message();
        message.setState(state);
        message.setDetail("");
        message.setData(users);
        return message;
    }

    @Override
    public Message deleteAll(List<String> ids) {
        String detail;
        String state;
        boolean isSuccess = false;
        UserDAO dao = new UserDAOImpl();
        try {
            isSuccess = dao.deleteUsers(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
        state = isSuccess ? SUCCESS : FAILED;
        detail = Constant.Operation.MODIFY + state;
        Message message = new Message();
        message.setState(state);
        message.setDetail(detail);

        return message;
    }
}
