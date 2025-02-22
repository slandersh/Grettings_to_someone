import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PesawatTiket {
    
    static class SeatManager {
        private Set<String> availableSeats;
        
        public SeatManager() {
            availableSeats = new HashSet<>();
            for(int i=1; i<=50; i++) {
                availableSeats.add("A" + i);
            }
        }
        
        public void showAvailableSeats() {
            System.out.println("\nAvailable Seats:");
            for(String seat : availableSeats) {
                System.out.print(seat + " ");
            }
            System.out.println();
        }
        
        public boolean bookSeat(String seatNumber) {
            if(availableSeats.contains(seatNumber)) {
                availableSeats.remove(seatNumber);
                return true;
            }
            return false;
        }
    }
    
    static class Ticket {
        private String nomerPenerbangan;
        private double Harga;
        private String NamaPenumpang;
        private String seatNumber;

        public Ticket(String nomerPenerbangan, double Harga, String NamaPenumpang, String seatNumber) {
            this.nomerPenerbangan = nomerPenerbangan;
            this.Harga = Harga;
            this.NamaPenumpang = NamaPenumpang;
            this.seatNumber = seatNumber;
        }

        public void displayTicket() {
            System.out.println("\n--- Ticket Details ---");
            System.out.println("No penerbangan: " + nomerPenerbangan);
            System.out.println("Nama Penumpang: " + NamaPenumpang);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Harga: Rp." + Harga);
        }
    }

    
    static class TicketBuyer {
        private String buyerName;
        private Ticket purchasedTicket;

        public TicketBuyer(String buyerName) {
            this.buyerName = buyerName;
        }

        public void purchaseTicket(Ticket ticket) {
            this.purchasedTicket = ticket;
            System.out.println("\n" + buyerName + " Sukses membeli Tiket");
        }

        public void showTicket() {
            if (purchasedTicket != null) {
                purchasedTicket.displayTicket();
            } else {
                System.out.println("\nTiket tidak ditemukan.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Selamat Datang di Aplikasi Pemesanan Tiket Pesawat");
        System.out.print("Masukkan nama Anda: ");
        String buyerName = scanner.nextLine();
        
        TicketBuyer buyer = new TicketBuyer(buyerName);
        
        while(true) {
            SeatManager seatManager = new SeatManager();

        
        System.out.println("\nPilih Penerbangan:");
        System.out.println("1. GA123 - Jakarta to Bali - Rp.250.000");
        System.out.println("2. GA456 - Jakarta to Singapore - RP.300.000");
        System.out.print("pilih (1/2): ");
        int flightChoice = scanner.nextInt();
        scanner.nextLine(); 
        
        String nomerPenerbangan;
        double Harga;
        
        if (flightChoice == 1) {
            nomerPenerbangan = "GA123";
            Harga = 250000;
        } else {
            nomerPenerbangan = "GA456";
            Harga = 350000;
        }
        
        System.out.print("Enter Nama Penumpang: ");
        String NamaPenumpang = scanner.nextLine();
        
        seatManager.showAvailableSeats();
        System.out.print("Enter seat number: ");
        String seatNumber = scanner.nextLine();
        
        while(!seatManager.bookSeat(seatNumber)) {
            System.out.println("kursi ini sudah terisi. Pilih kursi lain.");
            seatManager.showAvailableSeats();
            System.out.print("Enter seat number: ");
            seatNumber = scanner.nextLine();
        }
        
        Ticket ticket = new Ticket(nomerPenerbangan, Harga, NamaPenumpang, seatNumber);

       
        buyer.purchaseTicket(ticket);

        System.out.println("\nTicket Details:");
        buyer.showTicket();
        
            System.out.print("\nApakah Anda ingin membeli tiket lagi? (ya/tidak): ");
            String response = scanner.nextLine();
            if(response.equalsIgnoreCase("tidak")) {
                System.out.println("\nTerima kasih telah menggunakan aplikasi pemesanan tiket!");
                break;
            }
        }
        scanner.close();
    }


}
