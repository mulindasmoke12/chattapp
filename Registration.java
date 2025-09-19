package chatapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Registration {
    private final String firstName;
    private final String lastName;
    private final String password;
    private final String username;
    private final String phoneNumber;

    // Static list to store registered users
    private static final List<Registration> users = new ArrayList<>();

    // Constructor
    public Registration(String firstName, String lastName, String username, String password, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    // Getters (needed by Login)
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getPhoneNumber() { return phoneNumber; }

    // Access to registered users
    public static List<Registration> getUsers() {
        return users;
    }

    // Start registration process (console)
    public static void startRegistration() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== User Registration ===");

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();

        // Save user
        users.add(new Registration(firstName, lastName, username, password, phoneNumber));

        System.out.println("\n✅ Registration successful!\n");
    }
}