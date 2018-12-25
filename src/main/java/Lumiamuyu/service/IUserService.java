package Lumiamuyu.service;

import Lumiamuyu.pojo.User;

public interface IUserService {
    public int insert(User user);
    public User getUser(String username);
    public int editPwd(User user);
}
