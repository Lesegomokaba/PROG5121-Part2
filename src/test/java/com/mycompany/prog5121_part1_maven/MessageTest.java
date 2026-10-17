
package com.mycompany.prog5121_part1_maven;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MessageTest {

    @Test
    public void testCreateMessageHash() {
        Message message = new Message();

        message.setMessageID("0012345678");
        message.setMessageNumber(0);
        message.setMessageText(
                "Hi Mike, can you join us for dinner tonight?");

        String expectedHash = "00:0:HITONIGHT";

        assertEquals(expectedHash, message.createMessageHash());
    }
    
    @Test
    public void testMessageLength250Characters() {
        Message message = new Message();

        message.setMessageText("A".repeat(250));

        assertTrue(message.checkMessageText());
    }

    @Test
    public void testMessageLength251Characters() {
        Message message = new Message();

        message.setMessageText("A".repeat(251));

        assertFalse(message.checkMessageText());
    }

    @Test
    public void testValidRecipientCell() {
        Message message = new Message();

        message.setRecipient("+27718693002");

        assertTrue(message.checkRecipientCell());
    }

    @Test
    public void testInvalidRecipientCell() {
        Message message = new Message();

        message.setRecipient("0718693002");

        assertFalse(message.checkRecipientCell());
    }

@Test
public void testMessageIDLength() {
    Message message = new Message();
    message.generateMessageID();
    assertEquals(10, message.getMessageID().length());
}

@Test
public void testValidMessageID() {
    Message message = new Message();
    message.setMessageID("1234567890");

    assertTrue(message.checkMessageID());
}

@Test
public void testInvalidMessageID() {
    Message message = new Message();
    message.setMessageID("12345ABCDE");

    assertFalse(message.checkMessageID());
}


@Test
public void testEmptyMessageText() {
    Message message = new Message();
    message.setMessageText("");

    assertFalse(message.checkMessageText());
}


@Test
public void testWhitespaceOnlyMessageText() {
    Message message = new Message();
    message.setMessageText("   ");

    assertFalse(message.checkMessageText());
}

@Test
public void testMessageTextAt250Characters() {
    Message message = new Message();
    message.setMessageText("a".repeat(250));

    assertTrue(message.checkMessageText());
}

@Test
public void testMessageTextAt251Characters() {
    Message message = new Message();
    message.setMessageText("a".repeat(251));

    assertFalse(message.checkMessageText());
}

@Test
public void testSentMessage() {
    Message message = new Message();

    assertEquals("Message successfully sent", message.SentMessage());
}

@Test
public void testNullMessageText() {
    Message message = new Message();
    message.setMessageText(null);

    assertFalse(message.checkMessageText());
}
@Test
public void testNullMessageID() {
    Message message = new Message();
    message.setMessageID(null);

    assertFalse(message.checkMessageID());
}
}
