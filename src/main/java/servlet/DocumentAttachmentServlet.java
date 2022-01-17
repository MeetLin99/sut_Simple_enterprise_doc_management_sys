package servlet;

import org.springframework.servelt.BaseServlet;

import model.DocumentAttachment;
import mapper.DocumentAttachmentMapper;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/documentAttachment")
public class DocumentAttachmentServlet extends BaseServlet {
    public void listAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<DocumentAttachment> list = DocumentAttachmentMapper.list();
        request.setAttribute("list", list);
        response.sendRedirect(request.getContextPath() + "/DocumentAttachment.jsp");    }    public void deleteById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        DocumentAttachmentMapper.deleteById(Integer.parseInt(id));
        listAll(request, response);
    }
    public void getById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        DocumentAttachment temp = new DocumentAttachment();
        temp.setId(Integer.parseInt(id));
        List<DocumentAttachment> list = DocumentAttachmentMapper.list(temp);
        if (!list.isEmpty()) {
            request.getSession().setAttribute("documentAttachment", list.get(0));
        }
        response.sendRedirect(request.getContextPath() + "/DocumentAttachmentAdd.jsp");    }    public void updateById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DocumentAttachment temp = new DocumentAttachment();
        String id = request.getParameter("id");
        temp.setId(Integer.parseInt(id));
        String name = request.getParameter("name");
        temp.setName(name);
        String path = request.getParameter("path");
        temp.setPath(path);
        String size = request.getParameter("size");
        temp.setSize(Integer.parseInt(size));
        String documentId = request.getParameter("documentId");
        temp.setDocumentId(Integer.parseInt(documentId));
       DocumentAttachmentMapper.updateById(Integer.parseInt(id), temp);
        listAll(request, response);
    }    public void addBean(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DocumentAttachment temp = new DocumentAttachment();
        String name = request.getParameter("name");
        temp.setName(name);
        String path = request.getParameter("path");
        temp.setPath(path);
        String size = request.getParameter("size");
        temp.setSize(Integer.parseInt(size));
        String documentId = request.getParameter("documentId");
        temp.setDocumentId(Integer.parseInt(documentId));
       DocumentAttachmentMapper.add(temp);
        listAll(request, response);
    }}