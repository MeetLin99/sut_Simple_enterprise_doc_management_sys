package mapper;

import org.springframework.jdbc.mapper.MapperUtils;
import model.DocumentAttachment;
import java.util.List;
import utils.JDBCUtils;
import java.util.ArrayList;
import java.sql.*;

public class DocumentAttachmentMapper {
    public static List<DocumentAttachment> list() throws Exception{
       return  list(null);
    }

    public static List<DocumentAttachment> list(DocumentAttachment DocumentAttachment)throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from document_attachment";
        sql += MapperUtils.getEqualCondition(DocumentAttachment);
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
        } catch (Exception throwables) {
            throwables.printStackTrace();
            System.out.printf("==>>SQL语句错误sql=%s<<==%n", sql);
            throw throwables;
        }
        try {
List<DocumentAttachment> list = new ArrayList<>();
            while (resultSet.next()) {
                DocumentAttachment temp = new DocumentAttachment();
                temp.setId(resultSet.getInt("id"));
                temp.setName(resultSet.getString("name"));
                temp.setPath(resultSet.getString("path"));
                temp.setSize(resultSet.getInt("size"));
                temp.setDocumentId(resultSet.getInt("document_id"));

                list.add(temp);
}
return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            JDBCUtils.close(resultSet, preparedStatement, connection);
        }
    }
    public static List<DocumentAttachment> search(DocumentAttachment documentAttachment)throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from document_attachment";
        sql += MapperUtils.getLikeCondition(documentAttachment);
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.printf("==>>SQL语句错误sql=%s<<==%n", sql);
            throw throwables;
        }
        try {
List<DocumentAttachment> list = new ArrayList<>();
            while (resultSet.next()) {
                DocumentAttachment temp = new DocumentAttachment();
                temp.setId(resultSet.getInt("id"));
                temp.setName(resultSet.getString("name"));
                temp.setPath(resultSet.getString("path"));
                temp.setSize(resultSet.getInt("size"));
                temp.setDocumentId(resultSet.getInt("document_id"));

                list.add(temp);
}
return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;        } finally {
            JDBCUtils.close(resultSet, preparedStatement, connection);
        }
    }


    public static boolean add(DocumentAttachment documentAttachment) throws Exception{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "insert into document_attachment(id,name,path,size,document_id) values (NULL,?,?,?,?)";
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, documentAttachment.getName());
            preparedStatement.setString(2, documentAttachment.getPath());
            preparedStatement.setInt(3, documentAttachment.getSize());
            preparedStatement.setInt(4, documentAttachment.getDocumentId());
            return preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.printf("==>>SQL语句错误sql=%s<<==%n", sql);
            throw throwables;
        } finally {
            JDBCUtils.close(resultSet, preparedStatement, connection);
        }
    }
    public static boolean deleteById(Integer id)throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "delete from document_attachment where id=" + id;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            return preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.printf("==>>SQL语句错误sql=%s<<==%n", sql);
            throw throwables;
        } finally {
            JDBCUtils.close(resultSet, preparedStatement, connection);
        }
    }
    public static int updateById(Integer id, DocumentAttachment documentAttachment) throws Exception{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "update document_attachment set ";
        sql += MapperUtils.getUpdateCondition(documentAttachment);
        sql += " where id = '" + id + "'";
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            return preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.printf("==>>SQL语句错误sql=%s<<==%n", sql);
            throw throwables;
        } finally {
            JDBCUtils.close(resultSet, preparedStatement, connection);
        }
    }

}