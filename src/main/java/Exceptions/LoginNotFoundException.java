package exceptions;

public class LoginNotFoundException extends Exception{

    public LoginNotFoundException(String message){
        super(message);
    }
}
