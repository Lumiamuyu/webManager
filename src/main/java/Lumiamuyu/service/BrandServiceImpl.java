package Lumiamuyu.service;

import Lumiamuyu.dao.BrandDaoImpl;
import Lumiamuyu.dao.IBrandDao;
import Lumiamuyu.dao.IProductDao;
import Lumiamuyu.dao.ProductDaoImpl;
import Lumiamuyu.pojo.Brand;

import java.util.List;

public class BrandServiceImpl implements IBrandService {
    private IBrandDao dao = new BrandDaoImpl();
    private IProductDao pdao = new ProductDaoImpl();
    @Override
    public int insert(Brand brand) {
        return dao.insert(brand);
    }

    @Override
    public List<Brand> getLists() {
        return dao.getLists();
    }

    @Override
    public int delete(int brand_id) {
        return dao.delete(brand_id);
    }

    @Override
    public int dele(int id) {
        return dao.dele(id);
    }

    @Override
    public int update(Brand brand) {
        return dao.update(brand);
    }

    @Override
    public Brand getOne(int id) {
        return dao.getOne(id);
    }
}
