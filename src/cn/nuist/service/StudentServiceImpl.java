package cn.nuist.service;

import cn.nuist.dao.StudentDAO;
import cn.nuist.dao.StudentDAOImpl;
import cn.nuist.model.Student;
import cn.nuist.util.Constant;
import cn.nuist.util.Message;

import java.util.List;

import static cn.nuist.util.Constant.State.FAILED;
import static cn.nuist.util.Constant.State.SUCCESS;

public class StudentServiceImpl implements StudentService {

    @Override
    public Message addStudent(String id, String name, String major) {
        String state;
        String detail;
        boolean isSuccess = false;
        StudentDAO studentDAO = new StudentDAOImpl();
        try {
            isSuccess = studentDAO.addStudent(id, name, major);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        state = isSuccess ? SUCCESS : FAILED;
        detail = Constant.Operation.ADD_STUDENT + state;
        Message message = new Message();
        message.setState(state);
        message.setDetail(detail);
        return message;
    }

    @Override
    public Message update(String id, String name, String major) {
        String detail;
        String state;
        boolean isSuccess = false;
        StudentDAO dao = new StudentDAOImpl();
        try {
            isSuccess = dao.updateStudent(id, name, major);
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
    public Message query(String id, String studentName) {
        String state;
        StudentDAO dao = new StudentDAOImpl();
        List<Student> students = null;
        try {
            students = dao.findAllStudents(id, studentName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        state = SUCCESS;
        Message message = new Message();
        message.setState(state);
        message.setDetail("");
        message.setData(students);
        return message;
    }

    @Override
    public Message deleteAll(List<String> ids) {
        String detail;
        String state;
        boolean isDeleted = false;
        StudentDAO studentDAO = new StudentDAOImpl();
        try {
            isDeleted = studentDAO.deleteStudents(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
        state = isDeleted ? SUCCESS : FAILED;
        detail = Constant.Operation.DELETE + state;

        Message message = new Message();
        message.setState(state);
        message.setDetail(detail);
        return message;
    }
}
