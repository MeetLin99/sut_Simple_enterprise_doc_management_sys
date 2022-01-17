package servlet;

import org.springframework.servelt.BaseServlet;

import model.DocumentInfo;
import mapper.DocumentInfoMapper;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/documentInfo")
public class DocumentInfoServlet extends BaseServlet {
    public void listAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<DocumentInfo> list = DocumentInfoMapper.list();
        request.setAttribute("list", list);
        response.sendRedirect(request.getContextPath() + "/DocumentInfo.jsp");    }

    public void deleteById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        DocumentInfoMapper.deleteById(Integer.parseInt(id));
        listAll(request, response);
    }
    public void getById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        DocumentInfo temp = new DocumentInfo();
        temp.setId(Integer.parseInt(id));
        List<DocumentInfo> list = DocumentInfoMapper.list(temp);
        if (!list.isEmpty()) {
            request.getSession().setAttribute("documentInfo", list.get(0));
        }
        response.sendRedirect(request.getContextPath() + "/DocumentInfoAdd.jsp");    }
    public void updateById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DocumentInfo temp = new DocumentInfo();
        String id = request.getParameter("id");
        temp.setId(Integer.parseInt(id));
        String name = request.getParameter("name");
        temp.setName(name);
        String content = request.getParameter("content");
        temp.setContent(content);
        String documentCategory = request.getParameter("documentCategory");
        temp.setDocumentCategory(documentCategory);
       DocumentInfoMapper.updateById(Integer.parseInt(id), temp);
        listAll(request, response);
    }
    public void addBean(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DocumentInfo temp = new DocumentInfo();
        String name = request.getParameter("name");
        temp.setName(name);
        String content = request.getParameter("content");
        temp.setContent(content);
        String documentCategory = request.getParameter("documentCategory");
        temp.setDocumentCategory(documentCategory);
       DocumentInfoMapper.add(temp);
        listAll(request, response);
    }}