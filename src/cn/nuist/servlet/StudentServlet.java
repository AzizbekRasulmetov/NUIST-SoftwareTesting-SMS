package cn.nuist.servlet;

import cn.nuist.service.StudentService;
import cn.nuist.service.StudentServiceImpl;
import cn.nuist.util.Constant;
import cn.nuist.util.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    static final String PARAM_STUDENT_NAME = "studentName";
    static final String PARAM_MAJOR = "major";
    static final String PARAM_STUDENT_ID = "studentID";
    static final String PARAM_ACTION = "action";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String studentName = request.getParameter(PARAM_STUDENT_NAME);
        String major = request.getParameter(PARAM_MAJOR);
        String id = request.getParameter(PARAM_STUDENT_ID);
        String action = request.getParameter(PARAM_ACTION);

        String strIds = request.getParameter("ids");
        List<String> ids = null;
        if (strIds != null) {
            ids = new ArrayList<>(Arrays.asList(
                    strIds.split(",")));
        }

        PrintWriter writer = response.getWriter();
        Message message = null;

        StudentService studentService = new StudentServiceImpl();

        switch (action) {
            case Constant.Operation.ADD_STUDENT: {
                message = studentService.addStudent(id, studentName, major);
                break;
            }
            case Constant.Operation.QUERY: {
                message = studentService.query(id, studentName);
                break;
            }
            case Constant.Operation.DELETE: {
                message = studentService.deleteAll(ids);
                break;
            }
            case Constant.Operation.MODIFY: {
                message = studentService.update(id, studentName, major);
                break;
            }
        }

        String json = message.getJSON();
        writer.write(json);
        writer.flush();
        writer.close();
    }

}
