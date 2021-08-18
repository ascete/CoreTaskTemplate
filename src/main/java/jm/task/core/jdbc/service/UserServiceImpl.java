package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDaoImp = new UserDaoJDBCImpl();
    @Override
    public void createUsersTable() {
        userDaoImp.createUsersTable();
    }

    @Override
    public void dropUsersTable() {
        userDaoImp.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, int age) {
        userDaoImp.saveUser(name, lastName, age);
    }

    @Override
    public void removeUserById(long id) {
        userDaoImp.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDaoImp.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {
        userDaoImp.cleanUsersTable();
    }
}
