package Lumiamuyu.dao;

import Lumiamuyu.pojo.Product;

import java.util.List;

public interface IProductDao {
    public List<Product> getLists();
    public int add(Product product);
    public int dele(int id);
    public int update(Product product);
    public Product getOne(int id);
    public List<Product> getResult(String text);
    public List<Product> getLists(int pageNo, int pageSize);
    public List<Product> getLists(int pageNo, int pageSize,String text);
    public int getCount();
    public int getCount(String text);
}
