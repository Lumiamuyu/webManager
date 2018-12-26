package Lumiamuyu;

import Lumiamuyu.service.IProductService;
import Lumiamuyu.service.ProductServiceImpl;

public class Test {
    public static void main(String[] args) {
        IProductService service = new ProductServiceImpl();
        System.out.println(service.getLists());
    }
}
