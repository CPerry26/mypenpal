package com.mypenpal.mppbackend.exception;

/**
 * Top level exception for validation exceptions.
 *
 * @author Cody Perry (CPerry26)
 * @date 6/19/2022
 */
public class ValidationException extends Exception
{
    public ValidationException(String message)
    {
        super(message);
    }
}
