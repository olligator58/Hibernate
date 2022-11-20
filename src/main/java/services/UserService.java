package services;

import dao.AutoDao;
import dao.UserDao;
import models.Auto;
import models.User;

import java.util.List;

public class UserService {

    private UserDao usersDao = new UserDao();
    private AutoDao autoDao = new AutoDao();

    public UserService() {
    }

    public User findUser(int id) {
        return usersDao.findById(id);
    }

    public void saveUser(User user) {
        usersDao.save(user);
    }

    public void deleteUser(User user) {
        usersDao.delete(user);
    }

    public void updateUser(User user) {
        usersDao.update(user);
    }

    public List<User> findAllUsers() {
        return usersDao.findAll();
    }


    public void deleteAll() {
        for (User user : findAllUsers()) {
            for (Auto auto : user.getAutos()) {
                autoDao.delete(auto);
            }
            deleteUser(user);
        }


    }


}