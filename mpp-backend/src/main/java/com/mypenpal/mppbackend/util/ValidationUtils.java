package com.mypenpal.mppbackend.util;

import com.mypenpal.mppbackend.exception.InvalidNameException;
import com.mypenpal.mppbackend.exception.ValidationException;
import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;

/**
 * Utility functions for doing validation.
 *
 * @author Cody Perry (CPerry26)
 * @date 6/19/2022
 */
public class ValidationUtils
{
    /**
     * Validate the user's information. This gets called when trying to create a new user.
     *
     * @param username : The username to validate.
     * @param password : The password to validate.
     * @param email : The email to validate.
     * @param displayName : The display name to validate.
     * @param birthday : The birthday to validate.
     */
    public static void validateUserInfo(String username, String password, String email,
                                        String displayName, Timestamp birthday)
    throws ValidationException
    {
        validateName(username);
        validateName(displayName);
        validatePassword(password);
        validateEmail(email);
        validateBirthday(birthday);
    }

    /**
     * Validate either the username or display name. Same rules apply.
     *
     * @param nameToValidate : The name to validate.
     */
    public static void validateName(String nameToValidate) throws InvalidNameException
    {
        // Only validate if the name is non empty, during creation the display
        // name might be null.
        if (StringUtils.isNotEmpty(nameToValidate))
        {

        }
        else
        {
            throw new InvalidNameException("Invalid name");
        }
    }

    /**
     * Validate the password, used during creation and password change requests.
     *
     * @param password : The new password to validate.
     */
    public static void validatePassword(String password) throws ValidationException
    {
        throw new ValidationException("Invalid password");
    }

    /**
     * Validate the email, used during creation and email change requests.
     *
     * @param email : The new email to validate.
     */
    public static void validateEmail(String email) throws ValidationException
    {
        throw new ValidationException("Email invalid");
    }

    /**
     * Validate the birthday, only used during creation.
     *
     * @param birthday : The birthday to validate.
     */
    private static void validateBirthday(Timestamp birthday) throws ValidationException
    {
        throw new ValidationException("Birthday invalid");
    }
}
