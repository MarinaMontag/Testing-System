package ua.knu.montag.spring.controllers.exceptions;

public class ServerException extends Exception{
    public ServerException(String message){
        super(message);
    }

    public ServerException(){
        super();
    }
}
