/**
 * @author vitaliy
 * @version 1.0
 * @since 2/26/17
 */
public interface Observable {
    void registerObserver(Game game);
    void notifyObserver();
}
