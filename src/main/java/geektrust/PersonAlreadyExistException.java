package geektrust;

public class PersonAlreadyExistException extends FamilyException {
  public PersonAlreadyExistException(String message) {
    super(message);
  }
}
