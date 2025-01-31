import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CinemaRoom {

    private String cinemaRoomName;
    private String ansiGreen = "\033[0;32m";
    private String ansiRed = "\033[31m";
    private String ansiRest = "\u001B[0m";

    // key = seat details name




    private HashMap<String, Object> seatDetails;
    private HashMap<String, Object> seatNumber;

    //      key1 = roomName, key2 = rowNummber, key3 = seatNumber, Key4 = seatDetails(parName, parValue)
    // v1 w private HashMap<String,  HashMap<String,    HashMap<String,    HashMap<String, Object >>>> cinemaRoomData;
   // private HashMap<String,    HashMap<String,    HashMap<String, Object >>> cinemaRoomData;

    private HashMap < String, Object> rowSeatsData;// = new HashMap<>();

    //private HashMap < String, Object> cinemaRoomSeatsData;

    CinemaRoom(){
        //this.cinemaRoomData = new HashMap<>();
        this.rowSeatsData = new HashMap<>();
    }



    protected  HashMap < String, Object>  getRowSeatsData(String rowNumber){
        return (HashMap) this.rowSeatsData.get(rowNumber);
    }



    // assumtion - first we set room name
    protected void setRoomName(String cinemaRoomName){
        this.cinemaRoomName = cinemaRoomName;
    }

    protected String getRoomName(){
        return this.cinemaRoomName;

    }


    // key = one seat detail
    private HashMap<String, Object> createSeatDetails(String seatType){
        HashMap<String, Object> seatDetails = new HashMap<>();
        seatDetails.put("isSeatReserved", false);
        seatDetails.put("seatType", seatType);
        seatDetails.put("price", 29.99);
        return seatDetails;
    }


    protected void createSeatsForOneRow(int rowNumber, int seatsNumber){
        String seatType = "STANDARD";
        this.createSeatsForOneRow(rowNumber, seatsNumber, seatType);
    }


    protected void createSeatsForOneRow(int rowNumber, int seatsNumber, String seatType){

        // key = seat details,
       //HashMap<String, Object > this.seatDetails = createSeatDetails(seatType);


        //key = row
        // v1 w HashMap <String, HashMap < String, HashMap < String, Object >>> rowSeatsData = new HashMap<>();
       //this.rowSeatsData = new HashMap<>();
        //HashMap<String, Object > seatNumber =  new HashMap<>();
       this.seatNumber =  new HashMap<>();

        for(int i = 1; i <= seatsNumber; i++) {

            this.seatDetails = createSeatDetails(seatType);
           // System.out.println(" i = " + i);
            //System.out.println(" iAAA = " + Integer.toString(i));
            //System.out.println("  --  ");

            // key = seat number
            // v1 w HashMap<String, HashMap<String, Object >> seatNumber =  new HashMap<>();
           // HashMap<String, Object > seatNumber =  new HashMap<>();
            this.seatNumber.put(Integer.toString(i), this.seatDetails);

           // this.rowSeatsData.put(Integer.toString(rowNumber),seatNumber);

        }

        // v1 w this.cinemaRoomData.put(this.cinemaRoomName,rowSeatsData);
        //this.cinemaRoomData.put(this.cinemaRoomName,rowSeatsData);

        this.rowSeatsData.put(Integer.toString(rowNumber),this.seatNumber);

    }

    protected void printCinemaRoomData(){

        System.out.println();
        System.out.println("       " + cinemaRoomName.toUpperCase());

        for(String keyRowNumber : rowSeatsData.keySet()){

            System.out.print("row " + keyRowNumber + " : ");
            HashMap<String, Object > currentSeatNumber = (HashMap)rowSeatsData.get(keyRowNumber);

            for(String keySeatNumber : currentSeatNumber.keySet()){

                HashMap<String, Object >  currentSeatDetails = (HashMap)currentSeatNumber.get(keySeatNumber);

               boolean isSeatReserved = (boolean)currentSeatDetails.get("isSeatReserved");

                /*if(keySeatNumber.equals("1")){


                    currentSeatDetails.replace("isSeatReserved", true);
                    //System.out.println(currentSeatDetails);

                }*/

               if(isSeatReserved == false)
                System.out.print(" " + ansiGreen + keySeatNumber + ansiRest +isSeatReserved + "  |  ");
                //System.out.print(" " + ansiGreen + keySeatNumber + ansiRest + "  |  ");
               else
                System.out.print(" " + ansiRed + keySeatNumber + ansiRest + "  |  ");
                //System.out.println(" ");
            }


            System.out.println();
        }

    }



}
