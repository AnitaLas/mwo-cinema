import java.util.HashMap;

public class Client {

    private HashMap<String, String> clientData;

    Client(String clientEmail) {
        this.clientData = new HashMap<>();
        this.clientData.put("clientEmail", clientEmail);
    }

    protected void setClientName(String clientName) {
        this.clientData.put("clientName", clientName);
    }

    protected String getClientEmail() {
        return this.clientData.get("clientEmail");
    }

    protected String getClientName() {
        return this.clientData.get("clientName");
    }

}
