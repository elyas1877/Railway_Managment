public class Company {
    private String company_name;
    private int co_id;

    public Company(String name, int id) {
        this.company_name = name;
        this.co_id = id;
    }

    public Company() {
    }

    public String getName() {
        return company_name;
    }

    public int getId() {
        return co_id;
    }

    public void setName(String name) {
        this.company_name = name;
    }
    
    public void setId(int id) {
        this.co_id = id;
    }

    @Override
    public String toString() {
        return "Company{" + "name=" + company_name + ", id=" + co_id + '}';
    }
}
