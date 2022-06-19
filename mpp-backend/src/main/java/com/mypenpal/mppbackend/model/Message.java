package com.mypenpal.mppbackend.model;

import java.sql.Timestamp;
import java.time.Instant;

/**
 * A message is a communication between two users or pals.
 * Realistically, in the future, it will be generated into some sort of template
 * representing a postcard.
 *
 * @author Cody Perry (CPerry26)
 * @date 6/18/2022
 */
public class Message
{
    // The pals participating in the message.
    private Pal pal;

    // The time the message was sent.
    private Timestamp messageDate;

    // The content of the message.
    private String content;

    public Message(Pal pal, String content)
    {
        this.pal = pal;
        this.content = content;
        this.messageDate = Timestamp.from(Instant.now());
    }

    /**
     * Get the pal a part of this message.
     *
     * @return The palship associated with this message.
     */
    protected Pal getPal()
    {
        return this.pal;
    }

    /**
     * Get the content associated with this message.
     *
     * @return The content of the message.
     */
    protected String getContent()
    {
        return this.content;
    }

    /**
     * Get the timestamp of when this message was sent.
     *
     * @return The registered timestamp.
     */
    protected Timestamp getMessageDate()
    {
        return this.messageDate;
    }
}
