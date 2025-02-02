import java.util.HashMap;

public class PurchaseDocument{

    private Reservation reservation;
    private int paymentStatus;
    private int reservationNotPaid = 0;
    private int reservationPaid = 1;
    private int refundReservationPayment = 2;
    private HashMap<String, Object> finalReservationSeatsDetails;
    private int seatIsNotReserved;
    private int seatIsReserved;
    private int seatIsTemporarilyReserved;


    PurchaseDocument(Reservation reservation){
        this.paymentStatus = reservationNotPaid;
        this.reservation = reservation;
        this.finalReservationSeatsDetails = reservation.getReservationSeatsDetails();
    }

    protected void payForReservation(boolean doYouWantToPayForReservation, boolean isPaymentForReservationWasSuccessful){

        if(doYouWantToPayForReservation == true){

            if(isPaymentForReservationWasSuccessful == true){

                setStatusSeatIsReserved();
                this.paymentStatus = reservationPaid;
            }
            else {
                System.out.println();
                System.out.println("Payment for reservation end with error. Please try one more time.");
            }
        }
        else {
            setStatusSeatIsNotReserved();
        }
    }

    protected void sentEmailToClient() {
        System.out.println();
        System.out.println("Purchase document was sent to email: " + this.reservation.getClient().getClientEmail());
    }

    private void changeSeatsStatus( int currentStatus, int newStatus) {

        for (String rowNumber : this.finalReservationSeatsDetails.keySet()) {
            HashMap<String, Object> seatsNumber = (HashMap)this.finalReservationSeatsDetails.get(rowNumber);

            HashMap<String, Object> reservationSeatDetailsPerRow = new HashMap<>();

            for (String seatNumber : seatsNumber.keySet()) {
                HashMap<String, Object> seatDetails = (HashMap)seatsNumber.get(seatNumber);

                if ((int)seatDetails.get("seatKindOfReserved") == currentStatus) {
                    seatDetails.replace("seatKindOfReserved", newStatus);
                    reservationSeatDetailsPerRow.put(seatNumber, seatDetails);
                    this.finalReservationSeatsDetails.put(rowNumber, reservationSeatDetailsPerRow);
                }
            }
        }
    }

    private void setStatusSeatIsReserved() {
        this.seatIsTemporarilyReserved = reservation.movieScreenig.getCinemaRoom().getStatusSeatIsTemporarilyReserved();;
        this.seatIsReserved = reservation.movieScreenig.getCinemaRoom().getStatusSeatIsReserved();
        changeSeatsStatus(seatIsTemporarilyReserved, seatIsReserved);
    }

    private void setStatusSeatIsNotReserved() {
        changeSeatsStatus(seatIsTemporarilyReserved, seatIsNotReserved);
    }

    protected void cancelReservation(){
        this.seatIsNotReserved = reservation.movieScreenig.getCinemaRoom().getStatusSeatIsNotReserved();
        changeSeatsStatus(seatIsReserved, seatIsNotReserved);
        this.paymentStatus = refundReservationPayment;
        System.out.println("Reservation was cancel.");
    }


}
