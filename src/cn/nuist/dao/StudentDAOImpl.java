package cn.nuist.dao;

import cn.nuist.dbc.DataBaseConnection;
import cn.nuist.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
public class StudentDAOImpl implements StudentDAO {
    private Connection connection;

    public StudentDAOImpl() {
        this.connection = new DataBaseConnection().createConnection();
    }

    @Override
    public boolean addStudent(String id, String studentName, String major) throws Exception {
        String sql = "insert into student(id, studentName, major) values(?,?,?)";

        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setString(1, id);
        preparedStatement.setString(2, studentName);
        preparedStatement.setString(3, major);

        int lines = preparedStatement.executeUpdate();

        preparedStatement.close();
        return lines > 0;
    }

    @Override
    public boolean updateStudent(String id, String studentName, String major) throws Exception {
        String sql = "UPDATE student set studentName = ?, major = ? where id = ?";

        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

        preparedStatement.setString(1, studentName);
        preparedStatement.setString(2, major);
        preparedStatement.setString(3, id);

        int lines = preparedStatement.executeUpdate();

        preparedStatement.close();
        return lines > 0;
    }

    @Override
    public List<Student> findAllStudents(String id, String studentName) throws Exception {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM student WHERE studentName like '%" + studentName +
                "%' and id like '%" + id + "%'";

        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Student student = new Student();
            student.setId(resultSet.getString(1));
            student.setStudentName(resultSet.getString(2));
            student.setMajor(resultSet.getString(3));
            students.add(student);
        }
        resultSet.close();
        preparedStatement.close();
        return students;
    }

    @Override
    public boolean deleteStudents(List<String> ids) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM student WHERE");
        for (String id : ids) {
            sql.append(" id = ? or");
        }
        String strSql = sql.substring(0, sql.length() - 2) + ";";

        PreparedStatement preparedStatement = this.connection.prepareStatement(strSql);

        for (int i = 0; i < ids.size(); i++) {
            preparedStatement.setString(1 + i, ids.get(i));
        }

        int lines = preparedStatement.executeUpdate();

        preparedStatement.close();
        return lines > 0;
    }
}
