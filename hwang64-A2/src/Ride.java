import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ride {
    private String rideName;
    private int minHeightRequirement;
    private Employee operator;
    private Queue<Visitor> queue; // Waiting queue
    private List<Visitor> history; // Ride history
    private int maxRider; // Maximum riders per cycle
    private int numOfCycles; // Total cycles run

    // Constructor with 4 parameters
    public Ride(String rideName, int minHeightRequirement, Employee operator, int maxRider) {
        this.rideName = rideName;
        this.minHeightRequirement = minHeightRequirement;
        this.operator = operator;
        this.queue = new LinkedList<>();
        this.history = new LinkedList<>();
        this.maxRider = maxRider;
        this.numOfCycles = 0;
    }

    // Add a visitor to the waiting queue
    public void addVisitorToQueue(Visitor visitor) {
        queue.add(visitor);
        System.out.println("Visitor " + visitor.getName() + " added to the queue.");
    }

    // Remove a visitor from the queue
    public void removeVisitorFromQueue() {
        if (!queue.isEmpty()) {
            Visitor removedVisitor = queue.poll();
            System.out.println("Visitor " + removedVisitor.getName() + " removed from the queue.");
        } else {
            System.out.println("Queue is empty. No visitors to remove.");
        }
    }

    // Print all visitors in the queue
    public void printQueue() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Visitors in queue:");
            for (Visitor visitor : queue) {
                System.out.println("- " + visitor.getName());
            }
        }
    }

    // Add a visitor to the ride history
    public void addVisitorToHistory(Visitor visitor) {
        history.add(visitor);
        System.out.println("Visitor " + visitor.getName() + " added to ride history.");
    }

    // Print the ride history
    public void printRideHistory() {
        if (history.isEmpty()) {
            System.out.println("No visitors in ride history.");
        } else {
            System.out.println("Ride history:");
            for (Visitor visitor : history) {
                System.out.println("- " + visitor.getName());
            }
        }
    }

    // Check if a visitor is in the ride history
    public boolean checkVisitorFromHistory(Visitor visitor) {
        boolean exists = history.contains(visitor);
        System.out.println("Visitor " + visitor.getName() + (exists ? " is " : " is not ") + "in ride history.");
        return exists;
    }

    // Sort the ride history using a comparator
    public void sortHistory(Comparator<Visitor> comparator) {
        Collections.sort(history, comparator);
        System.out.println("Ride history sorted.");
    }

    // Run one cycle of the ride
    public void runOneCycle() {
        if (operator == null) {
            System.out.println("No operator assigned. Cannot run the ride.");
            return;
        }
        if (queue.isEmpty()) {
            System.out.println("Queue is empty. Cannot run the ride.");
            return;
        }

        int riders = Math.min(maxRider, queue.size());
        System.out.println("Running one cycle with " + riders + " visitors.");
        for (int i = 0; i < riders; i++) {
            Visitor visitor = queue.poll();
            history.add(visitor);
            System.out.println("Visitor " + visitor.getName() + " enjoyed the ride!");
        }
        numOfCycles++;
        System.out.println("Cycle completed. Total cycles run: " + numOfCycles);
    }

    // Export the ride history to a CSV file
    public void exportRideHistory(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Visitor visitor : history) {
                String line = visitor.getName() + "," + visitor.getAge() + "," + visitor.getGender() + "," +
                        visitor.getTicketType() + "," + visitor.isVip();
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Ride history exported to file: " + fileName);
        } catch (IOException e) {
            System.err.println("Error exporting ride history: " + e.getMessage());
        }
    }

    // Import the ride history from a CSV file
    public void importRideHistory(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 5) {
                    String name = fields[0];
                    int age = Integer.parseInt(fields[1]);
                    String gender = fields[2];
                    String ticketType = fields[3];
                    boolean isVip = Boolean.parseBoolean(fields[4]);

                    Visitor visitor = new Visitor(name, age, gender, ticketType, isVip);
                    history.add(visitor);
                }
            }
            System.out.println("Ride history imported successfully from file: " + fileName);
        } catch (IOException e) {
            System.err.println("Error importing ride history: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing number in file: " + e.getMessage());
        }
    }

    public void numberOfVisitors() {
    }
}
