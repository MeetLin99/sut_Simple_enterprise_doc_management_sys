package mapper;

import org.springframework.jdbc.mapper.MapperUtils;
import model.UserInfo;
import java.util.List;
import utils.JDBCUtils;
import java.util.ArrayList;
import java.sql.*;

public class UserInfoMapper {
    public static List<UserInfo> list() throws Exception{
       return  list(null);
    }

    public static List<UserInfo> list(UserInfo UserInfo)throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from user_info";
        sql += MapperUtils.getEqualCondition(UserInfo);
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
        List<UserInfo> list = new ArrayList<>();
            while (resultSet.next()) {
                UserInfo temp = new UserInfo();
                temp.setId(resultSet.getInt("id"));
                temp.setUsername(resultSet.getString("username"));
                temp.setPassword(resultSet.getString("password"));
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
    }
    public static List<UserInfo> search(UserInfo userInfo)throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from user_info";
        sql += MapperUtils.getLikeCondition(userInfo);
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
List<UserInfo> list = new ArrayList<>();
            while (resultSet.next()) {
                UserInfo temp = new UserInfo();
                temp.setId(resultSet.getInt("id"));
                temp.setUsername(resultSet.getString("username"));
                temp.setPassword(resultSet.getString("password"));
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
    }

    //Qjj
    public static boolean add(UserInfo userInfo) throws Exception{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "insert into user_info(id,username,password,user_permissions) values (NULL,?,?,?)";
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userInfo.getUsername());
            preparedStatement.setString(2, userInfo.getPassword());
            preparedStatement.setString(3, userInfo.getUserPermissions());
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
        String sql = "delete from user_info where id=" + id;
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
    public static int updateById(Integer id, UserInfo userInfo) throws Exception{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "update user_info set ";
        sql += MapperUtils.getUpdateCondition(userInfo);
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