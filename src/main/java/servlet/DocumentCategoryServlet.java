package servlet;

import org.springframework.servelt.BaseServlet;

import model.DocumentCategory;
import mapper.DocumentCategoryMapper;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/documentCategory")
public class DocumentCategoryServlet extends BaseServlet {
    public void listAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<DocumentCategory> list = DocumentCategoryMapper.list();
        request.setAttribute("list", list);
        response.sendRedirect(request.getContextPath() + "/DocumentCategory.jsp");    }
    public void deleteById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        DocumentCategoryMapper.deleteById(Integer.parseInt(id));
        listAll(request, response);
    }
    public void getById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        DocumentCategory temp = new DocumentCategory();
        temp.setId(Integer.parseInt(id));
        List<DocumentCategory> list = DocumentCategoryMapper.list(temp);
        if (!list.isEmpty()) {
            request.getSession().setAttribute("documentCategory", list.get(0));
        }
        response.sendRedirect(request.getContextPath() + "/DocumentCategoryAdd.jsp");    }    public void updateById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DocumentCategory temp = new DocumentCategory();
        String id = request.getParameter("id");
        temp.setId(Integer.parseInt(id));
        String name = request.getParameter("name");
        temp.setName(name);
       DocumentCategoryMapper.updateById(Integer.parseInt(id), temp);
        listAll(request, response);
    }    public void addBean(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DocumentCategory temp = new DocumentCategory();
        String name = request.getParameter("name");
        temp.setName(name);
       DocumentCategoryMapper.add(temp);
        listAll(request, response);
    }}