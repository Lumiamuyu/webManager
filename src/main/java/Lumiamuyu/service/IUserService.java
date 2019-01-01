package Lumiamuyu.service;

import Lumiamuyu.pojo.Role;
import Lumiamuyu.pojo.User;

import java.util.List;

public interface IUserService {
    public int insert(User user);
    public User getUser(String username);
    public int editPwd(User user);
    public int delete(int id);
    public int update(User user);
    public List<User> getUserLists();
    public User getOne(int id);
}
