package com.mypenpal.mppbackend.model;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

/**
 * A pal represents a connection between two users who have agreed on both sides
 * to send messages. The relationship can be severed at any time by either
 * party.
 *
 * @author Cody Perry (CPerry26)
 * @date 6/18/2022
 */
public class Pal
{
    // The timestamp of when the palship was created. Really for reporting.
    private Timestamp palDate;

    // The timestamp of the last message sent.
    private Timestamp lastMessageDate;

    // The user on the left.
    private User leftUser;

    // The user on the right.
    private User rightUser;

    // The collection of messages sent between the users.
    private List<Message> messages;

    public Pal(User leftUser, User rightUser)
    {
        this.leftUser = leftUser;
        this.rightUser = rightUser;
        this.palDate = Timestamp.from(Instant.now());
    }

    /**
     * Get the date this palship was formed.
     *
     * @return The registered timestamp.
     */
    public Timestamp getPalDate()
    {
        return this.palDate;
    }

    /**
     * Get the date the last message was sent between pals (may be null).
     *
     * @return The registered timestamp.
     */
    public Timestamp getLastMessageDate()
    {
        return this.lastMessageDate;
    }

    /**
     * Check if the given user is part of this palship. This is a helper filter
     * function.
     *
     * @param palToCheck : The user to check.
     *
     * @return True if it's part of the palship, false otherwise.
     */
    protected boolean isPartOfPal(User palToCheck)
    {
        if (leftUser.equals(palToCheck) || rightUser.equals(palToCheck))
        {
            return true;
        }

        return false;
    }

    /**
     * Get the messages sent between these two users.
     *
     * @return The collection of messages.
     */
    protected List<Message> getMessages()
    {
        return this.messages;
    }
}
