import java.sql.Timestamp;
public class Ticket {
   private Customer cus;
   private Travel tra;
   private int serial;
   private int chair;
   private int wagon;
   private boolean status;
   
    public Ticket(Customer cus, Travel tra, int serial, int chair, int wagon, boolean status) {
        this.cus = cus;
        this.tra = tra;
        this.serial = serial;
        this.chair = chair;
        this.wagon = wagon;
        this.status = status;
    }

    public Ticket() {
    }

    public Customer getCus() {
        return cus;
    }

    public Travel getTra() {
        return tra;
    }

    public int getSerial() {
        return serial;
    }

    public int getChair() {
        return chair;
    }

    public int getWagon() {
        return wagon;
    }

    public boolean getStatus() {
        return status;
    }

    public void setCus(Customer cus) {
        this.cus = cus;
    }

    public void setTra(Travel tra) {
        this.tra = tra;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public void setChair(int chair) {
        this.chair = chair;
    }

    public void setWagon(int wagon) {
        this.wagon = wagon;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Ticket{" + "cus=" + cus + ", tra=" + tra + ", serial=" + serial + ", chair=" + chair + ", wagon=" + wagon + ", status=" + status + '}';
    }
   
   
   
   
}
