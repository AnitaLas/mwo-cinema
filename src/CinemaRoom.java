import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CinemaRoom {

    private String cinemaRoomName;
    private String ansiGreen = "\033[0;32m";
    private String ansiYellow = "\033[33m";
    private String ansiRed = "\033[31m";
    private String ansiRest = "\u001B[0m";

    private int seatIsNotReserved = 0;
    private int seatIsReserved = 1;
    private int seatIsTemporarilyReserved = 2;

    //protected Cinema cinema;

    private HashMap<String, Object> seatDetails;
    private HashMap<String, Object> seatNumber;
    private HashMap < String, Object> rowSeatsData;
    private HashMap<String, String> cinemaData;

    CinemaRoom(){
        this.rowSeatsData = new HashMap<>();
    }

    protected  HashMap < String, Object>  getRowSeatsData(String rowNumber){
        return (HashMap) this.rowSeatsData.get(rowNumber);
    }

    // to do - String cinemaRoomName -> CinemaRoom(){}
    // assumtion - first we set room name
    protected void setRoomName(String cinemaRoomName){
        this.cinemaRoomName = cinemaRoomName;
    }

    protected String getRoomName(){
        return this.cinemaRoomName;
    }

    protected void setCinemaData(HashMap<String, String> cinemaData){
        this.cinemaData = cinemaData;
    }

    protected String getCinemaName(){
        return this.cinemaData.get("cinemaName");
    }

    protected String getCinemaAddress(){
        return this.cinemaData.get("cinemaAddress");
    }

    protected int getStatusSeatIsTemporarilyReserved(){
        return this.seatIsTemporarilyReserved;
    }

    protected int getStatusSeatIsNotReserved(){
        return this.seatIsNotReserved;
    }

    protected int getStatusSeatIsReserved(){
        return this.seatIsReserved;
    }

    private HashMap<String, Object> createSeatDetails(String seatType){
        HashMap<String, Object> seatDetails = new HashMap<>();
        seatDetails.put("seatKindOfReserved", seatIsNotReserved);
        seatDetails.put("seatType", seatType);
        seatDetails.put("price", 29.99);
        return seatDetails;
    }

    protected void createSeatsForOneRow(int rowNumber, int seatsNumber){
        String seatType = "STANDARD";
        this.createSeatsForOneRow(rowNumber, seatsNumber, seatType);
    }

    protected void createSeatsForOneRow(int rowNumber, int seatsNumber, String seatType){

       this.seatNumber =  new HashMap<>();

        for(int i = 1; i <= seatsNumber; i++) {
            this.seatDetails = createSeatDetails(seatType);
            this.seatNumber.put(Integer.toString(i), this.seatDetails);
        }

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
                int seatKindOfReserved = (int)currentSeatDetails.get("seatKindOfReserved");

                // to do - remove seatKindOfReserved
                if(seatKindOfReserved == seatIsNotReserved)
                    System.out.print(" " + ansiGreen + keySeatNumber + ansiRest +seatKindOfReserved + "  |  ");
                else if(seatKindOfReserved == seatIsTemporarilyReserved)
                    System.out.print(" " + ansiYellow + keySeatNumber + ansiRest +seatKindOfReserved + "  |  ");
                else
                System.out.print(" " + ansiRed + keySeatNumber + ansiRest + "  |  ");
            }

            System.out.println();
        }
    }



}
