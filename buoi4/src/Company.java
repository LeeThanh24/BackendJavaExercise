public class Company {

    //attributes
    private String name;
    private String taxId;
    private float monthlyIncome;


    //Constructors
    public Company() {
        this.name = "";
        this.taxId = "";
        this.monthlyIncome = 0.0f;
    }

    public Company(String name, String taxId, float monthlyIncome) {
        this.name = name;
        this.taxId = taxId;
        this.monthlyIncome = monthlyIncome;
    }


    //getters setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public float getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(float monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }


}
