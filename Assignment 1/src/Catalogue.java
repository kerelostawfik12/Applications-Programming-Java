import java.util.*;

public class Catalogue{
    private List<Part> parts;

    public Catalogue(){
        parts = new ArrayList<Part>();
        parts.add(new Part("evo 860", "storage", 155.00));
        parts.add(new Part("daskeyboard", "keyboard", 239.00));
        parts.add(new Part("i5", "cpu", 365.00));
        parts.add(new Part("Corsair 16G", "memory", 299.00));
        parts.add(new Part("ASUS ROG", "motherboard", 159.00));
        parts.add(new Part("sheetmetal box", "case", 39.00));
        parts.add(new Part("Ryzen 7", "cpu", 299.00));

    }

    public void addPart(){      // adds item to arraylist in catalogue. Used in ComputerBuilder
        parts.add(new Part(getName(), getType(), getPrice()));
    }




         public void showParts() {//shows all parts in catalogue
            for (Part part : parts) {
                int i = parts.indexOf(part) + 1;
                System.out.println((i) + ". " + part);   //prints the number of each part in the ArrayList and a new line

            }
        }





        public void filter() {
            String type = readFilter();
            int minPrice = priceFilterMin();
            if (minPrice == -1) {
                System.out.print(filterByType(type));
            }

            else if ("all".equals(type)) {
                int maxPrice = priceFilterMax();
                System.out.print(filterByPrice(minPrice, maxPrice));
            }

            else {
                int maxPrice = priceFilterMax();
                System.out.print(filterByPrice(type, minPrice, maxPrice));
            }

        }




        private String filterByType(String type){
        String s = "";

            for (Part p : parts) {
                int i = parts.indexOf(p) + 1;
                if (p.getType().equals(type))
                    s += i + ". " + p + "\n";
                else if ("all".equals(type))
                    s += i + ". " + p + "\n";
            }

        return s;
        }






        private ArrayList<Part> filteredType(String type) {
            ArrayList<Part> matches = new ArrayList<Part>();
            for (Part part : parts) {
                if (part.getType().equals(type))
                    matches.add(part);
            }
            return matches;
        }

        private String filterByPrice(double minPrice, double maxPrice) {
        String s = "";

            if ((maxPrice > minPrice)) {
                for (Part p : parts) {
                    int i = parts.indexOf(p) + 1;
                    if (p.getPrice() <= maxPrice && p.getPrice() >= minPrice)
                        s += i + ". " + p + "\n";
                }
            }

            else if (maxPrice == minPrice)
                return s;

            else  {
                s = "Minimum price shouldn't be greater than maximum price.\n";
            }
            return s;
    }

    private String filterByPrice(String type, double minPrice, double maxPrice){
        String s = "";
        ArrayList<Part> filteredParts = filteredType(type);
        for (Part p : filteredParts) {
            int i = parts.indexOf(p) + 1;
            if (p.getPrice() <= maxPrice && p.getPrice() >= minPrice)
                s += i + ". " + p + "\n";
        }
        return s;
    }

    public Part getPart(int i){
        if (i > parts.size()) {
            return null;
        }
        else
            return parts.get(i);
    }

    public ArrayList<String> partsCheck() {
        ArrayList<String> matches = new ArrayList<String>();
        for (Part part : parts)
            matches.add(part.getType());
        matches.remove(1);
        return matches;
    }


        public String readFilter (){
            System.out.print("Enter type of part to view ('all' for no filtering): " );
            return In.nextLine();
        }

        public int priceFilterMin(){
            System.out.print("Enter minimum price ('-1' for no filtering): " );
            return In.nextInt();
        }

        public int priceFilterMax(){
            System.out.print("Enter maximum price: ");
            return In.nextInt();

        }


    public void removeParts(){
        int i = readParts()-1;   // -1 assists remove function
        if (i + 1 <= 0 || i + 1 > parts.size()) { // i + 1 is the number the user enters to begin with, which is the number they see next to a part when they use the show function.
            System.out.println("The build has no part with that number.");
        }
        else {
            parts.remove(i);// removes item from ArrayList based on user input, corresponds with show function.
        }
    }

    private int readParts(){
        System.out.print("Enter catalogue number of part to remove: ");
        return In.nextInt();
    }

    private double getPrice(){
        System.out.print("Enter part price: ");
        return In.nextDouble();
    }

    private String getName(){
        System.out.print("Enter part name: ");
        return In.nextLine();
    }

    private String getType() {
        System.out.print("Enter part type: ");
        return In.nextLine();
    }

}
