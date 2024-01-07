package vn.hcmuaf.edu.fit.dao;

import vn.hcmuaf.edu.fit.bean.ImageRating;
import vn.hcmuaf.edu.fit.bean.Rating;
import vn.hcmuaf.edu.fit.bean.RatingLike;
import vn.hcmuaf.edu.fit.db.JDBIConnector;

import java.util.List;
import java.util.stream.Collectors;

public class RatingDao {
    private static RatingDao instance;

    public RatingDao() {
    }

    public static RatingDao getInstance() {
        if (instance == null) instance = new RatingDao();
        return instance;
    }

    public List<Rating> getAllRating(){
        List<Rating> ratings = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT * FROM rating").mapToBean(Rating.class).stream().collect(Collectors.toList());
        });
        return ratings;
    }

    public List<Rating> getAllRatingOfProduct(int id){
        List<Rating> ratings = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT rating.id, rating.score, rating.content, rating.date, user.fullname as user_fullname, user.avatar as user_avatar " +
                            "FROM rating JOIN user ON rating.user_id = user.id " +
                            "WHERE product_id = :id")
                    .bind("id", id).mapToBean(Rating.class).stream().collect(Collectors.toList());
        });
        return ratings;
    }

    public List<ImageRating> getImageRatingOfProduct(int id){
        List<ImageRating> ratings = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT image_rating.url, image_rating.rating_id " +
                            "FROM image_rating JOIN rating ON image_rating.rating_id = rating.id " +
                            "WHERE product_id = :id")
                    .bind("id", id).mapToBean(ImageRating.class).stream().collect(Collectors.toList());
        });
        return ratings;
    }

    public List<Rating> getAllRatingOfProductPerPage(int id, int currentPage){
        int start = getStartIndex(currentPage, 3);
        List<Rating> ratings = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT rating.id, rating.score, rating.content, rating.date, user.fullname as user_fullname, user.avatar as user_avatar " +
                            "FROM rating JOIN user ON rating.user_id = user.id " +
                            "WHERE product_id = :id " +
                            "LIMIT :start, 3")
                    .bind("id", id).bind("start", start)
                    .mapToBean(Rating.class).stream().collect(Collectors.toList());
        });
        return ratings;
    }

    public List<Rating> getAllRatingOfProductPerPageSortLike(int id, int currentPage){
        int start = getStartIndex(currentPage, 3);
        List<Rating> ratings = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT rating.id, rating.score, rating.content, rating.date, user.fullname as user_fullname, user.avatar as user_avatar, COUNT(rating_detail_like.like) as count_like " +
                            "FROM rating_detail_like JOIN rating on rating.id = rating_detail_like.rating_id JOIN user ON rating.user_id = user.id " +
                            "WHERE product_id = :id AND rating_detail_like.like = 1 " +
                            "GROUP BY rating.id " +
                            "ORDER BY count_like desc " +
                            "LIMIT :start, 3")
                    .bind("id", id).bind("start", start)
                    .mapToBean(Rating.class).stream().collect(Collectors.toList());
        });
        return ratings;
    }

    public List<Rating> getAllRatingOfProductPerPageSortDate(int id, int currentPage){
        int start = getStartIndex(currentPage, 3);
        List<Rating> ratings = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT rating.id, rating.score, rating.content, rating.date, user.fullname as user_fullname, user.avatar as user_avatar " +
                            "FROM rating JOIN user ON rating.user_id = user.id " +
                            "WHERE product_id = :id " +
                            "ORDER BY rating.date desc "+
                            "LIMIT :start, 3")
                    .bind("id", id).bind("start", start)
                    .mapToBean(Rating.class).stream().collect(Collectors.toList());
        });
        return ratings;
    }

    public List<ImageRating> getImageRatingOfProductPerPage(int id, int currentPage){
        int start = getStartIndex(currentPage, 3);
        List<ImageRating> ratings = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT image_rating.url, image_rating.rating_id " +
                            "FROM image_rating JOIN rating ON image_rating.rating_id = rating.id " +
                            "WHERE product_id = :id " +
                            "LIMIT :start, 3")
                    .bind("id", id).bind("start", start)
            .mapToBean(ImageRating.class).stream().collect(Collectors.toList());
        });
        return ratings;
    }

    public int getStartIndex(int currentPage, int productPerPage) {
        if (currentPage > 1) {
            return  ((currentPage - 1) * productPerPage);
        } else {
            return  0;
        }
    }

    public List<RatingLike> getLike(int productID) {
        List<RatingLike> ratingLikes = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT rating.id as rating_id, rating_detail_like.user_id as user_id " +
                    "FROM rating_detail_like JOIN rating ON rating_detail_like.rating_id = rating.id " +
                    "WHERE rating_detail_like.like = 1 and rating.product_id = ?")
                    .bind(0, productID).mapToBean(RatingLike.class).stream().collect(Collectors.toList());
        });
        return ratingLikes;
    }
    public void insert(String path){
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("INSERT Into image_rating(id, url, rating_id) values (4, ?, 1)").bind(0, path).execute();
        });
    }
}
