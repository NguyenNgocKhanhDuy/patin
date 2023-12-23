package vn.hcmuaf.edu.fit.services;

import vn.hcmuaf.edu.fit.bean.User;
import vn.hcmuaf.edu.fit.dao.UserDao;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                return MailService.getInstance().sendMail("21130035@st.hcmuaf.edu.vn", String.valueOf(code));
            }
        }
    }

    public boolean reSend(String email) {
        while (true){
            int code = Integer.parseInt(randomCodeVerify());
            if (!UserDao.getInstance().isExitsCode(code)) {
                insertVerifyCode(code, email);
                return MailService.getInstance().sendMail("21130035@st.hcmuaf.edu.vn", String.valueOf(code));
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
                return MailService.getInstance().sendMail("21130035@st.hcmuaf.edu.vn", String.valueOf(code));
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

    public String checkEmail(String email) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9]+[A-Za-z0-9\\.]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$");
        Matcher matcher = pattern.matcher(email);
        if (email == null || "".equals(email)) {
            return "Email không được để trống";
        } else if (!matcher.matches()) {
            return "Email phải có định dạng \"[Tên email] @ [Tên miền]\"";
        }
        return "valid";
    }

    public String checkFullName(String fullName) {
        if (fullName == null || "".equals(fullName)) {
            return "Họ tên không được để trống";
        }
        return "valid";
    }

    public String checkAddress(String address) {
        if (address == null || "".equals(address)) {
            return "Địa chỉ không được để trống";
        }
        return "valid";
    }

    public String checkPhone(String phone) {
        Pattern pattern = Pattern.compile("\\d{10}");
        Matcher matcher = pattern.matcher(phone);
        if (phone == null || "".equals(phone)) {
            return "Số điện thoại không được để trống";
        } else if (!matcher.matches()) {
            return "Số điện thoại chỉ chứa số và có độ dài là 10";
        }
        return "valid";
    }

    public String checkForm(String fullName, String email, String phone, String address) {
        if (!checkFullName(fullName).equals("valid")) {
            return checkFullName(fullName);
        } else if (!checkEmail(email).equals("valid")) {
            return checkEmail(email);
        } else if (!checkPhone(phone).equals("valid")) {
            return checkPhone(phone);
        } else if (!checkAddress(address).equals("valid")) {
            return checkAddress(address);
        }
        return "";
    }
    public String checkForm(String fullName, String email) {
        if (!checkFullName(fullName).equals("valid")) {
            return checkFullName(fullName);
        } else if (!checkEmail(email).equals("valid")) {
            return checkEmail(email);
        }
        return "";
    }

    public void updateUser(User user) {
        UserDao.getInstance().updateUser(user);
    }

}
