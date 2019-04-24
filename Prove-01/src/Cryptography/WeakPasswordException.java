
package Cryptography;

/**
 * This is the exception class used when the password violates NSA policies
 *
 * @author Collin Blake
 * @version 1.0
 * @since 04-23-2019
 */
public class WeakPasswordException extends Exception {

  public WeakPasswordException(String message) {
    super(message);
  }

  public WeakPasswordException() {
    super("Error");
  }
}
