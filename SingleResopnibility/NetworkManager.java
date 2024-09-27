package Aufagbe2.SingleResopnibility;



public class NetworkManager {
    public void initializeNetworkConnection() {
        System.out.println("connecting to payment gateway.");
    }

    public boolean checkNetworkConnection() {
        String networkStatus = "connected";
        return networkStatus.equals("connected");
    }
}
