/**
 * Messenger forward message from one player to another player
 * @author vitaliy
 * @project MessageGame
 * @since 5/17/17
 */
public class Messenger {

    private Player player1;
    private Player player2;

    public Messenger(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    /**
     * Method check who sent the message and forward it to another player
     * @param message
     */
    public void forwardMessage(Message message) {
        if (message.getSenderName().equals(player1.getName())){
            player2.receiveMessage(message);
        } else {
            player1.receiveMessage(message);
        }
    }
}
