package vn.hcmuaf.edu.fit.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterService {
    private static RegisterService instance;

    public RegisterService() {
    }

    public static RegisterService getInstance() {
        if (instance == null) instance = new RegisterService();
        return instance;
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

    public String checkFormLogin(String fullName, String email, String phone) {
        if (!checkFullName(fullName).equals("valid")) {
            return checkFullName(fullName);
        } else if (!checkEmail(email).equals("valid")) {
            return checkEmail(email);
        } else if (!checkPhone(phone).equals("valid")) {
            return checkPhone(phone);
        }
        return "";
    }
}
