package Lumiamuyu.dao;

import Lumiamuyu.pojo.User;
import Lumiamuyu.utilTest.JDBCUtil;
import Lumiamuyu.utilTest.RowMap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
                    user.setRid(resultSet.getInt("rid"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return user;
            }
        },username);
    }

    @Override
    public int editPwd(User user) {
        return JDBCUtil.executeUpdate("update user set password=? where id=?",user.getPassword(),user.getId());
    }

    @Override
    public int delete(int id) {
        return JDBCUtil.executeUpdate("delete from user where id = ?",id);
    }

    @Override
    public int update(User user) {
        return JDBCUtil.executeUpdate("update user set username = ?, password=? , email = ?, rid =? where id =?",user.getUsername(),user.getPassword(),user.getEmail(),user.getRid(),user.getId());
    }

    @Override
    public List<User> getUserLists() {
        return JDBCUtil.executeQuery("select * from user", new RowMap<User>() {
            @Override
            public User RowMapping(ResultSet resultSet) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                return user;
            }
        }, null);
    }

    @Override
    public User getOne(int id) {
        return JDBCUtil.queryOne("select * from user where id = ?", new RowMap<User>() {
            @Override
            public User RowMapping(ResultSet resultSet) throws SQLException {
                User u = new User();
                u.setId(id);
                u.setUsername(resultSet.getString("username"));
                u.setPassword(resultSet.getString("password"));
                u.setEmail(resultSet.getString("email"));
                u.setRid(resultSet.getInt("rid"));
                return u;
            }
        }, id);
    }
}
