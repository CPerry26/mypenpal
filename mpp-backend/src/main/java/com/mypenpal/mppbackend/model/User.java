package com.mypenpal.mppbackend.model;

import com.mypenpal.mppbackend.exception.ValidationException;
import com.mypenpal.mppbackend.util.ValidationUtils;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * A user represents an account in MyPenPal. It has basic account information,
 * as well as information like it's current pals.
 *
 * @author Cody Perry (CPerry26)
 * @date 6/18/2022s
 */
public class User
{
    // The user's username.
    private String username;

    // The user's salted password (no plain text).
    private String password;

    // The user's email address (never shared).
    private String email;

    // The user's display name, by default it will be the username.
    private String displayName;

    // The user's birthday (for now older than 18).
    private Timestamp birthday;

    // A list of all the user's current pals.
    private List<Pal> pals;

    public User(String username, String password, String email, String displayName,
                Timestamp birthday) throws ValidationException
    {
        // Validate the user info, then set the values.
        ValidationUtils.validateUserInfo(username, password, email, displayName, birthday);

        this.username = username;
        this.password = password; // TODO: This is probably plain text and needs salting
        this.email = email;

        if (displayName == null)
        {
            this.displayName = username;
        }
        else
        {
            this.displayName = displayName;
        }

        this.birthday = birthday;
    }

    public User(String username, String password, String email, Timestamp birthday) throws ValidationException
    {
        this(username, password, email, null, birthday);
    }

    /**
     * Add a new palship if it doesn't exist.
     *
     * @param newPalUser : The new pal user.
     */
    protected void addNewPal(User newPalUser)
    {
        if (this.pals == null)
        {
            this.pals = new ArrayList<>();
        }

        boolean palExists = this.pals.stream().anyMatch(pal -> pal.isPartOfPal(newPalUser));

        if (!palExists)
        {
            this.pals.add(new Pal(this, newPalUser));
        }
    }

    /**
     * Change the user's password.
     *
     * @param newPassword : The user's new password.
     */
    protected void changePassword(String newPassword) throws ValidationException
    {
        // TODO: salt and save
        ValidationUtils.validatePassword(newPassword);
        this.password = newPassword;
    }

    /**
     * Change the user's display name.
     *
     * @param newDisplayName : The new display name.
     */
    protected void changeDisplayName(String newDisplayName) throws ValidationException
    {
        ValidationUtils.validateName(newDisplayName);
        this.displayName = newDisplayName;
    }

    /**
     * Change the user's email.
     *
     * @param email : The user's new email.
     */
    protected void changeEmail(String email) throws ValidationException
    {
        ValidationUtils.validateEmail(email);
        this.email = email;
    }

    /**
     * Get the user's birthday.
     *
     * @return The user's birthday.
     */
    protected Timestamp getBirthday()
    {
        return this.birthday;
    }
}
