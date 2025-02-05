import java.util.HashMap;

public class Reservation {

    //private String reservationNumber;
    private MovieScreenig movieScreenig;
    private Client client;
    private double valueToPay;
    private HashMap<String, Object> reservationSeatsDetails;
    private HashMap<String, String[]> chossenSeatsPerRow;

    Reservation(MovieScreenig movieScreenig) {
        this.reservationSeatsDetails = new HashMap<>();
        this.chossenSeatsPerRow = new HashMap<>();
        this.movieScreenig = movieScreenig;
    }

    protected void setClient(String clientEmail) {
        this.client = new Client(clientEmail);
        this.client.setClientName(" --- ");
    }

    protected void setClient(Client client) {
        this.client = client;
    }

    protected Client getClient() {
        return this.client;
    }

    protected double getValueToPay() {
        return this.valueToPay;
    }

    protected MovieScreenig getMovieScreenig() {
        return this.movieScreenig;
    }

    public HashMap<String, Object> getReservationSeatsDetails() {
        return this.reservationSeatsDetails;
    }

    protected void chooseSeatsPerRow(String rowNumber, String seatsNumber) {
        String seatsNo1 = seatsNumber.replace(" ", "");
        String[] seatsNo2 = seatsNo1.split(",");
        this.chossenSeatsPerRow.put(rowNumber, seatsNo2);
    }

    protected void confirmReservation() {

        this.valueToPay = 0;

        for (String rowNumber : this.chossenSeatsPerRow.keySet()) {
            String[] seatsNo2 = this.chossenSeatsPerRow.get(rowNumber);

            HashMap<String, Object> finalData = movieScreenig.getCinemaRoom().getRowSeatsData(rowNumber);
            HashMap<String, Object> reservationSeatDetailsPerRow = new HashMap<>();

            for (String key1 : finalData.keySet()) {

                for (int s = 0; s < seatsNo2.length; s++) {

                    if (key1.equals(seatsNo2[s])) {
                        HashMap<String, Object> temp = (HashMap) finalData.get(key1);

                        if ((int) temp.get("seatKindOfReserved") == movieScreenig.getCinemaRoom().getStatusSeatIsNotReserved()) {
                            temp.replace("seatKindOfReserved", movieScreenig.getCinemaRoom().getStatusSeatIsTemporarilyReserved());
                            this.valueToPay = this.valueToPay + (double) temp.get("price");
                            reservationSeatDetailsPerRow.put(key1, temp);
                            this.reservationSeatsDetails.put(rowNumber, reservationSeatDetailsPerRow);
                        } else {
                            System.out.println("Seat " + key1 + " in row " + rowNumber + " is reserved.");
                        }
                    }
                }
            }
        }
    }

    protected void printReservationDetails() {
        System.out.println("------------------------------------------------------");
        System.out.println("   RESERVATION DETAILS   ");
        System.out.println();
        System.out.println("Cinema: " + movieScreenig.getCinemaRoom().getCinema().getCinemaName());
        System.out.println("Address: " + movieScreenig.getCinemaRoom().getCinema().gerCinemaAddress());
        System.out.println();
        System.out.println("movie title: " + movieScreenig.getMovieData().getMovieTitle());
        System.out.println("date: " + movieScreenig.getDate() + ", " + movieScreenig.getTime());
        System.out.println();
        System.out.println("room name: " + movieScreenig.getCinemaRoom().getRoomName().toUpperCase());
        System.out.println();

        for (String rowNumber : reservationSeatsDetails.keySet()) {
            System.out.println("ROW: " + rowNumber + ", ");
            HashMap<String, Object> currentSeatNumber = (HashMap) reservationSeatsDetails.get(rowNumber);

            for (String seatNumber : currentSeatNumber.keySet()) {
                HashMap<String, Object> seatDetails = (HashMap) currentSeatNumber.get(seatNumber);
                System.out.print("seat: " + seatNumber + ", ");
                System.out.print(seatDetails.get("seatType") + ", ");
                System.out.print(seatDetails.get("price") + ", ");
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("client name: " + this.client.getClientName());
        System.out.println("email: " + this.client.getClientEmail());
        System.out.println();
        System.out.println("to pay: " + this.valueToPay);

        System.out.println("------------------------------------------------------");
        System.out.println();
    }
}

