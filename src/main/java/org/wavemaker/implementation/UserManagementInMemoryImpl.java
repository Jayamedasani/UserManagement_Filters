package org.wavemaker.implementation;

import org.wavemaker.exception.IDAlreadyExistsException;
import org.wavemaker.exception.IDNotFoundException;
import org.wavemaker.model.User;
import org.wavemaker.userinterface.UserOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserManagementInMemoryImpl implements UserOperations {
    private List<User> userList = new ArrayList<>();

    @Override
    public void addUser(User newUser) {
        User existingUser = getUserDetails(newUser.getId());
        try {
            if (existingUser != null) {
                throw new IDAlreadyExistsException("User with given ID is already available enter new ID");
//                System.out.println("User with given ID is already available enter new ID");
            } else {
                userList.add(newUser);
                System.out.println("User Added to list!");
            }
        } catch (IDAlreadyExistsException e) {

        }
    }

    @Override
    public void deleteUser(int id) {
        try {
            if (userList.isEmpty()) {
                System.out.println("Users List is empty can't delete from list");
            } else {
                User existingUser = getUserDetails(id);
                if (existingUser == null) {
                    throw new IDNotFoundException("User with given ID is not available can't delete");
//                    System.out.println("User with given ID is not available can't delete");
                } else {
                    userList.remove(existingUser);
                    System.out.println("User removed from list!");
                }
            }
        } catch (IDNotFoundException e) {

        }
    }

    @Override
    public List<User> searchUser(String userName) {
        List<User> searchList = new ArrayList<>();
        ArrayList<String> nameList = new ArrayList<>();
        try {
            for (User user : userList) {
                nameList.add(user.getName());
            }
            if (nameList.contains(userName)) {
                for (User user : userList) {
                    if (user.getName().equals(userName)) {
                        searchList.add(user);
                    }
                }
                return searchList;
            } else {
                throw new IDNotFoundException("User with given name is Not available");
//            System.out.println("User with given name is Not available");
            }
        } catch (IDNotFoundException e) {

        }
        return searchList;
    }

    @Override
    public List<User> getUsers() {
        if (userList.isEmpty()) {
            System.out.println("No Users are available");
        }
        return userList;
    }

    @Override
    public void updateUser(User userDetails) {
        try {
            User existingUser = getUserDetails(userDetails.getId());
            if (existingUser == null) {
                throw new IDNotFoundException("User with given details is not available can't Update");
//            System.out.println("User with given details is not available can't Update");
            } else {
                existingUser.setName(userDetails.getName());
                existingUser.setCity(userDetails.getCity());
                System.out.println("User Details are updated!");
            }
        }
        catch (IDNotFoundException e){

        }
    }

    private User getUserDetails(int id) {
        for (User user : userList) {
            if (Objects.equals(user.getId(), id)) {
                return user;
            }
        }
        return null;
    }
}
