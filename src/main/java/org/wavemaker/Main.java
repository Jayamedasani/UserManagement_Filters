package org.wavemaker;

import org.wavemaker.implementation.UserManagementDBImpl;
import org.wavemaker.implementation.UserManagementInMemoryImpl;
import org.wavemaker.model.User;
import org.wavemaker.userinterface.UserOperations;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("1.InMemory User Operations");
        System.out.println("2.Database User Operations");
        System.out.println("3.Exit");
        System.out.print("Enter Your Choice:");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if (choice == 1) {
            UserOperations userOperations = new UserManagementInMemoryImpl();
            while (true) {
                System.out.println("*******MENU*******");
                System.out.println("1. Display Users");
                System.out.println("2. Add User");
                System.out.println("3. Delete User");
                System.out.println("4. Search User");
                System.out.println("5. Update User");
                System.out.println("6. Exit");
                System.out.print("Select your choice:");
                int ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        List<User> users = userOperations.getUsers();
                        for (User user : users) {
                            System.out.println("UserID:" + user.getId() + "\tUserName:" + user.getName() + "\tCity:" + user.getCity());
                        }
                        break;
                    case 2:
                        System.out.print("Enter User ID:");
                        int id = sc.nextInt();
                        System.out.print("Enter User Name:");
                        String name = sc.next();
                        System.out.print("Enter User city:");
                        String city = sc.next();
                        userOperations.addUser(new User(id, name, city));
                        break;
                    case 3:
                        System.out.println("Enter user_ID to remove:");
                        int userid = sc.nextInt();
                        userOperations.deleteUser(userid);
                        break;
                    case 4:
                        System.out.println("Enter User Name to search:");
                        String username = sc.next();
                        List<User> list = userOperations.searchUser(username);
                        for (User user : list) {
                            System.out.println("UserID:" + user.getId() + "\tUserName:" + user.getName() + "\tUserCity:" + user.getCity());
                        }
                        break;
                    case 5:
                        System.out.println("Enter userID to be update:");
                        int uid = sc.nextInt();
                        System.out.println("Enter Username to be update:");
                        String uname = sc.next();
                        System.out.println("Enter User City to be update:");
                        String ucity = sc.next();
                        userOperations.updateUser(new User(uid, uname, ucity));
                        break;
                    case 6:
                        System.out.println("ThankYou!!");
                        System.exit(1);
                    default:
                        System.out.println("Enter valid choice");
                }
            }
        } else if (choice == 2) {
            UserOperations userOperations = new UserManagementDBImpl();
            while (true) {
                System.out.println("*******MENU*******");
                System.out.println("1. Display Users");
                System.out.println("2. Add User");
                System.out.println("3. Delete User");
                System.out.println("4. Search User");
                System.out.println("5. Update User");
                System.out.println("6. Exit");
                System.out.print("Select your choice:");
                int ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        List<User> users = userOperations.getUsers();
                        for (User user : users) {
                            System.out.println("UserID:" + user.getId() + "\tUserName:" + user.getName() + "\tCity:" + user.getCity());
                        }
                        break;
                    case 2:
                        System.out.print("Enter User ID:");
                        int id = sc.nextInt();
                        System.out.print("Enter User Name:");
                        String name = sc.next();
                        System.out.print("Enter User city:");
                        String city = sc.next();
                        userOperations.addUser(new User(id, name, city));
                        break;
                    case 3:
                        System.out.println("Enter user_ID to remove:");
                        int userid = sc.nextInt();
                        userOperations.deleteUser(userid);
                        break;
                    case 4:
                        System.out.println("Enter User Name to search:");
                        String username = sc.next();
                        List<User> list = userOperations.searchUser(username);
                        for (User user : list) {
                            System.out.println("UserID:" + user.getId() + "\tUserName:" + user.getName() + "\tUserCity:" + user.getCity());
                        }
                        break;
                    case 5:
                        System.out.println("Enter userID to be update:");
                        int uid = sc.nextInt();
                        System.out.println("Enter Username to be update:");
                        String uname = sc.next();
                        System.out.println("Enter User City to be update:");
                        String ucity = sc.next();
                        userOperations.updateUser(new User(uid, uname, ucity));
                        break;
                    case 6:
                        System.out.println("ThankYou!!");
                        System.exit(1);
                    default:
                        System.out.println("Enter valid choice");
                }
            }
        }
        else{
            System.out.println("ThankYou!!");
            System.exit(1);
        }
    }
}