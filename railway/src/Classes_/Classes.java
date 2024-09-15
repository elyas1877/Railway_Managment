package Classes_;


public class Classes {
    private int classes_id;
    private int classes_chairs;
    private String classes_name;

    public Classes(int classes_id, int classes_chairs, String classes_name) {
        this.classes_id = classes_id;
        this.classes_chairs = classes_chairs;
        this.classes_name = classes_name;
    }

    public Classes() {
    }

    public int getClasses_id() {
        return classes_id;
    }

    public int getClasses_chairs() {
        return classes_chairs;
    }

    public String getClasses_name() {
        return classes_name;
    }

    public void setClasses_id(int classes_id) {
        this.classes_id = classes_id;
    }

    public void setClasses_chairs(int classes_chairs) {
        this.classes_chairs = classes_chairs;
    }

    public void setClasses_name(String classes_name) {
        this.classes_name = classes_name;
    }

    @Override
    public String toString() {
        return this.getClasses_name()+"-"+this.getClasses_id();
    }
    
    
    
}
