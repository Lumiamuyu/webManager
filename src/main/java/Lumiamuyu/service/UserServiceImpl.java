package Lumiamuyu.service;

import Lumiamuyu.dao.IUserDao;
import Lumiamuyu.dao.UserDaoImpl;
import Lumiamuyu.pojo.User;

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
}
