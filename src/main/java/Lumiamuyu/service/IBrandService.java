package Lumiamuyu.service;

import Lumiamuyu.pojo.Brand;

import java.util.List;

public interface IBrandService {
    public int insert(Brand brand);
    public List<Brand> getLists();
    public int delete(int brand_id);
    public int dele(int id);
    public int update(Brand brand);
    public Brand getOne(int id);
}
