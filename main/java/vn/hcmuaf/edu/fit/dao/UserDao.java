package vn.hcmuaf.edu.fit.dao;

import db.JDBIConnector;
import vn.hcmuaf.edu.fit.bean.User;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;

public class UserDao {
    private static UserDao instance;

    public UserDao() {
    }

    public static UserDao getInstance() {
        if (instance == null) instance = new UserDao();
        return instance;
    }

    public User checkLogin(String email, String password) {
        List<User> users = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT email, password " +
                            "FROM user " +
                            "WHERE verify = 1 and email = ?")
                    .bind(0, email)
                    .mapToBean(User.class).stream().collect(Collectors.toList());
        });

        if (users.size() != 1) return null;
        User user = users.get(0);
        if (!user.getEmail().equals(email) || !user.getPassword().equals(hashPassword(password)))
            return null;
        return user;
    }

    public List<User> getUserByEmail(String email) {
        List<User> users = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT email " +
                            "FROM user " +
                            "WHERE email = ?")
                    .bind(0, email)
                    .mapToBean(User.class).stream().collect(Collectors.toList());
        });
        return users;
    }

    public String hashPassword(String password){
        try {
            MessageDigest sha256 = null;
            sha256 = MessageDigest.getInstance("SHA-256");
            byte[] hash = sha256.digest(password.getBytes());
            BigInteger number = new BigInteger(1, hash);
            return number.toString(16);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

}
