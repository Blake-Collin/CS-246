package Cryptography;

/**
 * This is the exception class used when the password violates NSA policies
 *
 * @author Collin Blake
 * @since 04-23-2019
 */
public class WeakPasswordException extends Exception {

  /**
   * Base exception for error messages for Weak Passwords
   *
   * @param message
   */
  public WeakPasswordException(String message) {
    super(message);
  }

  // Default if message is forgotten
  public WeakPasswordException() {
    super("Password Error");
  }
}
