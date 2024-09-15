public class Locomotive_driver {
    private int id;
    private String name;
    private String lname;
    private String phone;
    private int co_id;

    public Locomotive_driver(int id, String name, String lname, String phone, int co_id) {
        this.id = id;
        this.name = name;
        this.lname = lname;
        this.phone = phone;
        this.co_id = co_id;
    }

    public Locomotive_driver() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLname() {
        return lname;
    }

    public String getPhone() {
        return phone;
    }

    public int getCo_id() {
        return co_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCo_id(int co_id) {
        this.co_id = co_id;
    }

    @Override
    public String toString() {
        return "Locomotive_driver{" + "id=" + id + ", name=" + name + ", lname=" + lname + ", phone=" + phone + ", co_id=" + co_id + '}';
    }
    
    
}
