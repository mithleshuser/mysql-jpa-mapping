package com.incture.mysqljpamapping.exception;

public class CartException extends  Exception{
    private static final long serialVersionUID = 1L;

    public CartException(){
        super();
    }
    public CartException(String errorMessage){
        super(errorMessage);
    }

    public CartException(String message, Throwable cause){
        super(message,cause);
    }



}
