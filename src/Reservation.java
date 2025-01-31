import java.util.HashMap;

public class Reservation {

    private String clientEmail;// = "amail@ssss.pl";
    private String reservationNumber;
    private MovieScreenig movieScreenig;
    private Client client;

    private HashMap<String, Object> reservationSeatDetails;

   private  HashMap <String, Object> summarisedReservationSeatData;


    private HashMap<String, Object> reservationDetails;


    Reservation(){
        this.reservationSeatDetails = new HashMap<>();
    }

    protected void chooseMovieScreening(MovieScreenig movieScreenig){
        this.movieScreenig = movieScreenig;
    }

    protected void setClient(String clientEmail){
        this.clientEmail = clientEmail;
    }

    protected void setClient(Client client){
        this.client = client;
    }

    protected Client getClient(){
        return this.client;
    }

    protected void bookSeatsPerRow(String rowNumber, String seatsNumber){

        String seatsNo1 = seatsNumber.replace(" ", "");
        String[] seatsNo2 = seatsNo1.split(",");

       HashMap < String, Object > finalData = movieScreenig.getCinemaRoom().getRowSeatsData(rowNumber);

       // to do - validation for booked seats


        for(String key1 : finalData.keySet()){
            //System.out.println("keySeatNumber = " + key1);


            for(int s = 0; s< seatsNo2.length ;s++){

                //System.out.println("seatsNo A = " + seatsNo2[s]);

                if(key1.equals(seatsNo2[s])){

                    System.out.println("key1 = " + key1);
                    System.out.println("seatsNo B = " + seatsNo2[s]);

                    HashMap<String, Object > temp = (HashMap) finalData.get(key1);


                    temp.replace("isSeatReserved", true);
                    //System.out.println(temp);
                    HashMap<String, Object> reservationSeatDetailsPerRow = new HashMap<>();
                    reservationSeatDetailsPerRow.put(key1, temp);

                    // to fix!! wrong idea

                    this.reservationSeatDetails.put(rowNumber, reservationSeatDetailsPerRow);

                    //System.out.println("KEY END -------- ");
                    //temp.clear();
                }
            }
        }

        //System.out.println(finalData);
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    }

    // to do - fix -> bookSeatsPerRow() - 72
    protected void summariseReservationSeatsDetails(){
        this.summarisedReservationSeatData = new HashMap<>();

        for(String rowNumber : reservationSeatDetails.keySet()){
            //System.out.println("key rowNumber = " + rowNumber);

            HashMap<String, Object > currentSeatNumber = (HashMap) reservationSeatDetails.get(rowNumber);

            for(String seatNumber : currentSeatNumber.keySet()){

                //System.out.println("key seatNumber = " + seatNumber);

            }
            //System.out.println("------");
        }


    }


    protected void printCinemaRoomData(){



    }
}
