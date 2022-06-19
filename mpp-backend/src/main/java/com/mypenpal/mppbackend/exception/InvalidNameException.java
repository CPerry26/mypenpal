package com.mypenpal.mppbackend.exception;

/**
 * Exception for invalid names (too long, inappropriate, etc.).
 *
 * @author Cody Perry (CPerry26)
 * @date 6/19/2022
 */
public class InvalidNameException extends ValidationException
{
    public InvalidNameException(String message)
    {
        super(message);
    }
}
