import java.text.DecimalFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class Build {
    private List<Part> parts;

    public Build() {
        parts = new ArrayList<Part>();
    }


    public void addToBuild(Part p) {
        parts.add(p);
    }

    public void removeFromBuild(int i) {
        if (i < parts.size())
            parts.remove(i);
        else
            System.out.println("The build has no part with that number.");
    }


    public int getSize() {
        return parts.size();
    }

    public void newBuilds() {
        parts.clear();
        parts.removeIf(Objects::isNull);
    }


    public ArrayList<String> parts() {
        ArrayList<String> matches = new ArrayList<String>();
        for (Part part : parts)
            matches.add(part.getType());
        return matches;
    }



    public String getPrice() {
        String s = "";
        double price = 0;
        for (Part part : parts)
            price += part.getPrice();
        s += "Total price: $" + formatted(price)+ "\n";
        return s;
    }


    public String readPart() {
        System.out.print("Enter catalogue number of the part: ");
        return In.nextLine();
    }

    public int removePart(){
        System.out.print("Enter number of part to remove: ");
        return In.nextInt();
        }

    @Override
    public String toString() {
        String s = "";
        for (Part part : parts) {
            int i = parts.indexOf(part) + 1;
            s += i + ". " + part + "\n";

        }
        s += getPrice();
        return s;
    }
        private String formatted ( double amount){
            return new DecimalFormat("#####0.00").format(amount);
        }


}
