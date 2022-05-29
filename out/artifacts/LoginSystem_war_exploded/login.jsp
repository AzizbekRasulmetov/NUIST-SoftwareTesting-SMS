<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.*" %>

<html>
<head>
    <title>登录</title>
</head>
<body>
<center>
    <h1>登陆范例——MVC实现</h1>
    <hr>
    <br>
    <br>
    <!-- 加入更加详细的错误提示 -->
    <%
        String result = (String) request.getAttribute("result");
        if (result != null) {
    %>
    <li><%=result%>
    <%
		}
	%>

        <form action="login" method="post">
            <table>
                <tr>
                    <td colspan="2">用户登陆</td>
                </tr>
                <tr>
                    <td>用户名：</td>
                    <td><input type="text" name="username" value="${person.username}"></td>
                </tr>
                <tr>
                    <td>密&nbsp;&nbsp;码：</td>
                    <td><input type="password" name="password" value="${person.password}"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="登陆">
                        <input type="reset" value="重置">
                    </td>
                </tr>
            </table>
        </form>
</center>
</body>
</html>
