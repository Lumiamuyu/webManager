package Lumiamuyu.dao;

import Lumiamuyu.pojo.Product;
import Lumiamuyu.utilTest.JDBCUtil;
import Lumiamuyu.utilTest.RowMap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements IProductDao {
    @Override
    public List<Product> getLists() {
        return JDBCUtil.executeQuery("select * from product", new RowMap<Product>() {
            @Override
            public Product RowMapping(ResultSet resultSet) {
                Product p = new Product();
                try {
                    p.setProductId(resultSet.getInt("product_id"));
                    p.setProductName(resultSet.getString("product_name"));
                    p.setProductDes(resultSet.getString("product_des"));
                    p.setUrl(resultSet.getString("url"));
                    p.setPrice(resultSet.getDouble("price"));
                    p.setBrandId(resultSet.getInt("brand_id"));
                    p.setReverse(resultSet.getInt("reverse"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return p;
            }
        },null);
    }

    @Override
    public int add(Product product) {
        return JDBCUtil.executeUpdate("insert into product(product_name,price,product_des,url,reverse) values(?,?,?,?,?)",product.getProductName(),product.getPrice(),product.getProductDes(),product.getUrl(),product.getReverse());
    }

    @Override
    public int dele(int id) {
            return JDBCUtil.executeUpdate("delete from product where product_id=?",id);
    }

    @Override
    public int update(Product product) {
        return JDBCUtil.executeUpdate("update product set product_name=?,product_des=?,url=?,price=?,reverse=? where product_id=?",product.getProductName(),product.getProductDes(),product.getUrl(),product.getPrice(),product.getReverse(),product.getProductId());
    }

    @Override
    public Product getOne(int id) {
        return JDBCUtil.queryOne("select * from product where product_id =?", new RowMap<Product>() {
            @Override
            public Product RowMapping(ResultSet resultSet) {
                Product p = new Product();
                try {
                    p.setProductName(resultSet.getString("product_name"));
                    p.setProductDes(resultSet.getString("product_des"));
                    p.setUrl(resultSet.getString("url"));
                    p.setPrice(resultSet.getDouble("price"));
                    p.setReverse(resultSet.getInt("reverse"));
                    p.setProductId(id);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return p;
            }
        }, id);
    }

    @Override
    public List<Product> getResult(String text) {
        /*concat('%',?,'%')*/
        return JDBCUtil.executeQuery("select * from product where product_name like ?", new RowMap<Product>() {
            @Override
            public Product RowMapping(ResultSet resultSet) {
                Product p = new Product();
                try {
                    p.setProductName(resultSet.getString("product_name"));
                    p.setProductDes(resultSet.getString("product_des"));
                    p.setUrl(resultSet.getString("url"));
                    p.setPrice(resultSet.getDouble("price"));
                    p.setProductId(resultSet.getInt("product_id"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return p;
            }
        }, text);
    }

}
