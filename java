import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Ticket {
    private String issue;
    private String description;
    private String status;

    public Ticket(String issue, String description) {
        this.issue = issue;
        this.description = description;
        this.status = "Open";
    }

    public String getIssue() {
        return issue;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

class HelpDesk {
    private List<Ticket> tickets;

    public HelpDesk() {
        this.tickets = new ArrayList<>();
    }

    public void createTicket(String issue, String description) {
        Ticket ticket = new Ticket(issue, description);
        tickets.add(ticket);
        System.out.println("Ticket created successfully!");
    }

    public void displayAllTickets() {
        if (tickets.isEmpty()) {
            System.out.println("No tickets found.");
            return;
        }

        System.out.println("All Tickets:");
        for (int i = 0; i < tickets.size(); i++) {
            Ticket ticket = tickets.get(i);
            System.out.println("Ticket " + (i + 1) + ":");
            System.out.println("Issue: " + ticket.getIssue());
            System.out.println("Description: " + ticket.getDescription());
            System.out.println("Status: " + ticket.getStatus());
            System.out.println();
        }
    }

    public void updateTicketStatus(int ticketIndex, String status) {
        if (ticketIndex >= 0 && ticketIndex < tickets.size()) {
            Ticket ticket = tickets.get(ticketIndex);
            ticket.setStatus(status);
            System.out.println("Ticket status updated successfully!");
        } else {
            System.out.println("Invalid ticket index.");
        }
    }
}

public class HelpDeskManagementSystem {
    public static void main(String[] args) {
        HelpDesk helpDesk = new HelpDesk();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("HelpDesk Management System");
            System.out.println("1. Create Ticket");
            System.out.println("2. Display All Tickets");
            System.out.println("3. Update Ticket Status");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter issue: ");
                    String issue = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    helpDesk.createTicket(issue, description);
                    break;
                case 2:
                    helpDesk.displayAllTickets();
                    break;
                case 3:
                    helpDesk.displayAllTickets();
                    System.out.print("Enter ticket index to update status: ");
                    int ticketIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter new status: ");
                    String status = scanner.nextLine();
                    helpDesk.updateTicketStatus(ticketIndex - 1, status);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println();
        } while (choice != 0);

        scanner.close();
    }
}
