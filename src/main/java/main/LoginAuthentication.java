package main;

import entities.user.User;
import entities.user.UserDaoImpl;

public class LoginAuthentication {

    public LoginAuthentication() { }

    public User loginAuth(String email, String password) {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.getUserByEmailAndPassword(email, password);

        return user;
    }
}
