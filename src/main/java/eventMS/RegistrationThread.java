package eventMS;

public class RegistrationThread extends Thread {
    private EventService service;
    private int userId, eventId;

    public RegistrationThread(EventService service, int userId, int eventId) {
        this.service = service;
        this.userId = userId;
        this.eventId = eventId;
    }

    public void run() {
        try {
            service.assignUserToEvent(userId, eventId);
            System.out.println(" User assigned to event.");
        } catch (Exception e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }
}