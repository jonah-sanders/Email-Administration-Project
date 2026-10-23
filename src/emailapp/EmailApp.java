package emailapp;

public class EmailApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String firstName = "Jason";
        String lastName = "Bourne";

        String department = setDepartment(input, firstName, lastName);

        Email email1 = new Email("Jason", "Bourne");

        System.out.println("Your password is: " + email1.getPassword());
        System.out.println(email1.showPersonalInfo());
        input.close();
    }

    
}
