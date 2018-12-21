package Lumiamuyu.dao;

import Lumiamuyu.pojo.User;
import Lumiamuyu.utilTest.JDBCUtil;
import Lumiamuyu.utilTest.RowMap;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements IUserDao {
    @Override
    public int insert(User user) {
        return JDBCUtil.executeUpdate("insert into user (username,password,email) values(?,?,?)",user.getUsername(),user.getPassword(),user.getEmail());
    }

    @Override
    public User getUser(String username) {
        return JDBCUtil.queryOne("select * from user where username = ?", new RowMap<User>() {
            @Override
            public User RowMapping(ResultSet resultSet) {
                User user = new User();
                try {
                    user.setId(resultSet.getInt("id"));
                    user.setPassword(resultSet.getString("password"));
                    user.setUsername(resultSet.getString("username"));
                    user.setEmail(resultSet.getString("email"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return user;
            }
        },username);
    }
}
