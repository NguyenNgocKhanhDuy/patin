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

    public boolean register(String email, String password, String fullname, String address, String phone) {
        UserDao.getInstance().addUser(email, password, 0, fullname, address, phone, 0);
        while (true){
            int code = Integer.parseInt(randomCodeVerify());
            if (!UserDao.getInstance().isExitsCode(code)) {
                insertVerifyCode(code, email);
                return MailService.getInstance().sendMailVerifyCode("21130035@st.hcmuaf.edu.vn", String.valueOf(code));
            }
        }
    }

    public boolean reSend(String email) {
        while (true){
            int code = Integer.parseInt(randomCodeVerify());
            if (!UserDao.getInstance().isExitsCode(code)) {
                insertVerifyCode(code, email);
                return MailService.getInstance().sendMailVerifyCode("21130035@st.hcmuaf.edu.vn", String.valueOf(code));
            }
        }
    }

    public void insertVerifyCode(int code, String email) {
        UserDao.getInstance().verify(code, email);
    }

    public boolean verifyMail(int code, String email) {
        if (UserDao.getInstance().getVerifyByEmail(email) == code){
            UserDao.getInstance().verify(1, email);
            return true;
        }
        return false;
    }

    public boolean sendforgetPass(String email) {
        while (true){
            int code = Integer.parseInt(randomCodeVerify());
            if (!UserDao.getInstance().isExitsCodePass(code)) {
                UserDao.getInstance().keyForgetPass(code, email);
                return MailService.getInstance().sendMailVerifyCode("21130035@st.hcmuaf.edu.vn", String.valueOf(code));
            }
        }
    }

    public boolean checkKey(int code, String email) {
        return code == UserDao.getInstance().getKey(email);
    }

    public boolean changePass(String email, String pass, String confirmPass) {
        if (pass.equals(confirmPass)) {
            UserDao.getInstance().updatePass(email, pass);
            return true;
        }
        return false;
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
