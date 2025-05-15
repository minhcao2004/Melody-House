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
                            rs.getBoolean("is_active"),
                            rs.getString("reset_token"),
                            rs.getDate("reset_token_expiry") != null ? rs.getDate("reset_token_expiry").toLocalDate() : null
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
                            rs.getBoolean("is_active"),
                            rs.getString("reset_token"),
                            rs.getDate("reset_token_expiry") != null ? rs.getDate("reset_token_expiry").toLocalDate() : null
                    );
                }
            }
        }
        return null;
    }

    public void updateResetToken(String email, String token, java.sql.Date expiryDate) throws Exception {
        String sql = "UPDATE users SET reset_token=?, reset_token_expiry=? WHERE email=?";
        try (Connection con = new DBConnection().getConnection();
             PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, token);
            st.setDate(2, expiryDate);
            st.setString(3, email);
            st.executeUpdate();
        }
    }

    public User getUserByResetToken(String token) throws Exception {
        String sql = "SELECT * FROM users WHERE reset_token=? AND reset_token_expiry > GETDATE()";
        try (Connection con = new DBConnection().getConnection();
             PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, token);
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
                            rs.getBoolean("is_active"),
                            rs.getString("reset_token"),
                            rs.getDate("reset_token_expiry") != null ? rs.getDate("reset_token_expiry").toLocalDate() : null
                    );
                }
            }
        }
        return null;
    }

    public void updatePassword(User user, String newPassword) throws Exception {
        String sql = "UPDATE users SET password=?, reset_token=NULL, reset_token_expiry=NULL WHERE id=?";
        try (Connection con = new DBConnection().getConnection();
             PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, newPassword);
            st.setInt(2, user.getId());
            st.executeUpdate();
        }
    }
}
