package Lumiamuyu.dao;

import Lumiamuyu.pojo.User;

import java.util.List;


public interface IUserDao {
    public int insert(User user);//注册
    public User getUser(String username);//登录，取得用户
    public int editPwd(User user);
    public int delete(int id);
    public int update(User user);
    public List<User> getUserLists();
    public User getOne(int id);
}
