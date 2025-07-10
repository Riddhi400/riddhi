package eventMS;

import java.sql.*;

public class EventService {

    public void createEvent(String name, String date, String location) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO events (name, date, location) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setDate(2, Date.valueOf(date));
            stmt.setString(3, location);
            stmt.executeUpdate();
        }
    }

    public void registerUser(String name, String email) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.executeUpdate();
        }
    }

    public void assignUserToEvent(int userId, int eventId) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO registrations (event_id, user_id) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, eventId);
            stmt.setInt(2, userId);
            stmt.executeUpdate();
        }
    }

    public void viewEvents() throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM events");
            System.out.println("\n--- Events ---");
            while (rs.next()) {
                System.out.printf("ID: %d | %s | %s | %s\n",
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDate("date"),
                    rs.getString("location"));
            }
        }
    }

    public void viewParticipants(int eventId) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT u.name, u.email FROM users u JOIN registrations r ON u.id = r.user_id WHERE r.event_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, eventId);
            ResultSet rs = stmt.executeQuery();
            System.out.println("\n--- Participants ---");
            while (rs.next()) {
                System.out.printf("Name: %s | Email: %s\n", rs.getString("name"), rs.getString("email"));
            }
        }
    }
}