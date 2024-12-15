import java.util.List;

public interface RideInterface {
    void addVisitorToQueue(Visitor visitor); // Add visitors to the queue
    void removeVisitorFromQueue();          // Removes a visitor from the queue
    void printQueue();                      // Print a visitor in the queue
    void runOneCycle();                     // Run a play cycle
    void addVisitorToHistory(Visitor visitor); // Add visitors to history
    boolean checkVisitorFromHistory(Visitor visitor); // Check whether the visitor is in the history
    int numberOfVisitors();                 // Returns the number of visitors in the history
    void printRideHistory();                // Print visitors in history
}
