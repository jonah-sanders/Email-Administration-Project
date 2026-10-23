package emailapp;
import java.util.Scanner;

public class EmailApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String firstName = "Jason";
        String lastName = "Bourne";

        String department = setDepartment(input, firstName, lastName);

        Email email1 = new Email(firstName, lastName, department);

        System.out.println("Your password is: " + email1.getPassword());
        System.out.println(email1.showPersonalInfo());

        //Displaying current account settings
        email1.setAlternativeEmail("jason.alternative@yahoo.com");
        email1.setInboxCapacity(1000);
        email1.changePassword("BourneI$theB3st");

        System.out.println("\nUPDATED SETTINGS:");
        System.out.println("Alternate email: " + email1.getAlternativeEmail());
        System.out.println("Inbox capacity: " + email1.getInboxCapacity() + "mb");
        System.out.println("Password: " + email1.getPassword());

        //Checking for case conditions against invalid inputs
        email1.setInboxCapacity(-50);
        email1.changePassword("");

        input.close();
    }

    //Asking for department
    private static String setDepartment(Scanner input, String firstName, String lastName) {        
        while (true) {
            System.out.print("New worker: " + firstName + " " + lastName + "\n" +
                "DEPARTMENT OPTIONS:\n" +
                "1 for Information Technology\n" +
                "2 for Sales\n" +
                "3 for Human Resources\n" +
                "4 for Development\n" +
                "5 for Accounting\n" +
                "6 for Marketing\n" +
                "0 for None\n" +
                "Indicate your department: ");
            
            //Making sure the user enters a number
            if (!input.hasNextInt()) {
                System.out.println("Please enter a number from 0 to 6.\n");
                input.next(); //Throws away the invalid input
                continue;    //Prompts the user again
            }
            
            int depNumber = input.nextInt();

            switch (depNumber) {
                case 1: return "it";
                case 2: return "sales";
                case 3: return "hr";
                case 4: return "dev";
                case 5: return "acct";
                case 6: return "marketing";
                case 0: return "";
                default: System.out.println("Invalid option. Please input a number between 0 and 6.\n");
            }
        }
    }    
}
