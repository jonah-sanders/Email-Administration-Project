package emailapp;
import java.security.SecureRandom;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int inboxCapacity = 500;
    private String alternativeEmail;
    private static final int DEFAULT_PASSWORD_LENGTH = 10;
    private static final String COMPANY_SUFFIX = "randomcompany.com";

    //Constructor for receiving the first and last name and department
    public Email(String firstName, String lastName, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;

        //Calls a method that returns a random password
        this.password = randomPassword(DEFAULT_PASSWORD_LENGTH);
        
        //Combines the components of the email address
        if (department.isEmpty()) {
            email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + COMPANY_SUFFIX;
        } else {
            email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + COMPANY_SUFFIX;
        }
    }

    //Generating a random password
    private String randomPassword(int length) {
        String charSelection = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890?_-+*&$#@!";
        SecureRandom random = new SecureRandom();
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = random.nextInt(charSelection.length());
            password[i] = charSelection.charAt(rand);
        }
        return new String(password);
    }

    //Setting the mailbox capacity
    public void setInboxCapacity(int capacity) {
        if (capacity > 0) {
            this.inboxCapacity = capacity;
        } else {
            System.out.println("Inbox capacity must be greater than 0.");
        }
    }
    //Setting the alternate email
    public void setAlternativeEmail(String altEmail) {
        this.alternativeEmail = altEmail;
    }

    //Changing the password
    public void changePassword(String password) {
        if (password != null && !password.isEmpty()) {
            this.password = password;
        } else {
            System.out.println("Password cannot be empty.");
        }
    }

    //Getters
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public int getInboxCapacity() {
        return inboxCapacity;
    }
    public String getAlternativeEmail() {
        return alternativeEmail;
    }

    public String showPersonalInfo() {
        return "FULL NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nINBOX CAPACITY: " + inboxCapacity + "mb";
    }
}
