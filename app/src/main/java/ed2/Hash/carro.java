public class carro {
    private String plate;
    private String brand;
    private String model;
    private String color;
    private String Owner_register;

    public carro(String plate, String brand, String model, String color, String Owner_register) {
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.Owner_register = Owner_register;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOwner_register() {
        return Owner_register;
    }

    public void setOwner_register(String owner_register) {
        Owner_register = owner_register;
    }

}
