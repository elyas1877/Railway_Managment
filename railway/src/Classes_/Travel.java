package Classes_;

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

    public void setTrg(Travel_group trg) 
    {
        this.trg = trg;
    }
    

    public void setDis(Destinations dis)
    {
        this.dis = dis;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public Travel_group getTrg() 
    {
        return trg;
    }
    public String getTriname()
    {
      return this.trg.getTri_name();
    }
    public int getTricode()
    {
     return this.trg.getTri_id();   
    }
    public int getLococode(){
        return this.trg.getDri_id();
    }
    public String getLoconame(){
       return this.trg.getDri_name(); 
    }
    
    public String getLocolname(){
       return this.trg.getDri_lname(); 
    }
    
    public Destinations getDis() {
        return dis;
    }
    public String getDate()
    {
        return this.trg.getDate();
    }
    public String getDest_name()
    {
       return this.dis.getDestination_name();
    }
    
    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return this.trg.getDate()+"-"+this.getDis().getDestination_name()+"-"+this.getTrg().getTri_name()+"-"+this.trg.getTri().getCo_name();
    }
    
    

   
}
