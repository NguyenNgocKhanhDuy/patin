package vn.hcmuaf.edu.fit.services;

import vn.hcmuaf.edu.fit.bean.Rating;
import vn.hcmuaf.edu.fit.dao.RatingDao;

import java.util.List;

public class RatingService {
    private static RatingService instance;

    public RatingService() {
    }

    public static RatingService getInstance() {
        if (instance == null) instance = new RatingService();
        return instance;
    }

    public List<Rating> getAllRatingPerPage(int id, int currentPage, String sortType){
        if (sortType.equals("like")){
            return RatingDao.getInstance().getAllRatingOfProductPerPageSortLike(id, currentPage);
        } else if (sortType.equals("date")) {
            return RatingDao.getInstance().getAllRatingOfProductPerPageSortDate(id, currentPage);
        }else {
            return RatingDao.getInstance().getAllRatingOfProductPerPage(id, currentPage);
        }
    }
}
