package vn.hcmuaf.edu.fit.services;

import vn.hcmuaf.edu.fit.bean.Product2;
import vn.hcmuaf.edu.fit.dao.ProductDao2;

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

    public List<Product2> getHotProduct() {
        return ProductDao2.getInstance().hotProduct();
    }

    public List<Product2> getProductHome() {
        List<Product2> all = ProductDao2.getInstance().getAllProduct();
        List<Product2> result = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 12; i++) {
            int index = random.nextInt(all.size());
            result.add(all.get(index));
            all.remove(index);
        }
        return result;
    }

    public List<Product2> getAllProduct() {
        return ProductDao2.getInstance().getAllProduct();
    }

    public List<Product2> search(String find) {
        String txt = "%"+find.replace(" ", "%")+"%";
        return ProductDao2.getInstance().search(txt);
    }

    public List<Product2> getProductPerPage(int currentPage, String sort, int quantityPerPage) {
        int start = getStartIndex(currentPage);
        if ("".equals(sort)) {
            return ProductDao2.getInstance().getProductPerPage(start, quantityPerPage);
        }else {
            return ProductDao2.getInstance().getProductSortPerPage(start, sort);
        }
    }

    public List<Product2> getProductPerPageByCategory(int currentPage, String sort, int category) {
        int start = getStartIndex(currentPage);
        if ("".equals(sort)) {
            return ProductDao2.getInstance().getProductPerPageByCategory(start, category);
        }else {
            return ProductDao2.getInstance().getProductSortPerPageByCategory(start, sort, category);
        }
    }

    public int countAll() {
        return ProductDao2.getInstance().countAll();
    }

    public int countAllByCategory(int category) {
        return ProductDao2.getInstance().countAllByCategory(category);
    }

    public List<Product2> getProductPerPageFilterPrice(int currentPage, String sort, int min, int max) {
        int start = getStartIndex(currentPage);
        if ("".equals(sort)) {
            return ProductDao2.getInstance().getProductPerPageFilterPrice(start, min, max);
        }else {
            return ProductDao2.getInstance().getProductPerPageSortPrice(start, sort, min, max);
        }
    }

    public List<Product2> getProductPerPageFilterPriceByCategory(int currentPage, String sort, int min, int max, int category) {
        int start = getStartIndex(currentPage);
        if ("".equals(sort)) {
            return ProductDao2.getInstance().getProductPerPageFilterPriceByCategory(start, min, max, category);
        }else {
            return ProductDao2.getInstance().getProductPerPageSortPriceByCategory(start, sort, min, max, category);
        }
    }

    public int countFilterPrice(int min, int max) {
        return ProductDao2.getInstance().countFilterPrice(min, max);
    }

    public int countFilterPriceByCategory(int min, int max, int category) {
        return ProductDao2.getInstance().countFilterPriceByCategory(min, max, category);
    }

    public List<Product2> getProductPerPageFilterColor(int currentPage, String sort, String[] colors) {
        int start = getStartIndex(currentPage);
        if ("".equals(sort)) {
            return ProductDao2.getInstance().getProductPerPageFilterColor(start, colors);
        }else {
            return ProductDao2.getInstance().getProductPerPageSortColor(start, sort, colors);
        }
    }

    public List<Product2> getProductPerPageFilterColorByCategory(int currentPage, String sort, String[] colors, int category) {
        int start = getStartIndex(currentPage);
        if ("".equals(sort)) {
            return ProductDao2.getInstance().getProductPerPageFilterColorByCategory(start, colors, category);
        }else {
            return ProductDao2.getInstance().getProductPerPageSortColorByCategory(start, sort, colors, category);
        }
    }

    public int countFilterColor(String[] colors) {
        return ProductDao2.getInstance().countFilterColor(colors);
    }

    public int countFilterColorByCategory(String[] colors, int category) {
        return ProductDao2.getInstance().countFilterColorByCategory(colors, category);
    }

    public List<Product2> getProductPerPageFilterPriceColor(int currentPage, String sort, int min, int max, String[] colors) {
        int start = getStartIndex(currentPage);
        if ("".equals(sort)) {
            return ProductDao2.getInstance().getProductPerPageFilterPriceColor(start, min, max, colors);
        }else {
            return ProductDao2.getInstance().getProductPerPageSortPriceColor(start, sort, min, max, colors);
        }
    }

    public List<Product2> getProductPerPageFilterPriceColorByCategory(int currentPage, String sort, int min, int max, String[] colors, int category) {
        int start = getStartIndex(currentPage);
        if ("".equals(sort)) {
            return ProductDao2.getInstance().getProductPerPageFilterPriceColorByCategory(start, min, max, colors, category);
        }else {
            return ProductDao2.getInstance().getProductPerPageSortPriceColorByCategory(start, sort, min, max, colors, category);
        }
    }

    public int countFilterPriceColor(int min, int max, String[] colors) {
        return ProductDao2.getInstance().countFilterPriceColor(min, max, colors);
    }

    public int countFilterPriceColorByCategory(int min, int max, String[] colors, int category) {
        return ProductDao2.getInstance().countFilterPriceColorByCategory(min, max, colors, category);
    }

    public int getStartIndex(int currentPage) {
        int productPerPage = 15;
        if (currentPage > 1) {
            return  ((currentPage - 1) * productPerPage);
        } else {
            return  0;
        }
    }

    public Product2 getProduct(int id) {
        return ProductDao2.getInstance().getProduct(id);
    }

    public int getTotalQuantity(int id) {
        return ProductDao2.getInstance().getTotalQuantity(id);
    }

    public int getPrice(int id, int size, int color) {
        return ProductDao2.getInstance().getPrice(id, size, color);
    }

    public int getQuantity(int id, int size, int color) {
        return ProductDao2.getInstance().getQuantity(id, size, color);
    }
    public List<Product2> getRandomProduct(int amount) {
        List<Product2> all = ProductDao2.getInstance().getAllProduct();
        List<Product2> randomProduct = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < amount; i++) {
            int index = random.nextInt(all.size());
            randomProduct.add(all.get(index));
            all.remove(index);
        }
        return randomProduct;
    }

    public Product2 getProductDetail(int id, int size, int color) {
        return ProductDao2.getInstance().getProductDetail(id, size, color);
    }

    public List<Product2> getWishList(int userID, int productID) {
        return ProductDao2.getInstance().getWishList(userID, productID);
    }

    public void addWishList(int userID, int productID) {
        ProductDao2.getInstance().addWishList(userID, productID);
    }
}
