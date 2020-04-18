package geektrust;

public class FamilyException extends RuntimeException {
  public FamilyException(String message) {
    super(message);
  }

  public FamilyException(String message, Throwable cause) {
    super(message, cause);
  }
}
