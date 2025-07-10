package eventMS;

import java.util.*;

public class EventApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EventService service = new EventService();

        while (true) {
            System.out.println("\n==== Event Management Menu ====");
            System.out.println("1. Create Event");
            System.out.println("2. Register User");
            System.out.println("3. Assign User to Event");
            System.out.println("4. View All Events");
            System.out.println("5. View Event Participants");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        sc.nextLine();
                        System.out.print("Event Name: ");
                        String name = sc.nextLine();
                        System.out.print("Date (YYYY-MM-DD): ");
                        String date = sc.next();
                        sc.nextLine();
                        System.out.print("Location: ");
                        String location = sc.nextLine();
                        service.createEvent(name, date, location);
                        break;

                    case 2:
                        sc.nextLine();
                        System.out.print("User Name: ");
                        String uname = sc.nextLine();
                        System.out.print("Email: ");
                        String email = sc.next();
                        service.registerUser(uname, email);
                        break;

                    case 3:
                        System.out.print("User ID: ");
                        int uid = sc.nextInt();
                        System.out.print("Event ID: ");
                        int eid = sc.nextInt();
                        RegistrationThread rt = new RegistrationThread(service, uid, eid);
                        rt.start();
                        rt.join(); // Wait for completion
                        break;

                    case 4:
                        service.viewEvents();
                        break;

                    case 5:
                        System.out.print("Event ID: ");
                        int eid2 = sc.nextInt();
                        service.viewParticipants(eid2);
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println(" Error: " + e.getMessage());
            }
        }
    }
}