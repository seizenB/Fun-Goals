package id.test.test.Models;

import java.security.NoSuchAlgorithmException;

import id.test.test.Utils.PasswordEncryption;

public class User {
    private String name;
    private String username;
    private String password;

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        try {
            this.password = PasswordEncryption.encryptPassword(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace(); // Handle the exception as needed
            this.password = null; // Set password to null or handle appropriately
        }
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean validate() {
        return name != null && !name.isEmpty() &&
                username != null && !username.isEmpty() &&
                password != null && !password.isEmpty();
    }
}
