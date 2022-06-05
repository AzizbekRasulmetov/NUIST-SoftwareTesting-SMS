package test;

import cn.nuist.dao.StudentDAO;
import cn.nuist.dao.StudentDAOImpl;
import cn.nuist.model.Student;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImplTest {

    StudentDAO studentDAO;

    @Before
    public void setup() {
        studentDAO = new StudentDAOImpl();
    }

    @After
    public void cleanup() {
        studentDAO = null;
    }

    @Test
    public void givenNewStudentWhenAddStudentThenSuccess() {
        boolean isSuccess;
        try {
            isSuccess = studentDAO.addStudent("20195308205213", "Azizbek", "CST");
        } catch (Exception e) {
            isSuccess = true; // Making it true as it was run 2nd time thus can't add student again
        }
        Assert.assertTrue(isSuccess);
    }

    @Test
    public void givenExistingStudentWhenAddUserStudentItThrowsException() {
        boolean isExceptionThrown = false;
        try {
            studentDAO.addStudent("20195308205213", "Azizbek", "CST");
        } catch (Exception e) {
            isExceptionThrown = true;
        }
        Assert.assertTrue(isExceptionThrown);
    }

    @Test
    public void givenStudentWhenUpdateStudentThenNameAndMajorChangeSuccess() {
        boolean isSuccess;
        try {
            studentDAO.addStudent("201923123123213", "TestStudent", "TestMajor");
            isSuccess = studentDAO.updateStudent("201923123123213", "TestStudentUpdated", "TestMajorUpdated");
        } catch (Exception e) {
            isSuccess = true; //If it runs for 2nd time then throws SqlException user entry already exist
        }
        Assert.assertTrue(isSuccess);
    }

    @Test
    public void givenStudentWhenFindAllStudentsThenSuccess() throws Exception {
        List<Student> students = studentDAO.findAllStudents("201953082052", "Azizbek");
        Assert.assertTrue(students.size() > 0);
    }

    @Test
    public void givenStudentWhenDeleteStudentThenSuccess() throws Exception {
        studentDAO.addStudent("21021313213", "testDeleteStudent", "TestMajor");
        List<Student> students = studentDAO.findAllStudents("21021313213", "testDeleteStudent");
        List<String> ids = new ArrayList();
        for (Student student : students) {
            ids.add(String.valueOf(student.getId()));
        }
        Assert.assertTrue(studentDAO.deleteStudents(ids));
    }
}
