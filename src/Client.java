import java.util.HashMap;

public class Client {

    private HashMap<String, String> clientData;
    //private String clientEmail;

    //private String clientName;


    Client(){
        this.clientData = new HashMap<>();
    }

    protected void setClientEmail( String clientEmail){
        this.clientData.put("clientEmail", clientEmail);
    }

    protected void setClientName( String clientName){
        this.clientData.put("clientName", clientName);
    }

    protected String getClientEmail(){
        return this.clientData.get("clientEmail");
    }

    protected String getClientName(){
        return this.clientData.get("clientName");
    }


}
