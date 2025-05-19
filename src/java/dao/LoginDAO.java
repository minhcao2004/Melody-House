/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import model.User;
import utils.DBConnection;

public class LoginDAO {

    public User checkLogin(String username, String password) throws Exception {
        String sql = "SELECT * FROM users WHERE username=? AND password=? AND is_active=1";
        try (Connection con = new DBConnection().getConnection();
             PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, username);
            st.setString(2, password);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    return new User(
                            rs.getInt("id"),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("email"),
                            rs.getString("fullname"),
                            rs.getDate("dob") != null ? rs.getDate("dob").toLocalDate() : null,
                            rs.getInt("role_id"),
                            rs.getBoolean("is_active")                        
                    );
                }
            }
        }
        return null;
    }

    public boolean checkUsernameExists(String username) throws Exception {
        String sql = "SELECT 1 FROM users WHERE username=?";
        try (Connection con = new DBConnection().getConnection();
             PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, username);
            try (ResultSet rs = st.executeQuery()) {
                return rs.next();
            }
        }
    }

    public boolean checkEmailExists(String email) throws Exception {
        String sql = "SELECT 1 FROM users WHERE email=?";
        try (Connection con = new DBConnection().getConnection();
             PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, email);
            try (ResultSet rs = st.executeQuery()) {
                return rs.next();
            }
        }
    }

    public User getUserByEmail(String email) throws Exception {
        String sql = "SELECT * FROM users WHERE email=?";
        try (Connection con = new DBConnection().getConnection();
             PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, email);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    return new User(
                            rs.getInt("id"),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("email"),
                            rs.getString("fullname"),
                            rs.getDate("dob") != null ? rs.getDate("dob").toLocalDate() : null,
                            rs.getInt("role_id"),
                            rs.getBoolean("is_active")
                    );
                }
            }
        }
        return null;
    }
 
    
}
