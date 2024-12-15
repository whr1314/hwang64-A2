public class Visitor extends Person {
    private String ticketType;
    private boolean isVip;

    // Default constructor
    public Visitor() {
        super();
        this.ticketType = "Standard";
        this.isVip = false;
    }

    // Parameterized constructor
    public Visitor(String name, int age, String gender, String ticketType, boolean isVip) {
        super(name, age, gender);
        this.ticketType = ticketType;
        this.isVip = isVip;
    }

    // Getters and Setters
    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }
}
