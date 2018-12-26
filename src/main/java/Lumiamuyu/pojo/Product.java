package Lumiamuyu.pojo;

import lombok.Data;

import java.util.Set;

@Data
public class Product {
    private int productId;
    private String productName;
    private String productDes;
    private Double price;
    private String url;
    private int reverse;
    private int brandId;
   /* private Set<Brand> set;*/

    public Product(int productId, String productName, String productDes, Double price, String url, int reverse, int brandId) {
        this.productId = productId;
        this.productName = productName;
        this.productDes = productDes;
        this.price = price;
        this.url = url;
        this.reverse = reverse;
        this.brandId = brandId;
    }

    public Product() {
    }

}
