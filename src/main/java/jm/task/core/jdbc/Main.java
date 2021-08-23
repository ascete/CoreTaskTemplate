package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {

            UserService userRoot = new UserServiceImpl();

            userRoot.createUsersTable();

            userRoot.saveUser("Vineamin", "Poxlebcin",  (byte) 27);
            userRoot.saveUser("Vasy", "Pypkin",  (byte) 26);
            userRoot.saveUser("Ivan", "Petrov",  (byte) 28);
            userRoot.saveUser("Andrei", "Belicyriy",  (byte) 99);
            System.out.println(userRoot.getAllUsers());

            userRoot.cleanUsersTable();

            userRoot.dropUsersTable();
        }

}
