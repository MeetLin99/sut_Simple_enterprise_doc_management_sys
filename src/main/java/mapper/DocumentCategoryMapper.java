package mapper;

import org.springframework.jdbc.mapper.MapperUtils;
import model.DocumentCategory;
import java.util.List;
import utils.JDBCUtils;
import java.util.ArrayList;
import java.sql.*;

public class DocumentCategoryMapper {
    public static List<DocumentCategory> list() throws Exception{
       return  list(null);
    }

    public static List<DocumentCategory> list(DocumentCategory DocumentCategory)throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from document_category";
        sql += MapperUtils.getEqualCondition(DocumentCategory);
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
List<DocumentCategory> list = new ArrayList<>();
            while (resultSet.next()) {
                DocumentCategory temp = new DocumentCategory();
                temp.setId(resultSet.getInt("id"));
                temp.setName(resultSet.getString("name"));

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
    public static List<DocumentCategory> search(DocumentCategory documentCategory)throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from document_category";
        sql += MapperUtils.getLikeCondition(documentCategory);
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
List<DocumentCategory> list = new ArrayList<>();
            while (resultSet.next()) {
                DocumentCategory temp = new DocumentCategory();
                temp.setId(resultSet.getInt("id"));
                temp.setName(resultSet.getString("name"));

                list.add(temp);
}
return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;        } finally {
            JDBCUtils.close(resultSet, preparedStatement, connection);
        }
    }


    public static boolean add(DocumentCategory documentCategory) throws Exception{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "insert into document_category(id,name) values (NULL,?)";
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, documentCategory.getName());
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
        String sql = "delete from document_category where id=" + id;
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
    public static int updateById(Integer id, DocumentCategory documentCategory) throws Exception{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "update document_category set ";
        sql += MapperUtils.getUpdateCondition(documentCategory);
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