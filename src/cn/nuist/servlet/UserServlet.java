package cn.nuist.servlet;

import cn.nuist.service.UserService;
import cn.nuist.service.UserServiceImpl;
import cn.nuist.util.Constant;
import cn.nuist.util.Message;

import javax.servlet.ServletContext;
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
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet("/user")
public class UserServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(Runtime.getRuntime().getClass().getName() );

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String action = request.getParameter("action");

        String strIds = request.getParameter("ids");
        List<String> ids = null;
        if (strIds != null) {
            ids = new ArrayList<>(Arrays.asList(
                    strIds.split(",")));
        }

        PrintWriter writer = response.getWriter();
        Message message = null;

        UserService userService = new UserServiceImpl();
        if (action.equals(Constant.Operation.LOGIN)) {
            message = userService.login(username, password);
        } else if (action.equals(Constant.Operation.REGISTER)) {
            message = userService.register(username, password);
        } else if (action.equals(Constant.Operation.MODIFY)) {
            message = userService.modify(username, password);
        } else if (action.equals(Constant.Operation.QUERY)) {
            message = userService.query(username, password);
        } else if (action.equals(Constant.Operation.DELETE)) {
            message = userService.deleteAll(ids);
        }
        String json = message.getJSON();
        writer.write(json);
        writer.flush();
        writer.close();
    }

}
