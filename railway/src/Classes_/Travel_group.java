package Classes_;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javafx.scene.shape.TriangleMesh;
public class Travel_group {
   private Train tri;
   private Locomotive_driver dri;
   private Timestamp datetime;
   
    public Travel_group(Train tri, Locomotive_driver dri, Timestamp datetime) {
        this.tri = tri;
        this.dri = dri;
        this.datetime = datetime;
    }

    public Travel_group() {
    }

    public Train getTri() {
        return tri;
    }
     public String getTri_name()
     {
        return this.tri.getName();
     }
     public int getTri_id()
     {
        return this.tri.getId();
     }

    public Locomotive_driver getDri() {
        return dri;
    }
    public String getDri_name()
    {
      return this.dri.getName();
    }
    public int getDri_id()
    {
        return this.dri.getId();
    }
    public String getDri_lname()
    {
     return this.dri.getLname();
    }

    public Timestamp getDatetime() {
        return datetime;
    }
    public String getDate()
    {
        String S =new SimpleDateFormat("yyyy-MM-dd HH:mm").format(this.datetime);
        return S;
    }

    public void setTri(Train tri) {
        this.tri = tri;
    }

    public void setDri(Locomotive_driver dri) {
        this.dri = dri;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return this.getDate()+"-"+this.getTri_name()+"-"+this.getTri_id();
    }

   

   
   
}
