/**
 * @author vitaliy
 * @project MessageGame
 * @since 5/17/17
 */
public class Main {

    public static void main(String[] args) {

        Player player1 = new Player("player1");
        Player player2 = new Player("player2");

        Messenger messenger = new Messenger(player1, player2);
        Game game = new Game(messenger);

        player1.registerObserver(game);
        player2.registerObserver(game);

        Thread t1 = new Thread(player1);
        Thread t2 = new Thread(player2);

        t1.start();
        t2.start();

    }
}
