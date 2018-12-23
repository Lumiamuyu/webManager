package Lumiamuyu.dao;

import Lumiamuyu.pojo.User;


public interface IUserDao {
    public int insert(User user);//注册
    public User getUser(String username);//登录，取得用户

}
