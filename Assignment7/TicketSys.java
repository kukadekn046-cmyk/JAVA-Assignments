package Assignment7;
import java.util.*;


class TicketSystem {
    private int availableTickets = 100;
    private Set<Integer> bookedUsers = new HashSet<>();

   
    public synchronized void bookTicket(int userId) {
        if (availableTickets > 0 && !bookedUsers.contains(userId)) {
            availableTickets--;
            bookedUsers.add(userId);
            System.out.println("User " + userId + " booked ticket. Remaining: " + availableTickets);
        } else {
            System.out.println("User " + userId + " failed to book.");
        }
    }

    
    public synchronized void cancelTicket(int userId) {
        if (bookedUsers.contains(userId)) {
            availableTickets++;
            bookedUsers.remove(userId);
            System.out.println("User " + userId + " cancelled ticket. Remaining: " + availableTickets);
        } else {
            System.out.println("User " + userId + " has no booking to cancel.");
        }
    }
}


class BookingThread extends Thread {
    TicketSystem system;
    int userId;

    BookingThread(TicketSystem system, int userId) {
        this.system = system;
        this.userId = userId;
    }

    public void run() {
        system.bookTicket(userId);
    }
}


class CancelThread extends Thread {
    TicketSystem system;
    int userId;

    CancelThread(TicketSystem system, int userId) {
        this.system = system;
        this.userId = userId;
    }

    public void run() {
        system.cancelTicket(userId);
    }
}


public class TicketSys {
    public static void main(String[] args) {

        TicketSystem system = new TicketSystem();

        List<Thread> threads = new ArrayList<>();

        
        for (int i = 1; i <= 250; i++) {
            threads.add(new BookingThread(system, i));
        }

        // 15 users cancel tickets
        for (int i = 1; i <= 15; i++) {
            threads.add(new CancelThread(system, i));
        }

        // Start all threads
        for (Thread t : threads) {
            t.start();
        }

        // Wait for all threads to finish
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }

        System.out.println("\nAll operations completed.");
    }
}