package vn.hcmuaf.edu.fit.services;

import vn.hcmuaf.edu.fit.bean.Product;
import vn.hcmuaf.edu.fit.dao.ProductDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductService {
    private static ProductService instance;

    public ProductService() {
    }

    public static ProductService getInstance() {
        if (instance == null) instance = new ProductService();
        return instance;
    }

    public List<Product> getHotProduct() {
        return ProductDao.getInstance().hotProduct();
    }

    public List<Product> getProductHome() {
        List<Product> all = ProductDao.getInstance().getAllProduct();
        List<Product> result = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 12; i++) {
            int index = random.nextInt(all.size());
            result.add(all.get(index));
            all.remove(index);
        }
        return result;
    }

    public List<Product> search(String find) {
        String txt = "%"+find.replace(" ", "%")+"%";
        return ProductDao.getInstance().search(txt);
    }

}
