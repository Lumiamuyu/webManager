package Lumiamuyu;

import Lumiamuyu.dao.*;
import Lumiamuyu.pojo.Brand;
import Lumiamuyu.pojo.Product;
import Lumiamuyu.pojo.Role;
import Lumiamuyu.pojo.User;
import Lumiamuyu.service.*;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        IProductDao dao = new ProductDaoImpl();
        IProductService service = new ProductServiceImpl();
        IBrandService brandService = new BrandServiceImpl();
        IRoleDao rd = new RoleDaoImpl();
        IRoleService roleService = new RoleServiceImpl();
        List<Role> r = rd.getList();
        List<Product> brands = dao.getLists();
        for (Role a:r
             ) {
 /*           System.out.println(a);*/
        }
    }
}
