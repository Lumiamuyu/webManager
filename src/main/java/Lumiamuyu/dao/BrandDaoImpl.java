package Lumiamuyu.dao;

import Lumiamuyu.pojo.Brand;
import Lumiamuyu.utilTest.JDBCUtil;
import Lumiamuyu.utilTest.RowMap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BrandDaoImpl implements IBrandDao {
    @Override
    public int insert(Brand brand) {
        return JDBCUtil.executeUpdate("insert into brand(brand_id ,brand_name ,brand_des) values (?,?,?)",brand.getBrandId(),brand.getBrandName(),brand.getBrandDes());
    }

    @Override
    public List<Brand> getLists() {
        return JDBCUtil.executeQuery("select * from brand", new RowMap<Brand>() {
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
        }, null);
    }

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
