import java.util.HashMap;
import java.util.List;

public class Reservation {

    private String customerEmail = "amail@ssss.pl";
    private String reservationNumber;
    public MovieScreenig movieScreenig;
    private HashMap<String, Object> reservationSeatDetails;

   private  HashMap < String, Object > temp;


    private HashMap<String, Object> reservationDetails;


    Reservation(){
        this.reservationSeatDetails = new HashMap<>();
        //reservationNumber = "ResNo: 2025 " + customerEmail;

        //this.reservationDetails.put("reservationNumber", reservationNumber);
        //reservationDetails.put("customerEmail", customerEmail);
    }


    public void chosseMovieScreening(MovieScreenig movieScreenig){
        this.movieScreenig = movieScreenig;
    }



    public void bookSeatsPerRow(String rowNumber, String seatNumber){

       HashMap < String, Object > finalData = movieScreenig.getCinemaRoom().getRowSeatsData(rowNumber);
      //this.finalData = movieScreenig.getCinemaRoom().getRowSeatsData(rowNumber);
        System.out.println(finalData);

        for(String key1 : finalData.keySet()){
            //System.out.println("keySeatNumber = " + key1);


            System.out.println("> seat number key1 : " + key1);// + " = " + temp.get(key2));

            if(key1.equals("1")){

                //HashMap<String, Object > temp = (HashMap<String, Object>) finalData.get(key1);
                this.temp = (HashMap<String, Object>) finalData.get(key1);

                    System.out.println("KEY START -------- ");
                    //System.out.println("sn "+ seatsNumber.get(seatNumber)  );
                    //System.out.println("ctd  " + currentSeatDetails.get(seatNumber));
                    // System.out.println(currentSeatDetails.get("isSeatReserved"));

                    temp.replace("isSeatReserved", true);
                    //System.out.println(currentSeatDetails);


                System.out.println("KEY END -------- ");
                //temp.clear();
            }





            //System.out.println("NO IF" + currentSeatDetails);
        }

        System.out.println(finalData);

    }



}
