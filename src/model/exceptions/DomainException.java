package model.exceptions;
/**
 * RuntimeException o compilador não obriga a tratar
 * Exception o compilador obriga a tratar
 */


public class DomainException extends Exception {

    public DomainException(String msg){
        super(msg);
    }
}
