package utilities;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Message {

    private String sender;
    private String recipient;
    private String content;
    private String timestamp;

    public Message(String sender, String recipient, String content) {

        if (!DataValidator.isNotEmpty(sender)) {
            throw new IllegalArgumentException("Sender cannot be empty");
        }

        if (!DataValidator.isNotEmpty(recipient)) {
            throw new IllegalArgumentException("Recipient cannot be empty");
        }

        if (!DataValidator.isNotEmpty(content)) {
            throw new IllegalArgumentException("Message content cannot be empty");
        }

        this.sender = sender;
        this.recipient = recipient;
        this.content = content;

        try {
            this.timestamp = LocalTime.now()
                    .format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        } catch (Exception e) {
            this.timestamp = "UNKNOWN TIME";
        }
    }

    public void displayMessage() {

        try {

            System.out.println("[" + timestamp + "] From: " + sender + " To: " + recipient);
            System.out.println("Message: " + content);

        } catch (Exception e) {

            System.out.println("Error displaying message: " + e.getMessage());

        }
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {

        if (!DataValidator.isNotEmpty(sender)) {
            throw new IllegalArgumentException("Sender cannot be empty");
        }

        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {

        if (!DataValidator.isNotEmpty(recipient)) {
            throw new IllegalArgumentException("Recipient cannot be empty");
        }

        this.recipient = recipient;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {

        if (!DataValidator.isNotEmpty(content)) {
            throw new IllegalArgumentException("Message cannot be empty");
        }

        this.content = content;
    }
}