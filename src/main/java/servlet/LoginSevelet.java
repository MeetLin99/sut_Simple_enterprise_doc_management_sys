package servlet;

import mapper.UserInfoMapper;
import model.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginSevelet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserInfo login = null;
        try {
            UserInfo reader = new UserInfo();
            reader.setUsername(username);
            reader.setPassword(password);
            List<UserInfo> list = UserInfoMapper.list(reader);
            if (!list.isEmpty()) {
                login = list.get(0);
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        if (login == null) {
            req.getSession().setAttribute("error", "用户或者密码错误");
            resp.sendRedirect(req.getContextPath() + "/front/login.jsp");
        } else {
            req.getSession().setAttribute("user", login);
            if ("管理员".equals(login.getUserPermissions())) {
                resp.sendRedirect(req.getContextPath() + "/index.jsp");
            } else {
                resp.sendRedirect(req.getContextPath() + "/front/index.jsp");
            }
        }
    }
}
