package vn.hcmuaf.edu.fit.services;

import vn.hcmuaf.edu.fit.bean.Product;
import vn.hcmuaf.edu.fit.bean.Product2;
import vn.hcmuaf.edu.fit.bean.ProductDetail;
import vn.hcmuaf.edu.fit.bean.ProductMain;
import vn.hcmuaf.edu.fit.dao.ProductDao;
import vn.hcmuaf.edu.fit.dao.ProductDao2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductService2 {
    private static ProductService2 instance;

    public ProductService2() {
    }

    public static ProductService2 getInstance() {
        if (instance == null) instance = new ProductService2();
        return instance;
    }

    public List<ProductMain> getHotProduct() {
        return ProductDao2.getInstance().hotProduct();
    }

    public List<ProductMain> getProductHome() {
        List<ProductMain> all = ProductDao2.getInstance().getAllProduct();
        List<ProductMain> result = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 12; i++) {
            int index = random.nextInt(all.size());
            result.add(all.get(index));
            all.remove(index);
        }
        return result;
    }

    public List<ProductMain> getAllProduct() {
        return ProductDao2.getInstance().getAllProduct();
    }

    public List<ProductMain> search(String find) {
        String txt = "%"+find.replace(" ", "%")+"%";
        return ProductDao2.getInstance().search(txt);
    }

    public List<ProductMain> getProductPerPage(int currentPage, String sort, int quantityPerPage) {
        int start = getStartIndex(currentPage, quantityPerPage);
        if ("".equals(sort)) {
            return ProductDao2.getInstance().getProductPerPage(start, quantityPerPage);
        }else {
            return ProductDao2.getInstance().getProductSortPerPage(start, sort);
        }
    }

    public List<ProductMain> getProductPerPageAdmin(int currentPage, String sort, int quantityPerPage) {
        int start = getStartIndex(currentPage, quantityPerPage);
        if ("".equals(sort)) {
            return ProductDao2.getInstance().getProductPerPageAdmin(start, quantityPerPage);
        }
        return null;
    }

    public List<ProductMain> getProductPerPageByCategory(int currentPage, String sort, int category) {
        int start = getStartIndex(currentPage, 15);
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

    public List<ProductMain> getProductPerPageFilterPrice(int currentPage, String sort, int min, int max) {
        int start = getStartIndex(currentPage, 15);
        if ("".equals(sort)) {
            return ProductDao2.getInstance().getProductPerPageFilterPrice(start, min, max);
        }else {
            return ProductDao2.getInstance().getProductPerPageSortPrice(start, sort, min, max);
        }
    }

    public List<ProductMain> getProductPerPageFilterPriceByCategory(int currentPage, String sort, int min, int max, int category) {
        int start = getStartIndex(currentPage, 15);
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

    public List<ProductMain> getProductPerPageFilterColor(int currentPage, String sort, String[] colors) {
        int start = getStartIndex(currentPage, 15);
        if ("".equals(sort)) {
            return ProductDao2.getInstance().getProductPerPageFilterColor(start, colors);
        }else {
            return ProductDao2.getInstance().getProductPerPageSortColor(start, sort, colors);
        }
    }

    public List<ProductMain> getProductPerPageFilterColorByCategory(int currentPage, String sort, String[] colors, int category) {
        int start = getStartIndex(currentPage, 15);
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

    public List<ProductMain> getProductPerPageFilterPriceColor(int currentPage, String sort, int min, int max, String[] colors) {
        int start = getStartIndex(currentPage, 15);
        if ("".equals(sort)) {
            return ProductDao2.getInstance().getProductPerPageFilterPriceColor(start, min, max, colors);
        }else {
            return ProductDao2.getInstance().getProductPerPageSortPriceColor(start, sort, min, max, colors);
        }
    }

    public List<ProductMain> getProductPerPageFilterPriceColorByCategory(int currentPage, String sort, int min, int max, String[] colors, int category) {
        int start = getStartIndex(currentPage, 15);
        if ("".equals(sort)) {
            return ProductDao2.getInstance().getProductPerPageFilterPriceColorByCategory(start, min, max, colors, category);
        }else {
            return ProductDao2.getInstance().getProductPerPageSortPriceColorByCategory(start, sort, min, max, colors, category);
        }
    }

    public List<ProductMain> getAllProductDetailPerPage(int currentPage, int productPerPage, int id) {
        int start = getStartIndex(currentPage, productPerPage);
        return ProductDao2.getInstance().getAllProductDetailPerPage(start, id);
    }

    public int countFilterPriceColor(int min, int max, String[] colors) {
        return ProductDao2.getInstance().countFilterPriceColor(min, max, colors);
    }

    public int countFilterPriceColorByCategory(int min, int max, String[] colors, int category) {
        return ProductDao2.getInstance().countFilterPriceColorByCategory(min, max, colors, category);
    }

    public int getStartIndex(int currentPage, int productPerPage) {
        if (currentPage > 1) {
            return  ((currentPage - 1) * productPerPage);
        } else {
            return  0;
        }
    }

    public ProductMain getProduct(int id) {
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
    public List<ProductMain> getRandomProduct(int amount) {
        List<ProductMain> all = ProductDao2.getInstance().getAllProduct();
        List<ProductMain> randomProduct = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < amount; i++) {
            int index = random.nextInt(all.size());
            randomProduct.add(all.get(index));
            all.remove(index);
        }
        return randomProduct;
    }

    public List<ProductMain> getAllProductDetail(int id) {
        return ProductDao2.getInstance().getAllProductDetail(id);
    }

    public List<ProductMain> getWishList(int userID) {
        return ProductDao2.getInstance().getWishList(userID);
    }
    public List<ProductMain> getWishListPerPage(int currentPage, int userID) {
        int start = getStartIndex(currentPage, 15);
        return ProductDao2.getInstance().getWishList(userID);
    }

    public boolean addWishList(int userID, int productID) {
        return ProductDao2.getInstance().addWishList(userID, productID);
    }

    public ProductMain getProductDetail(int id, int size, int color){
        return ProductDao2.getInstance().getProductDetail(id, size, color);
    }

    public boolean reduceQuantity(int id, int size, int color, int amount) {
        int newQuanity = getQuantity(id, size, color) - amount;
        return ProductDao2.getInstance().reduceQuantity(id, size, color, newQuanity) != 1 ? false : true;
    }
    public boolean addProduct(Product2 product) {
        return ProductDao2.getInstance().addProduct(product);
    }

    public boolean addProduct(ProductDetail product) {
        return ProductDao2.getInstance().addProduct(product);
    }

    public boolean addProductDetail(ProductDetail product) {
        return ProductDao2.getInstance().addProductDetail(product);
    }

    public int getIdNewProduct() {
        return ProductDao2.getInstance().getIDNewProduct();
    }

    public boolean updateProduct(Product2 product) {
        return ProductDao2.getInstance().updateProduct(product);
    }
    public boolean updateProductDetail(ProductDetail product, int oldSize, int oldColor) {
        return ProductDao2.getInstance().updateProductDetail(product, oldSize, oldColor);
    }

    public boolean isExistProductDetail(int id, int size, int color) {
        return ProductDao2.getInstance().getProductDetail(id, size, color) != null ? true : false;
    }

    public boolean deleleProductAll(int id){
        return ProductDao2.getInstance().deleteProduct(id) && ProductDao2.getInstance().deleteProductDetailAll(id);
    }

    public boolean deleleProductDetail(int id, int size, int color){
        return ProductDao2.getInstance().deleteProductDetail(id, size, color);
    }
}
