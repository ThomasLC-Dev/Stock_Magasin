package fr.thomas.stock.exception;

public class NotEnoughQuantityException extends RuntimeException {
    public NotEnoughQuantityException(String message){
        super(message);
    }
}
