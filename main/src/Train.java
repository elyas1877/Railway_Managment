public class Train {
   private int train_id;
   private String train_name;
   private int id_co;
   private int wagons;
   private int class_id;
   
    public Train(int id, String name, int id_co,int wagons,int class_id) {
        this.train_id = id;
        this.train_name = name;
        this.id_co = id_co;
        this.wagons=wagons;
        this.class_id=class_id;
    }

    public Train() {
        
    }
    
    public int getId() {
        return train_id;
    }

    public String getName() {
        return train_name;
    }

    public int getId_co() {
        return id_co;
    }

    public int getClass_id() {
        return class_id;
    }

    public int getWagons() {
        return wagons;
    }
    
    public void setId(int id) {
        this.train_id = id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public void setName(String name) {
        this.train_name = name;
    }

    public void setId_co(int id_co) {
        this.id_co = id_co;
    }

    public void setWagons(int wagons) {
        this.wagons = wagons;
    }

    @Override
    public String toString() {
        return "Train{" + "id=" + train_id + ", name=" + train_name + ", id_co=" + id_co + ", wagons=" + wagons + ", class_id=" + class_id + '}';
    }
   
 
    
   
}
