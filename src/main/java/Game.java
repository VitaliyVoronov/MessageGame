
/**
 * Game observe by players and start the game when players are ready
 * and forward message from player to messenger
 * @author vitaliy
 * @project MessageGame
 * @since 5/17/17
 */
public class Game implements Observer {

    private int numPlayers;
    private boolean isStartGame;
    private Messenger messenger;

    public Game(Messenger messenger) {
        this.messenger = messenger;
    }

    /**
     * Count how many players ready for game and notify all players threads when game is start
     */
    public synchronized void update() {
        ++numPlayers;
        if (numPlayers > 1){
            isStartGame = true;
            notifyAll();
        }

    }

    /**
     * Forward message from player to messenger
     * @param message
     */
    public synchronized void forwardMessage(Message message){
        messenger.forwardMessage(message);
        notifyAll();
    }

    public synchronized boolean isStartGame(){
        return isStartGame;
    }
}
