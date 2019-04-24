package Cryptography;

// Imports
import java.util.Scanner;

/**
 * The Test class is designed for testing the interactions between
 * the {@link User} and {@link NSALoginController} classes.
 *
 * @author Collin Blake
 * @version 1.0
 * @since 04-23-2019
 */
public class Test {

  // Variables
  private static Scanner scanner = new Scanner(System.in);

  // Main Function
  public static void main(String args[]) {
    // Get User Password
    System.out.print("Enter Password: ");
    String password = scanner.next();
    User user = new User(password);
    password = null;

    // Before Salt & Hash
    System.out.println("\nBefore");
    printUserValues(user);

    // While loop to get password that meets the standards
    while (true) {
      try {
        NSALoginController.hashUserPassword(user);
        break;
      } catch (WeakPasswordException e) {
        //Output error and get new password
        System.out.println("\n" + e.getMessage());
        System.out.print("Enter New Password: ");
        password = scanner.next();
        user.setPassword(password);
        password = null;
      } catch (Exception e) {
        e.printStackTrace();
        break;
      }
    }

    // After Salt & Hash
    System.out.println("\nAfter");
    printUserValues(user);

    // Verify Password with User
    System.out.print("\nEnter Password For Verification: ");
    password = scanner.next();

    // Verify Password
    user.setPassword(password);
    try {
      if (NSALoginController.verifyPassword(user)) {
        System.out.println("Password Verification Successful!");
      } else {
        System.out.println("Password Verification Failed!");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // Output User information
  public static void printUserValues(User user) {
    System.out.println("Password: " + user.getPassword());
    System.out.println("Salt: " + user.getSalt());
    System.out.println("Hash: " + user.getHashedPassword());
  }
}
