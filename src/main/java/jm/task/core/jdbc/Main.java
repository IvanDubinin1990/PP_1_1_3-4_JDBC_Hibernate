package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь

        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
//        userDaoJDBC.saveUser("BORIS", "Borisov", (byte) 20);
//        userDaoJDBC.saveUser("Ivan", "Ivanov", (byte) 20);
//        userDaoJDBC.saveUser("Nikolay", "Nikolaev", (byte) 20);
//        userDaoJDBC.saveUser("Petr", "Petrov", (byte) 20);

//        userDaoJDBC.removeUserById(12);

        userDaoJDBC.cleanUsersTable();




    }
}
