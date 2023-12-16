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

    public List<Product> getProductPerPageByCategory(int currentPage, String sort, int category) {
        int start = getStartIndex(currentPage);
        if ("".equals(sort)) {
            return ProductDao.getInstance().getProductPerPageByCategory(start, category);
        }else {
            return ProductDao.getInstance().getProductSortPerPageByCategory(start, sort, category);
        }
    }

    public int countAll() {
        return ProductDao.getInstance().countAll();
    }

    public int countAllByCategory(int category) {
        return ProductDao.getInstance().countAllByCategory(category);
    }

    public List<Product> getProductPerPageFilterPrice(int currentPage, String sort, int min, int max) {
        int start = getStartIndex(currentPage);
        if ("".equals(sort)) {
            return ProductDao.getInstance().getProductPerPageFilterPrice(start, min, max);
        }else {
            return ProductDao.getInstance().getProductPerPageSortPrice(start, sort, min, max);
        }
    }

    public List<Product> getProductPerPageFilterPriceByCategory(int currentPage, String sort, int min, int max, int category) {
        int start = getStartIndex(currentPage);
        if ("".equals(sort)) {
            return ProductDao.getInstance().getProductPerPageFilterPriceByCategory(start, min, max, category);
        }else {
            return ProductDao.getInstance().getProductPerPageSortPriceByCategory(start, sort, min, max, category);
        }
    }

    public int countFilterPrice(int min, int max) {
        return ProductDao.getInstance().countFilterPrice(min, max);
    }

    public int countFilterPriceByCategory(int min, int max, int category) {
        return ProductDao.getInstance().countFilterPriceByCategory(min, max, category);
    }

    public List<Product> getProductPerPageFilterColor(int currentPage, String sort, String[] colors) {
        int start = getStartIndex(currentPage);
        if ("".equals(sort)) {
            return ProductDao.getInstance().getProductPerPageFilterColor(start, colors);
        }else {
            return ProductDao.getInstance().getProductPerPageSortColor(start, sort, colors);
        }
    }

    public List<Product> getProductPerPageFilterColorByCategory(int currentPage, String sort, String[] colors, int category) {
        int start = getStartIndex(currentPage);
        if ("".equals(sort)) {
            return ProductDao.getInstance().getProductPerPageFilterColorByCategory(start, colors, category);
        }else {
            return ProductDao.getInstance().getProductPerPageSortColorByCategory(start, sort, colors, category);
        }
    }

    public int countFilterColor(String[] colors) {
        return ProductDao.getInstance().countFilterColor(colors);
    }

    public int countFilterColorByCategory(String[] colors, int category) {
        return ProductDao.getInstance().countFilterColorByCategory(colors, category);
    }

    public List<Product> getProductPerPageFilterPriceColor(int currentPage, String sort, int min, int max, String[] colors) {
        int start = getStartIndex(currentPage);
        if ("".equals(sort)) {
            return ProductDao.getInstance().getProductPerPageFilterPriceColor(start, min, max, colors);
        }else {
            return ProductDao.getInstance().getProductPerPageSortPriceColor(start, sort, min, max, colors);
        }
    }

    public List<Product> getProductPerPageFilterPriceColorByCategory(int currentPage, String sort, int min, int max, String[] colors, int category) {
        int start = getStartIndex(currentPage);
        if ("".equals(sort)) {
            return ProductDao.getInstance().getProductPerPageFilterPriceColorByCategory(start, min, max, colors, category);
        }else {
            return ProductDao.getInstance().getProductPerPageSortPriceColorByCategory(start, sort, min, max, colors, category);
        }
    }

    public int countFilterPriceColor(int min, int max, String[] colors) {
        return ProductDao.getInstance().countFilterPriceColor(min, max, colors);
    }

    public int countFilterPriceColorByCategory(int min, int max, String[] colors, int category) {
        return ProductDao.getInstance().countFilterPriceColorByCategory(min, max, colors, category);
    }

    public int getStartIndex(int currentPage) {
        int productPerPage = 15;
        if (currentPage > 1) {
            return  ((currentPage - 1) * productPerPage);
        } else {
            return  0;
        }
    }

    public Product getProduct(int id) {
        return ProductDao.getInstance().getProduct(id);
    }

    public int getTotalQuantity(int id) {
        return ProductDao.getInstance().getTotalQuantity(id);
    }

    public int getPrice(int id, int size, int color) {
        return ProductDao.getInstance().getPrice(id, size, color);
    }

    public int getQuantity(int id, int size, int color) {
        return ProductDao.getInstance().getQuantity(id, size, color);
    }
    public List<Product> getRandomProduct(int amount) {
        List<Product> all = ProductDao.getInstance().getAllProduct();
        List<Product> randomProduct = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < amount; i++) {
            int index = random.nextInt(all.size());
            randomProduct.add(all.get(index));
            all.remove(index);
        }
        return randomProduct;
    }
}
