package servlet;

import org.springframework.servelt.BaseServlet;

import model.UserInfo;
import mapper.UserInfoMapper;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userInfo")
public class UserInfoServlet extends BaseServlet {
    public void listAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<UserInfo> list = UserInfoMapper.list();
        request.setAttribute("list", list);
        response.sendRedirect(request.getContextPath() + "/UserInfo.jsp");    }    public void deleteById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        UserInfoMapper.deleteById(Integer.parseInt(id));
        listAll(request, response);
    }
    public void getById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        UserInfo temp = new UserInfo();
        temp.setId(Integer.parseInt(id));
        List<UserInfo> list = UserInfoMapper.list(temp);
        if (!list.isEmpty()) {
            request.getSession().setAttribute("userInfo", list.get(0));
        }
        response.sendRedirect(request.getContextPath() + "/UserInfoAdd.jsp");    }    public void updateById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        UserInfo temp = new UserInfo();
        String id = request.getParameter("id");
        temp.setId(Integer.parseInt(id));
        String username = request.getParameter("username");
        temp.setUsername(username);
        String password = request.getParameter("password");
        temp.setPassword(password);
        String userPermissions = request.getParameter("userPermissions");
        temp.setUserPermissions(userPermissions);
       UserInfoMapper.updateById(Integer.parseInt(id), temp);
        listAll(request, response);
    }
    public void addBean(HttpServletRequest request, HttpServletResponse response) throws Exception {
        UserInfo temp = new UserInfo();
        String username = request.getParameter("username");
        temp.setUsername(username);
        String password = request.getParameter("password");
        temp.setPassword(password);
        String userPermissions = request.getParameter("userPermissions");
        temp.setUserPermissions(userPermissions);
       UserInfoMapper.add(temp);
        listAll(request, response);
    }}