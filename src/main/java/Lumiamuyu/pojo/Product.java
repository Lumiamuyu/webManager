package Lumiamuyu.pojo;

import lombok.Data;

@Data
public class Product {
    private int productId;
    private String productName;
    private String productDes;
    private Double price;
    private String url;

    public Product(int productId, String productName, String productDes, Double price, String url) {
        this.productId = productId;
        this.productName = productName;
        this.productDes = productDes;
        this.price = price;
        this.url = url;
    }

    public Product() {
    }

}
