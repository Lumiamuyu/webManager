package Lumiamuyu.service;

import Lumiamuyu.dao.IUserDao;
import Lumiamuyu.dao.UserDaoImpl;
import Lumiamuyu.pojo.User;

import java.util.List;

public class UserServiceImpl implements IUserService {
    private IUserDao idao = new UserDaoImpl();
    @Override
    public int insert(User user) {
        return idao.insert(user);
    }

    @Override
    public User getUser(String username) {
        return idao.getUser(username);
    }

    @Override
    public int editPwd(User user) {
        return idao.editPwd(user);
    }

    @Override
    public int delete(int id) {
        return idao.delete(id);
    }

    @Override
    public int update(User user) {
        return idao.update(user);
    }

    @Override
    public List<User> getUserLists() {
        return idao.getUserLists();
    }

    @Override
    public User getOne(int id) {
        return idao.getOne(id);
    }


}
