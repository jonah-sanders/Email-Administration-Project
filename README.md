# Email Administration App

A Java console application that sets up company email accounts for new employees. Choose an employee's department from a menu, and the app generates their company email address and a secure random password, then lets you manage the account's settings.

## Features

- **Automatic email generation** — builds each address from the employee's name and department, in the format `firstname.lastname@department.company.com` (or `firstname.lastname@company.com` when no department is chosen)
- **Department selection with input validation** — a menu of six departments (IT, Sales, HR, Development, Accounting, Marketing) or none; letters and out-of-range numbers are rejected and the user is asked again
- **Secure password generation** — creates a 10-character password from letters, numbers and special characters using Java's `SecureRandom`
- **Account settings** — change the password, set an alternate email, and adjust inbox capacity (500 MB by default)
- **Settings validation** — rejects empty passwords and inbox capacities of zero or less
- **Account summary** — displays the employee's full name, company email and inbox capacity

## Built With

- Java
- IntelliJ IDEA

## Design

The project is split into two classes, each with a single responsibility:

- **`Email`** — holds an account's data and builds the email address and password. It does no input or output, so it can be reused anywhere, for example with data from a form or a file, and tested on its own.
- **`EmailApp`** — handles all interaction with the user: showing the department menu, validating input, creating the account and printing results.

## Concepts Demonstrated

- Object-oriented programming: classes, objects and constructors
- Encapsulation with private fields and public getter and setter methods
- Separation of concerns between business logic and the user interface
- Input validation with `Scanner.hasNextInt()`, loops and `switch` statements
- Secure random value generation with `SecureRandom`
- Constants with `static final`

## How to Run

**In IntelliJ IDEA:** open the project folder and run `EmailApp.java`.

**From the command line:**

```bash
javac -d out src/emailapp/*.java
java -cp out emailapp.EmailApp
```

When prompted, enter a number for the employee's department.

## Example Output

```
New worker: Jason Bourne
DEPARTMENT OPTIONS:
1 for Information Technology
2 for Sales
3 for Human Resources
4 for Development
5 for Accounting
6 for Marketing
0 for None
Indicate your department: x
Please enter a number from 0 to 6.

...
Indicate your department: 1
Your password is: 7AvqJFn@9!
FULL NAME: Jason Bourne
COMPANY EMAIL: jason.bourne@it.randomcompany.com
INBOX CAPACITY: 500mb

UPDATED SETTINGS:
Alternate email: jason.alternative@yahoo.com
Inbox capacity: 1000mb
Password: BourneI$theB3st
Inbox capacity must be greater than 0.
Password cannot be empty.
```

*(The generated password is random and will differ each time.)*

## Planned Improvements

- Let the user enter employee names at runtime instead of in code
- Add unit tests for email and password generation
