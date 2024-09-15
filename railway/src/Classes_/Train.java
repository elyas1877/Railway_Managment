package Classes_;

public class Train {
   private int train_id;//
   private String train_name;//
   private int id_co;
   private String co_name;
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

    public int getTrain_id() {
        return train_id;
    }

    public String getTrain_name() {
        return train_name;
    }

    public String getCo_name() {
        return co_name;
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

    public void setTrain_id(int train_id) {
        this.train_id = train_id;
    }

    public void setTrain_name(String train_name) {
        this.train_name = train_name;
    }

    public void setCo_name(String co_name) {
        this.co_name = co_name;
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
        
        return this.getName()+"-"+this.getId();
    }
   
 
    
   
}
