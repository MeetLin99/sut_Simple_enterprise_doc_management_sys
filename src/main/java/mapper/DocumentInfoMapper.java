package mapper;

import org.springframework.jdbc.mapper.MapperUtils;
import model.DocumentInfo;
import java.util.List;
import utils.JDBCUtils;
import java.util.ArrayList;
import java.sql.*;

public class DocumentInfoMapper {
    public static List<DocumentInfo> list() throws Exception{
       return  list(null);
    }

    public static List<DocumentInfo> list(DocumentInfo DocumentInfo)throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from document_info";
        sql += MapperUtils.getEqualCondition(DocumentInfo);
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
List<DocumentInfo> list = new ArrayList<>();
            while (resultSet.next()) {
                DocumentInfo temp = new DocumentInfo();
                temp.setId(resultSet.getInt("id"));
                temp.setName(resultSet.getString("name"));
                temp.setContent(resultSet.getString("content"));
                temp.setDocumentCategory(resultSet.getString("document_category"));

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
    public static List<DocumentInfo> search(DocumentInfo documentInfo)throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from document_info";
        sql += MapperUtils.getLikeCondition(documentInfo);
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
List<DocumentInfo> list = new ArrayList<>();
            while (resultSet.next()) {
                DocumentInfo temp = new DocumentInfo();
                temp.setId(resultSet.getInt("id"));
                temp.setName(resultSet.getString("name"));
                temp.setContent(resultSet.getString("content"));
                temp.setDocumentCategory(resultSet.getString("document_category"));

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


    //Qjj
    public static boolean add(DocumentInfo documentInfo) throws Exception{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "insert into document_info(id,name,content,document_category) values (NULL,?,?,?)";
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, documentInfo.getName());
            preparedStatement.setString(2, documentInfo.getContent());
            preparedStatement.setString(3, documentInfo.getDocumentCategory());
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
        String sql = "delete from document_info where id=" + id;
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
    public static int updateById(Integer id, DocumentInfo documentInfo) throws Exception{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "update document_info set ";
        sql += MapperUtils.getUpdateCondition(documentInfo);
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