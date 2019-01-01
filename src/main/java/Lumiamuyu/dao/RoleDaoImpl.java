package Lumiamuyu.dao;

import Lumiamuyu.pojo.Role;
import Lumiamuyu.pojo.User;
import Lumiamuyu.utilTest.JDBCUtil;
import Lumiamuyu.utilTest.RowMap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RoleDaoImpl implements IRoleDao {
    @Override
    public List<Role> getList() {
        return JDBCUtil.executeQuery("select * from role,user where user.id=role.rid", new RowMap<Role>() {
            @Override
            public Role RowMapping(ResultSet resultSet) throws SQLException {
                Role role = new Role();
                role.setRId(resultSet.getInt("rid"));
                role.setRName(resultSet.getString("rname"));
/*                Set<User> set = new HashSet<>();
                User u = new User();
                u.setId(resultSet.getInt("id"));
                u.setUsername(resultSet.getString("username"));
                u.setPassword(resultSet.getString("password"));
                u.setEmail(resultSet.getString("email"));
                set.add(u);*/
/*                role.setSet(set);*/
                return role;
            }
        }, null);
    }

    @Override
    public List<Role> getLists() {
        return JDBCUtil.executeQuery("select * from role", new RowMap<Role>() {
            @Override
            public Role RowMapping(ResultSet resultSet) throws SQLException {
                Role role = new Role();
                role.setRId(resultSet.getInt("rid"));
                role.setRName(resultSet.getString("rname"));
                return role;
            }
        }, null);
    }
}
