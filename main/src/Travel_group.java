import java.sql.Timestamp;
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

    public Locomotive_driver getDri() {
        return dri;
    }

    public Timestamp getDatetime() {
        return datetime;
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
        return "Travel_group{" + "tri=" + tri + ", dri=" + dri + ", datetime=" + datetime + '}';
    }

   

   
   
}
