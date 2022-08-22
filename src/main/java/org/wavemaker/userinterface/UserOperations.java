package org.wavemaker.userinterface;
import org.wavemaker.exception.IDNotFoundException;
import org.wavemaker.model.User;
import java.util.List;
public interface UserOperations {
    void addUser(User user);
    void deleteUser(int id);
    void updateUser(User user);
    List<User> getUsers();
    List<User> searchUser(String name);
}
