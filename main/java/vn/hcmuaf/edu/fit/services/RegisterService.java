package vn.hcmuaf.edu.fit.services;


public class RegisterService {
    private static RegisterService instance;

    public RegisterService() {
    }

    public static RegisterService getInstance() {
        if (instance == null) instance = new RegisterService();
        return instance;
    }

//    public String checkEmail(String email) {
//        Pattern pattern = Pattern.compile("^[A-Za-z0-9]+[A-Za-z0-9\\.]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$");
//        Matcher matcher = pattern.matcher(email);
//        if (email == null || "".equals(email)) {
//            return "Email không được để trống";
//        } else if (!matcher.matches()) {
//            return "Email phải có định dạng \"[Tên email] @ [Tên miền]\"";
//        }
//        return "valid";
//    }

//    public String checkFullName(String fullName) {
//        if (fullName == null || "".equals(fullName)) {
//            return "Họ tên không được để trống";
//        }
//        return "valid";
//    }

//    public String checkPhone(String phone) {
//        Pattern pattern = Pattern.compile("\\d{10}");
//        Matcher matcher = pattern.matcher(phone);
//        if (phone == null || "".equals(phone)) {
//            return "Số điện thoại không được để trống";
//        } else if (!matcher.matches()) {
//            return "Số điện thoại chỉ chứa số và có độ dài là 10";
//        }
//        return "valid";
//    }

    public String checkFormLogin(String fullName, String email, String phone) {
        if (!UserService.getInstance().checkFullName(fullName).equals("valid")) {
            return UserService.getInstance().checkFullName(fullName);
        } else if (!UserService.getInstance().checkEmail(email).equals("valid")) {
            return UserService.getInstance().checkEmail(email);
        } else if (!UserService.getInstance().checkPhone(phone).equals("valid")) {
            return UserService.getInstance().checkPhone(phone);
        }
        return "";
    }

    public String register(String email, String password, String confirmPass, String fullname, String address, String phone) {
        if (UserService.getInstance().isUserExists(email)){
            return "Đã tồn tại tài khoản sử dụng email";
        } else if (!password.equals(confirmPass)) {
            return "Mật khẩu không đúng";
        }else {
            UserService.getInstance().register(email, password, fullname, address, phone);
            return "Đăng ký thành công";
        }
    }

    public long getCurrentTime() {
        Long current = System.currentTimeMillis();
        return current;
    }
}
