public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
        // Uncomment the parts you want to test
        assignment.partThree();
        assignment.partFourA();
        assignment.partFourB();
        assignment.partFive();
        assignment.partSix();
        assignment.partSeven();
    }

    public void partThree() {
        Employee operator = new Employee("jyy", 30, "Female", "Ride Operator", 45000);
        Ride rollerCoaster = new Ride("Roller Coaster", 120, operator, 3);

        Visitor v1 = new Visitor("fyn", 25, "Male", "Standard", false);
        Visitor v2 = new Visitor("mcs", 22, "Female", "VIP", true);
        Visitor v3 = new Visitor("hzl", 18, "Male", "Standard", false);
        Visitor v4 = new Visitor("lqh", 19, "Female", "VIP", true);
        Visitor v5 = new Visitor("jyy", 24, "Male", "Standard", false);

        rollerCoaster.addVisitorToQueue(v1);
        rollerCoaster.addVisitorToQueue(v2);
        rollerCoaster.addVisitorToQueue(v3);
        rollerCoaster.addVisitorToQueue(v4);
        rollerCoaster.addVisitorToQueue(v5);

        System.out.println("\nQueue after adding visitors:");
        rollerCoaster.printQueue();

        System.out.println("\nRemoving one visitor from the queue...");
        rollerCoaster.removeVisitorFromQueue();

        System.out.println("\nQueue after removing a visitor:");
        rollerCoaster.printQueue();
    }

    public void partFourA() {
        Employee operator = new Employee("jyy", 30, "Female", "Ride Operator", 45000);
        Ride rollerCoaster = new Ride("Roller Coaster", 120, operator, 3);

        Visitor v1 = new Visitor("fyn", 25, "Male", "Standard", false);
        Visitor v2 = new Visitor("mcs", 22, "Female", "VIP", true);
        Visitor v3 = new Visitor("hzl", 18, "Male", "Standard", false);
        Visitor v4 = new Visitor("lqh", 19, "Female", "VIP", true);
        Visitor v5 = new Visitor("jyy", 24, "Male", "Standard", false);

        rollerCoaster.addVisitorToHistory(v1);
        rollerCoaster.addVisitorToHistory(v2);
        rollerCoaster.addVisitorToHistory(v3);
        rollerCoaster.addVisitorToHistory(v4);
        rollerCoaster.addVisitorToHistory(v5);

        System.out.println("\nRide History:");
        rollerCoaster.printRideHistory();

        System.out.println("\nChecking Visitor:");
        rollerCoaster.checkVisitorFromHistory(v1);
        
    }

    public void partFourB() {
        Employee operator = new Employee("jyy", 30, "Female", "Ride Operator", 45000);
        Ride rollerCoaster = new Ride("Roller Coaster", 120, operator, 3);

        Visitor v1 = new Visitor("fyn", 25, "Male", "Standard", false);
        Visitor v2 = new Visitor("mcs", 22, "Female", "VIP", true);
        Visitor v3 = new Visitor("hzl", 18, "Male", "Standard", false);
        Visitor v4 = new Visitor("lqh", 19, "Female", "VIP", true);
        Visitor v5 = new Visitor("jyy", 24, "Male", "Standard", false);

        rollerCoaster.addVisitorToHistory(v1);
        rollerCoaster.addVisitorToHistory(v2);
        rollerCoaster.addVisitorToHistory(v3);
        rollerCoaster.addVisitorToHistory(v4);
        rollerCoaster.addVisitorToHistory(v5);

        System.out.println("\nRide History Before Sorting:");
        rollerCoaster.printRideHistory();

        rollerCoaster.sortHistory(new VisitorComparator());

        System.out.println("\nRide History After Sorting:");
        rollerCoaster.printRideHistory();
    }

    public void partFive() {
        Employee operator = new Employee("jyy", 30, "Female", "Ride Operator", 45000);
        Ride rollerCoaster = new Ride("Roller Coaster", 120, operator, 3);

        Visitor v1 = new Visitor("fyn", 25, "Male", "Standard", false);
        Visitor v2 = new Visitor("mcs", 22, "Female", "VIP", true);
        Visitor v3 = new Visitor("hzl", 18, "Male", "Standard", false);
        Visitor v4 = new Visitor("lqh", 19, "Female", "VIP", true);
        Visitor v5 = new Visitor("jyy", 24, "Male", "Standard", false);
        Visitor v6 = new Visitor("lqh", 21, "Female", "VIP", true);

        rollerCoaster.addVisitorToQueue(v1);
        rollerCoaster.addVisitorToQueue(v2);
        rollerCoaster.addVisitorToQueue(v3);
        rollerCoaster.addVisitorToQueue(v4);
        rollerCoaster.addVisitorToQueue(v5);
        rollerCoaster.addVisitorToQueue(v6);

        System.out.println("\nQueue before running the cycle:");
        rollerCoaster.printQueue();

        System.out.println("\nRunning one cycle...");
        rollerCoaster.runOneCycle();

        System.out.println("\nQueue after running the cycle:");
        rollerCoaster.printQueue();

        System.out.println("\nRide History:");
        rollerCoaster.printRideHistory();
    }

    public void partSix() {
        Employee operator = new Employee("jyy", 30, "Female", "Ride Operator", 45000);
        Ride rollerCoaster = new Ride("Roller Coaster", 120, operator, 3);

        Visitor v1 = new Visitor("fyn", 25, "Male", "Standard", false);
        Visitor v2 = new Visitor("mcs", 22, "Female", "VIP", true);
        Visitor v3 = new Visitor("hzl", 18, "Male", "Standard", false);

        rollerCoaster.addVisitorToHistory(v1);
        rollerCoaster.addVisitorToHistory(v2);
        rollerCoaster.addVisitorToHistory(v3);

        String fileName = "ride_history.csv";
        rollerCoaster.exportRideHistory(fileName);

        // 打印单独的确认消息
        System.out.println("Ride history exported to file: " + fileName);
    }

    public void partSeven() {
        String fileName = "ride_history.csv";

        Employee operator = new Employee("jyy", 30, "Female", "Ride Operator", 45000);
        Ride rollerCoaster = new Ride("Roller Coaster", 120, operator, 3);

        rollerCoaster.importRideHistory(fileName);

        System.out.println("\nImported Ride History:");
        rollerCoaster.printRideHistory();

    }
}
