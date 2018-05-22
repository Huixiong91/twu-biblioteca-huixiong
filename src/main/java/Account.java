import java.util.ArrayList;
import java.util.List;

public class Account {
    private String username;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;

    public Account(String username, String password, String name, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

    String getName() {
        return name;
    }

    String getEmail() {
        return email;
    }

    String getPhoneNumber() {
        return phoneNumber;
    }

    void displayInfo() {
        System.out.println("Your information");
        System.out.println("Name: " + getName() + "     Email: " + getEmail() + "      Phone Number: " + getPhoneNumber());
    }
}
