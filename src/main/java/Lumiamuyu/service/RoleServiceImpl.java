package Lumiamuyu.service;

import Lumiamuyu.dao.IRoleDao;
import Lumiamuyu.dao.RoleDaoImpl;
import Lumiamuyu.pojo.Role;

import java.util.List;

public class RoleServiceImpl implements IRoleService{
    private IRoleDao dao = new RoleDaoImpl();
    @Override
    public List<Role> getList() {
        return dao.getList();
    }

    @Override
    public List<Role> getLists() {
        return dao.getLists();
    }
}
