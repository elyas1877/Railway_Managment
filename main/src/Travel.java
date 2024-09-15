import java.sql.Timestamp;
public class Travel {
    private Travel_group trg;
    private Destinations dis;
    private int code;

    public Travel(Travel_group trg, Destinations dis, int code) {
        this.trg = trg;
        this.dis = dis;
        this.code = code;
    }

    public Travel() {
    }

    public void setTrg(Travel_group trg) {
        this.trg = trg;
    }

    public void setDis(Destinations dis) {
        this.dis = dis;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Travel_group getTrg() {
        return trg;
    }

    public Destinations getDis() {
        return dis;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Travel{" + "trg=" + trg + ", dis=" + dis + ", code=" + code + '}';
    }
    
    

   
}
