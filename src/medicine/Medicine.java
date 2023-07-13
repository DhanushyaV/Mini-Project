package medicine;

public class Medicine {
    private Integer medid;
    private String medicineName;
    private Float cost;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    private  String state;
   private  Integer Quantity;

    public Integer getMedid() {
        return medid;
    }

    public void setMedid(Integer medid) {
        this.medid = medid;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }
}
