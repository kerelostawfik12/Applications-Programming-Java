import java.text.*;
public class Part {
    private String name;
    private String type;
    private double price;

    public Part(String name, String type, double price){
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getType(){
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString(){
        return type.toUpperCase() + ": " +  name + " @ $" + formatted(price);
    }
    private String formatted(double amount){
        return new DecimalFormat("#####0.00").format(amount);
    }
}
