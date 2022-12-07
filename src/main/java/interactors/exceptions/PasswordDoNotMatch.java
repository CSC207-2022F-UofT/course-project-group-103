package interactors.exceptions;

public class PasswordDoNotMatch extends Exception{
    public PasswordDoNotMatch(String message) {
        super(message);
    }
}
