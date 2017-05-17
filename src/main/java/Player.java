

/**
 * Player thread for play the game
 * @author vitaliy
 * @project MessageGame
 * @since 5/17/17
 */
public class Player implements Observable, Runnable {

    private String name;
    private Game game;
    private int countSendMessage;
    private boolean isReady;

    public Player(String name) {
        this.name = name;
    }

    /**
     * Register observer on player
     * @param game
     */
    public void registerObserver(Game game) {
        this.game = game;
    }

    /**
     * Notify observer that player is ready for start game
     */
    public void notifyObserver() {
        game.update();
    }

    /**
     * Send message to game for forward to another player and print message
     */
    public void sendMessage(){
        ++countSendMessage;
        Message message = new Message(name,"hello "+ countSendMessage);
        System.out.println(name+" send: "+message.getValue());
        game.forwardMessage(message);
    }

    public void run() {
        System.out.println(name+": ready");
        setReady(true);

        synchronized (game) {
            while (!game.isStartGame()) {
                try {
                    game.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            while (countSendMessage < 10) {
                sendMessage();
                try {
                    game.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.exit(0);
        }
    }

    /**
     * When player receives message it print to console
     * @param message
     */
    public void receiveMessage(Message message) {
        System.out.println(name+" receive: "+message.getValue());
    }

    public String getName() {
        return name;
    }

    public void setReady(boolean ready) {
        isReady = ready;
        if (isReady) {
            notifyObserver();
        }
    }
}

