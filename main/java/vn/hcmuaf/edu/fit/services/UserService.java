package vn.hcmuaf.edu.fit.services;

import vn.hcmuaf.edu.fit.bean.User;
import vn.hcmuaf.edu.fit.dao.UserDao;

import java.util.Random;

public class UserService {
    private static UserService instance;

    public UserService() {
    }

    public static UserService getInstance() {
        if (instance == null) instance = new UserService();
        return instance;
    }

    public User checkLogin(String email, String password) {
        return UserDao.getInstance().checkLogin(email, password);
    }

    public boolean isUserExists(String email){
        if (UserDao.getInstance().getUserByEmail(email).size() > 0)
            return true;
        return false;
    }

    public void register(String email, String password, String fullname, String address, String phone) {
        UserDao.getInstance().addUser(email, password, 0, fullname, address, phone, 0);
        while (true){
            int code = Integer.parseInt(randomCodeVerify());
            if (!UserDao.getInstance().isExitsCode(code)) {
                insertVerifyCode(code, email);
                MailService.getInstance().sendMailVerifyCode("21130035@st.hcmuaf.edu.vn", String.valueOf(code));
                break;
            }
        }
    }

    public void insertVerifyCode(int code, String email) {
        UserDao.getInstance().verify(code, email);
    }

    public void verifyMail(String email) {
        UserDao.getInstance().verify(1, email);
    }

    public String randomCodeVerify() {
        Random random = new Random();
        String result = "";
        for (int i = 0; i < 6; i++) {
            result += (random.nextInt(9)+1);
        }
        return result;
    }


}
