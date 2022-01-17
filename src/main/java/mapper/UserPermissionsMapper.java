package mapper;

import org.springframework.jdbc.mapper.MapperUtils;
import model.UserPermissions;
import java.util.List;
import utils.JDBCUtils;
import java.util.ArrayList;
import java.sql.*;

public class UserPermissionsMapper {
    public static List<UserPermissions> list() throws Exception{
       return  list(null);
    }

    public static List<UserPermissions> list(UserPermissions UserPermissions)throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from user_permissions";
        sql += MapperUtils.getEqualCondition(UserPermissions);
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
List<UserPermissions> list = new ArrayList<>();
            while (resultSet.next()) {
                UserPermissions temp = new UserPermissions();
                temp.setId(resultSet.getInt("id"));
                temp.setUserPermissions(resultSet.getString("user_permissions"));

                list.add(temp);
}
return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            JDBCUtils.close(resultSet, preparedStatement, connection);
        }
    }        public static List<UserPermissions> search(UserPermissions userPermissions)throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from user_permissions";
        sql += MapperUtils.getLikeCondition(userPermissions);
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
List<UserPermissions> list = new ArrayList<>();
            while (resultSet.next()) {
                UserPermissions temp = new UserPermissions();
                temp.setId(resultSet.getInt("id"));
                temp.setUserPermissions(resultSet.getString("user_permissions"));

                list.add(temp);
}
return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;        } finally {
            JDBCUtils.close(resultSet, preparedStatement, connection);
        }
    }


    public static boolean add(UserPermissions userPermissions) throws Exception{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "insert into user_permissions(id,user_permissions) values (NULL,?)";
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userPermissions.getUserPermissions());
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
        String sql = "delete from user_permissions where id=" + id;
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
    public static int updateById(Integer id, UserPermissions userPermissions) throws Exception{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "update user_permissions set ";
        sql += MapperUtils.getUpdateCondition(userPermissions);
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