package Lumiamuyu.dao;

import Lumiamuyu.pojo.Brand;
import Lumiamuyu.pojo.Product;
import Lumiamuyu.utilTest.JDBCUtil;
import Lumiamuyu.utilTest.RowMap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BrandDaoImpl implements IBrandDao {
    @Override
    public int insert(Brand brand) {
        return JDBCUtil.executeUpdate("insert into brand(brand_id ,brand_name ,brand_des) values (?,?,?)",brand.getBrandId(),brand.getBrandName(),brand.getBrandDes());
    }

    @Override
    public List<Brand> getLists() {
        return JDBCUtil.executeQuery("select * from brand", new RowMap<Brand>() {
            @Override
            public Brand RowMapping(ResultSet resultSet) throws SQLException {
                Brand brand = new Brand();
                brand.setBrandId(resultSet.getInt("brand_id"));
                brand.setBrandName(resultSet.getString("brand_name"));
                brand.setBrandDes(resultSet.getString("brand_des"));
                return brand;
            }
        }, null);
    }

/*
    @Override
    public List<Brand> getLists() {
        return JDBCUtil.executeQuery("select * from brand,product where product.brand_id=brand.brand_id", new RowMap<Brand>() {
            @Override
            public Brand RowMapping(ResultSet resultSet) {
                Brand brand = new Brand();
                try {
                    brand.setBrandId(resultSet.getInt("brand_id"));
                    brand.setBrandName(resultSet.getString("brand_name"));
                    brand.setBrandDes(resultSet.getString("brand_des"));
                    Set<Product> sets = new HashSet<>();
                    Product p = new Product();
                    p.setProductId(resultSet.getInt("product_id"));
                    p.setProductName(resultSet.getString("product_name"));
                    p.setProductDes(resultSet.getString("product_des"));
                    p.setUrl(resultSet.getString("url"));
                    p.setPrice(resultSet.getDouble("price"));
                    p.setBrandId(resultSet.getInt("brand_id"));
                    p.setReverse(resultSet.getInt("reverse"));
                    sets.add(p);
                    brand.setSets(sets);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return brand;
            }
        }, null);
    }
*/

    @Override
    public int delete(int brand_id) {
        return JDBCUtil.executeUpdate("delete from brand where brand_id = ?",brand_id);
    }

    @Override
    public int dele(int id) {
        return JDBCUtil.executeUpdate("delete from product where brand_id = ?",id);
    }

    @Override
    public int update(Brand brand) {
        return JDBCUtil.executeUpdate("update brand set brand_name = ? ,brand_des = ? where brand_id = ?",brand.getBrandName(),brand.getBrandDes(),brand.getBrandId());
    }

    @Override
    public Brand getOne(int id) {
        return JDBCUtil.queryOne("select * from brand where brand_id = ?", new RowMap<Brand>() {
            @Override
            public Brand RowMapping(ResultSet resultSet) {
                Brand brand = new Brand();
                try {
                    brand.setBrandId(resultSet.getInt("brand_id"));
                    brand.setBrandName(resultSet.getString("brand_name"));
                    brand.setBrandDes(resultSet.getString("brand_des"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return brand;
            }
        },id);
    }
}
