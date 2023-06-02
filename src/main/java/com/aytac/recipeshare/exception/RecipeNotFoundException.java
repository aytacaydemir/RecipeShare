package com.aytac.recipeshare.exception;

public class RecipeNotFoundException extends RuntimeException {

    public RecipeNotFoundException(String message){
        super(message);
    }

}
