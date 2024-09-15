package Classes_;


public class Destinations {
    private int destination_id;
    private String destination_name;
    private int destination_price;

    public Destinations(int destination_id, String destination_name, int destination_price) {
        this.destination_id = destination_id;
        this.destination_name = destination_name;
        this.destination_price = destination_price;
    }

    public Destinations() {
    }

    public int getDestination_id() {
        return destination_id;
    }

    public String getDestination_name() {
        return destination_name;
    }

    public int getDestination_price() {
        return destination_price;
    }

    public void setDestination_id(int destination_id) {
        this.destination_id = destination_id;
    }

    public void setDestination_name(String destination_name) {
        this.destination_name = destination_name;
    }

    public void setDestination_price(int destination_price) {
        this.destination_price = destination_price;
    }

    @Override
    public String toString() {
        return this.destination_name;
    }
    
    
    
}
