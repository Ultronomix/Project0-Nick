package com.github.NickNSX.users;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.github.NickNSX.common.datasource.ConnectionFactory;

// DAO = Data Access Object 
public class UserDAO {

    public List<User> getAllUsers() {

        String sql = "SELECT * " +
                "FROM tasks.user_task";

        List<User> allUsers = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setTask(rs.getString("task"));
                allUsers.add(user);
            }

        } catch (SQLException e) {
            // TODO: handle exception
            System.err.println("Something went wrong");
            e.printStackTrace();
        }

        return allUsers;
    }

    public String deleteEntry(User user) {

        String sqlDelete = "DELETE FROM tasks.user_task " +
                "WHERE name = ?";

        getAllUsers();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            PreparedStatement pstmt = conn.prepareStatement(sqlDelete);
            pstmt.setString(1, user.getName().trim().toUpperCase());

            pstmt.executeUpdate();

        } catch (Exception e) {
            // TODO: handle exception
            System.err.println("Something went wrong.");
            e.printStackTrace();
        }

        return "Entry removed";
    }

    public String save(User user) {
        String sql = "INSERT INTO tasks.user_task(name, task) " +
                "VALUES(?, ?)";

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getName().trim().toUpperCase());
            pstmt.setString(2, user.getTask().trim());

            pstmt.executeUpdate();

        } catch (Exception e) {
            // TODO: handle exception
            System.err.println("Something went wrong.");
            e.printStackTrace();
        }

        return user.getName() + " " + user.getTask();
    }
}
