package Lumiamuyu;

import Lumiamuyu.dao.BrandDaoImpl;
import Lumiamuyu.dao.IBrandDao;
import Lumiamuyu.dao.IProductDao;
import Lumiamuyu.dao.ProductDaoImpl;
import Lumiamuyu.pojo.Brand;
import Lumiamuyu.pojo.Product;
import Lumiamuyu.service.BrandServiceImpl;
import Lumiamuyu.service.IBrandService;
import Lumiamuyu.service.IProductService;
import Lumiamuyu.service.ProductServiceImpl;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        IProductDao dao = new ProductDaoImpl();
        IProductService service = new ProductServiceImpl();
        IBrandService brandService = new BrandServiceImpl();
        List<Product> brands = dao.getLists();
        for (Product a:brands
             ) {
            System.out.println(a);
        }
    }
}
