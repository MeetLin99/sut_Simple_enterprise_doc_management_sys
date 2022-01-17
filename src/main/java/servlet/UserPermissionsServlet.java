package servlet;

import org.springframework.servelt.BaseServlet;

import model.UserPermissions;
import mapper.UserPermissionsMapper;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userPermissions")
public class UserPermissionsServlet extends BaseServlet {    public void listAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<UserPermissions> list = UserPermissionsMapper.list();
        request.setAttribute("list", list);
        response.sendRedirect(request.getContextPath() + "/UserPermissions.jsp");    }    public void deleteById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        UserPermissionsMapper.deleteById(Integer.parseInt(id));
        listAll(request, response);
    }
    public void getById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        UserPermissions temp = new UserPermissions();
        temp.setId(Integer.parseInt(id));
        List<UserPermissions> list = UserPermissionsMapper.list(temp);
        if (!list.isEmpty()) {
            request.getSession().setAttribute("userPermissions", list.get(0));
        }
        response.sendRedirect(request.getContextPath() + "/UserPermissionsAdd.jsp");    }    public void updateById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        UserPermissions temp = new UserPermissions();
        String id = request.getParameter("id");
        temp.setId(Integer.parseInt(id));
        String userPermissions = request.getParameter("userPermissions");
        temp.setUserPermissions(userPermissions);
       UserPermissionsMapper.updateById(Integer.parseInt(id), temp);
        listAll(request, response);
    }    public void addBean(HttpServletRequest request, HttpServletResponse response) throws Exception {
        UserPermissions temp = new UserPermissions();
        String userPermissions = request.getParameter("userPermissions");
        temp.setUserPermissions(userPermissions);
       UserPermissionsMapper.add(temp);
        listAll(request, response);
    }}