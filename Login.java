package chatapp;

import javax.swing.*;
import java.util.List;

public class Login {

    public void beginLogin(List<Registration> users) {
        // Check if any users are registered
        if (users == null || users.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No users registered yet. Please register first.");
            return;
        }

        // Prompt user for username
        String username = JOptionPane.showInputDialog("Enter your username:");
        if (username == null || username.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Login cancelled.");
            return;
        }

        // Prompt user for password (masked)
        JPasswordField passwordField = new JPasswordField();
        int option = JOptionPane.showConfirmDialog(
                null,
                passwordField,
                "Enter your password",
                JOptionPane.OK_CANCEL_OPTION
        );

        if (option != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Login cancelled.");
            return;
        }

        String password = new String(passwordField.getPassword());

        // Validate credentials
        for (Registration user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                JOptionPane.showMessageDialog(null,
                        "✅ Login successful! Welcome, " + user.getFirstName() + " " + user.getLastName() + " 🎉");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "❌ Login failed. Invalid username or password.");
    }

    // Main method to tie Registration + Login together
    public static void main(String[] args) {
        // 1. Register at least one user (console input)
        Registration.startRegistration();

        // 2. Start login process (GUI)
        Login login = new Login();
        login.beginLogin(Registration.getUsers());
    }
}