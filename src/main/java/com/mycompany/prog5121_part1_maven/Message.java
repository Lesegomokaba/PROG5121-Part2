package com.mycompany.prog5121_part1_maven;

public class Message {

    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String messageHash;

    private static int totalMessages = 0;

public Message() {
}

    public boolean checkMessageID() {
        return messageID != null
                && messageID.matches("[0-9]{1,10}");
    }

    public boolean checkRecipientCell() {
        return recipient != null
                && recipient.matches("^\\+27[0-9]{9}$");
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public void setMessageNumber(int messageNumber) {
        this.messageNumber = messageNumber;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public boolean checkMessageText() {
        return messageText != null
                && !messageText.trim().isEmpty()
                && messageText.length() <= 250;
    }

    
public String createMessageHash() {
    if (messageID == null || messageText == null) {
        return "";
    }

    String trimmedText = messageText.trim();

    if (trimmedText.isEmpty()) {
        return "";
    }

    String[] words = trimmedText.split("\\s+");

    String firstTwoDigits = messageID.length() >= 2
        ? messageID.substring(0, 2)
        : "0" + messageID;

    String firstWord = words[0].replaceAll("[^a-zA-Z0-9]", "");
    String lastWord = words[words.length - 1]
            .replaceAll("[^a-zA-Z0-9]", "");

    messageHash = (firstTwoDigits + ":" + messageNumber + ":"
            + firstWord + lastWord).toUpperCase();

    return messageHash;
}

    
    public void generateMessageID() {
    java.util.concurrent.ThreadLocalRandom random =
            java.util.concurrent.ThreadLocalRandom.current();

    long id = random.nextLong(1_000_000_000L, 10_000_000_000L);

    messageID = String.valueOf(id);
}
    public String getMessageID() {
    return messageID;
}

public int getMessageNumber() {
    return messageNumber;
}

public String getRecipient() {
    return recipient;
}

public String getMessageText() {
    return messageText;
}

public String getMessageHash() {
    return messageHash;
}
public String SentMessage() {
    return "Message successfully sent";
}
public String DisregardMessage() {
    return "Press 0 to delete the message";
}

public String StoreMessage() {
    return "Message successfully stored";
}
public static int returnTotalMessagess() {
    return totalMessages;
}

public void incrementTotalMessages() {
    totalMessages++;
}
    
}