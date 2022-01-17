package servlet;

import mapper.UserInfoMapper;
import model.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserInfo temp = new UserInfo();
        String name = req.getParameter("username");
        temp.setUsername(name);
        String password = req.getParameter("password");
        temp.setPassword(password);
        temp.setUserPermissions("普通用户");
        try {
            UserInfoMapper.add(temp);
        } catch (Exception e) {
            e.printStackTrace();
            req.getSession().setAttribute("error", "用户名密码错误");
        }
        resp.sendRedirect(req.getContextPath() + "/front/login.jsp");
    }
}
