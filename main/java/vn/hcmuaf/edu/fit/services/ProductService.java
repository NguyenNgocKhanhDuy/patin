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

    public List<Product> getProductPerPage(int currentPage, String sort) {
        int start = getStartIndex(currentPage);
        if ("".equals(sort)) {
            return ProductDao.getInstance().getProductPerPage(start);
        }else {
            return ProductDao.getInstance().getProductSortPerPage(start, sort);
        }
    }

    public int countAll() {
        return ProductDao.getInstance().countAll();
    }

    public List<Product> getProductPerPageFilterPrice(int currentPage, String sort, int min, int max) {
        int start = getStartIndex(currentPage);
        if ("".equals(sort)) {
            return ProductDao.getInstance().getProductPerPageFilterPrice(start, min, max);
        }else {
            return ProductDao.getInstance().getProductPerPageSortPrice(start, sort, min, max);
        }
    }

    public int countFilterPrice(int min, int max) {
        return ProductDao.getInstance().countFilterPrice(min, max);
    }

    public List<Product> getProductPerPageFilterColor(int currentPage, String sort, String[] colors) {
        int start = getStartIndex(currentPage);
        if ("".equals(sort)) {
            return ProductDao.getInstance().getProductPerPageFilterColor(start, colors);
        }else {
            return ProductDao.getInstance().getProductPerPageSortColor(start, sort, colors);
        }
    }

    public int countFilterColor(String[] colors) {
        return ProductDao.getInstance().countFilterColor(colors);
    }

    public List<Product> getProductPerPageFilterPriceColor(int currentPage, String sort, int min, int max, String[] colors) {
        int start = getStartIndex(currentPage);
        if ("".equals(sort)) {
            return ProductDao.getInstance().getProductPerPageFilterPriceColor(start, min, max, colors);
        }else {
            return ProductDao.getInstance().getProductPerPageSortPriceColor(start, sort, min, max, colors);
        }
    }

    public int countFilterPriceColor(int min, int max, String[] colors) {
        return ProductDao.getInstance().countFilterPriceColor(min, max, colors);
    }

    public int getStartIndex(int currentPage) {
        int productPerPage = 15;
        if (currentPage > 1) {
            return  ((currentPage - 1) * productPerPage);
        } else {
            return  0;
        }
    }
}
