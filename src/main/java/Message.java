/**
 * Message store sender name and message value
 * @author vitaliy
 * @project MessageGame
 * @since 5/17/17
 */
public class Message {

    private String senderName;
    private String value;

    public Message(String name, String message) {
        senderName = name;
        value = message;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getValue() {
        return value;
    }
}
