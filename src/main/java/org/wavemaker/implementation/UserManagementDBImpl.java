package org.wavemaker.implementation;
import org.wavemaker.connection.MySQLConnection;
import org.wavemaker.model.User;
import org.wavemaker.userinterface.UserOperations;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class UserManagementDBImpl implements UserOperations {
    public void addUser(User user){
        Connection connection= MySQLConnection.getConnection();
        String sql="insert into user values(?,?,?)";
        try{
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setInt(1,user.getId());
            statement.setString(2,user.getName());
            statement.setString(3, user.getCity());
            int result= statement.executeUpdate();
            System.out.println(result+"rows affected");
        }
        catch (SQLException e){
            System.out.println("Can't Execute Query");
            e.printStackTrace();
        }
    }
    public void updateUser(User user){
        Connection connection= MySQLConnection.getConnection();
        String sql="update user set name=? ,city=? where id=?";
        try{
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getCity());
            statement.setInt(3,user.getId());
            int result=statement.executeUpdate();
            System.out.println(result+"rows affected");
        }
        catch (SQLException e){
            System.out.println("Can't Execute Query");
            e.printStackTrace();
        }
    }
    public void deleteUser(int id){
        Connection connection= MySQLConnection.getConnection();
        String sql="delete from user where id=?";
        try{
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setInt(1,id);
            int result=statement.executeUpdate();
            System.out.println(result+"rows affected");
        }
        catch (SQLException e){
            System.out.println("Can't Execute Query");
            e.printStackTrace();
        }
    }
    public List<User> searchUser(String userName){
        Connection connection= MySQLConnection.getConnection();
        List<User> searchList=new ArrayList<>();
        String sql="select * from user where name=?";
        try {
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setString(1, userName);
            ResultSet resultSet =statement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String city=resultSet.getString("city");
                searchList.add(new User(id,name,city));
            }
        }
        catch (SQLException e){
            System.out.println("Can't Execute Query");
            e.printStackTrace();
        }
        return searchList;
    }
    public List<User> getUsers(){
        Connection connection= MySQLConnection.getConnection();
        List<User> usersList=new ArrayList<>();
        String sql="select * from user";
        try{
            Statement statement= connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String city=resultSet.getString("city");
                usersList.add(new User(id,name,city));
            }
        }
        catch (SQLException e){
            System.out.println("Can't Execute Query");
            e.printStackTrace();
        }
        return usersList;
    }
}
