package cn.nuist.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import cn.nuist.dbc.DataBaseConnection;
import cn.nuist.model.User;

/**
 * @author Administrator
 */
public class UserDAOImpl implements UserDAO {
    private Connection connection;

    public UserDAOImpl() {
        this.connection = new DataBaseConnection().createConnection();
    }

    @Override
    public User findUser(String userName) throws SQLException {
        User user = null;
        String sql = "SELECT * FROM user WHERE username=?";

        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

        preparedStatement.setString(1, userName);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            user = new User();
            user.setId(resultSet.getInt(1));
            user.setUserName(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
        }
        resultSet.close();
        preparedStatement.close();
        return user;
    }

    @Override
    public boolean addUser(String userName, String password) throws Exception {
        String sql = "insert into user(username,password) values(?,?) ";

        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

        preparedStatement.setString(1, userName);
        preparedStatement.setString(2, password);

        int lines = preparedStatement.executeUpdate();

        preparedStatement.close();
        return lines > 0;
    }

    @Override
    public boolean updateUser(String userName, String password) throws Exception {
        String sql = "update user set password = ? where username = ?";

        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

        preparedStatement.setString(1, password);
        preparedStatement.setString(2, userName);

        int lines = preparedStatement.executeUpdate();

        preparedStatement.close();
        return lines > 0;
    }

    @Override
    public List<User> findAllUsers(String userName, String password) throws Exception {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM user WHERE username like '%" + userName +
                "%' and password like '%" + password + "%'";

        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt(1));
            user.setUserName(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
            user.setType(resultSet.getString(4));
            users.add(user);
        }
        resultSet.close();
        preparedStatement.close();
        return users;
    }

    @Override
    public boolean deleteUsers(List<String> ids) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from user where ");
        for (String id : ids) {
            sql.append(" id = ? or");
        }
        String strSql = sql.toString().substring(0, sql.length() - 2) + ";";

        PreparedStatement preparedStatement = this.connection.prepareStatement(strSql);

        for (int i = 0; i < ids.size(); i++) {
            preparedStatement.setInt(1 + i, Integer.parseInt(ids.get(i)));
        }

        int lines = preparedStatement.executeUpdate();

        preparedStatement.close();
        return lines > 0;
    }
}
