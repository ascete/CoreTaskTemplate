package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {

            UserService userRoot = new UserServiceImpl();

            userRoot.createUsersTable();

            userRoot.saveUser("Vineamin", "Poxlebcin",  27);
            userRoot.saveUser("Vasy", "Pypkin",  26);
            userRoot.saveUser("Ivan", "Petrov",  28);
            userRoot.saveUser("Andrei", "Belicyriy",  99);


            System.out.println(userRoot.getAllUsers());

            userRoot.cleanUsersTable();

            userRoot.dropUsersTable();
        }

}
