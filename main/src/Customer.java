public class Customer {
    private int customer_id;
    private String customr_name;
    private String customer_lname;
    private String customer_phone;

    public Customer(int customer_id, String customr_name, String customer_lname, String customer_phone) {
        this.customer_id = customer_id;
        this.customr_name = customr_name;
        this.customer_lname = customer_lname;
        this.customer_phone = customer_phone;
    }

    public Customer() {
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public String getCustomr_name() {
        return customr_name;
    }

    public String getCustomer_lname() {
        return customer_lname;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setCustomr_name(String customr_name) {
        this.customr_name = customr_name;
    }

    public void setCustomer_lname(String customer_lname) {
        this.customer_lname = customer_lname;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    @Override
    public String toString() {
        return "customer{" + "customer_id=" + customer_id + ", customr_name=" + customr_name + ", customer_lname=" + customer_lname + ", customer_phone=" + customer_phone + '}';
    }
    
    
}
