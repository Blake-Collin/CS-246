package Cryptography;

// Imports
import java.util.Scanner;

/**
 * The Test class is designed for testing the interactions between the {@link User} and {@link
 * NSALoginController} classes.
 *
 * @author Collin Blake
 * @since 04-23-2019
 */
public class Test {

  // Variables
  private static Scanner scanner = new Scanner(System.in);

  // Main Function

  /**
   * Main Test Function
   *
   * @author Collin Blake
   * @param args
   */
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
        // Output error and get new password
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

    //Loop for verification
    while (true) {
      // Verify Password with User
      System.out.print("\nEnter Password For Verification: ");
      password = scanner.next();

      // Verify Password
      user.setPassword(password);
      try {
        if (NSALoginController.verifyPassword(user)) {
          System.out.println("Password Verification Successful!");
          break;
        } else {
          System.out.println("Password Verification Failed!\nPlease try again!");
        }
      } catch (Exception e) {
        e.printStackTrace();
        break;
      }
    }
  }

  // Output User information

  /**
   * Output the {@link User} information to remove repeating code
   *
   * @param user
   */
  public static void printUserValues(User user) {
    System.out.println("Password: " + user.getPassword());
    System.out.println("Salt: " + user.getSalt());
    System.out.println("Hash: " + user.getHashedPassword());
  }
}
