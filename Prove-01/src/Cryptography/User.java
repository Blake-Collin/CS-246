package Cryptography;

public class User {

  // variables
  private String password;
  private String salt;
  private String hash;

  public User(String pPassword) {
    password = pPassword;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String pPassword) {
    password = pPassword;
  }

  public String getSalt() {
    return salt;
  }

  public void setSalt(String pSalt) {
    salt = pSalt;
  }

  public String getHashedPassword() {
    return hash;
  }

  public String setHashedPassword(String pHash) {
    return hash;
  }
}
