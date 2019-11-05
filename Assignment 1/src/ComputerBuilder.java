
import java.util.ArrayList;


public class ComputerBuilder {
    private Catalogue catalogue;
    private Build currentBuild;


    public static void main(String[] args) {
        ComputerBuilder computerBuilder = new ComputerBuilder();
        computerBuilder.welcome();
        computerBuilder.use1();
    }

    public ComputerBuilder() {
        currentBuild = new Build();
        catalogue = new Catalogue();
    }

    public void welcome() {
        System.out.println("Welcome to Jaime's Computer Store\nQuality parts at the Best Prices\n=================================");
        System.out.println("1. Catalogue Menu\n2. Build Menu\n3. Exit");

    }

    public void use1()
    {
        char choice1;
        while ((choice1 = readChar1()) != '3') {   // while loop continuously runs the choices until the choice = 3.
            switch (choice1) {
                case '1':
                    useCatalogue();
                    System.out.println("1. Catalogue Menu\n2. Build Menu\n3. Exit");   // prints message after doing it!
                    break;
                case '2':
                    useBuild();
                    System.out.println("1. Catalogue Menu\n2. Build Menu\n3. Exit");
                    break;
                default:
                    help1();
                    System.out.println("1. Catalogue Menu\n2. Build Menu\n3. Exit");
                    break;
            }
        }
    }



    private void help1() {
        System.out.println("1 = interact with the catalogue \n2 = build your computer!\n? = this help message");

    }

    private char readChar1(){
        System.out.print("Select option: ");
        return In.nextChar();
    }



    private void addPart(){  // uses addPart method in Catalogue
        catalogue.addPart();
    }

    private void removePart(){
        catalogue.removeParts();

    }

    private void showCatalogue(){
         catalogue.showParts();    // prints each part in arraylist and a new line
    }



    private void filteredCatalogue(){
        catalogue.filter();

    }

    private void useCatalogue(){
        System.out.println("Welcome to the parts catalogue.");
        char choice2;
        while ((choice2 = readChar2())!= 'x'){ // cannot use if statement choice2 will never equal x.
            switch (choice2) {
                case 'a': addPart(); break;
                case 'r': removePart(); break;
                case 's': showCatalogue(); break;
                case 'f': filteredCatalogue(); break;
                default: help2(); break;

            }
        }
    }



    private void help2(){
        System.out.println("a = add a new part to the catalogue\nr = remove a part from the catalogue\ns = show the catalogue\nf = show a filtered view of the catalogue\n? = this help message");
    }


    private char readChar2(){
        System.out.print("Enter Choice (a/r/s/f/x): ");
        return In.nextChar();
    }

    private void useBuild(){
        System.out.println("Let's build a 1337 box!");
        char choice3;
        while ((choice3 = readChar3()) != 'x') {
            switch (choice3) {
                case 'n': newBuild(); break;
                case 'a': addToBuild(); break;
                case 'r': removeItem(); break;
                case 'v': viewBuild(); break;
                case 'c': checkBuild(); break;
                default: help3(); break;
            }
        }
    }

    private char readChar3(){
        System.out.print("Enter Choice (n/a/r/v/c/x): ");
        return In.nextChar();

    }

    private void newBuild(){        // clears current build and starts new build (n)
    currentBuild.newBuilds();
    }

    private void addToBuild(){  // add a part from the catalogue to the build (a)
        ArrayList<Part> parts = getPart();
        if (parts != null) {
            for (Part p : parts) {
                if (p != null) {
                    currentBuild.addToBuild(p);
                }
                else
                    System.out.println("There is no part by that number.");
            }
        }
        else
            System.out.println("There is no part by that number.");


    }

    private void removeItem(){ // removes a part from the build (r)
        int i = currentBuild.removePart() - 1;
        currentBuild.removeFromBuild(i);


    }

    public ArrayList<Part> getPart(){
        String s = currentBuild.readPart().replaceAll(" ", "");
        String s2[] = s.split(",");
        ArrayList<Part> matches = new ArrayList<Part>();
        int i;
        for (String s1 : s2) {
            Integer number = Integer.valueOf(s1);
            i = number - 1;
            Part p = catalogue.getPart(i);
            if (p != null)
                matches.add(p);
            else
                return null;
        }

        return matches;
    }








    private void viewBuild(){ // show the current build and total price (v)
    System.out.print(currentBuild);
    }

    private void checkBuild(){ // check if the current build is functional (c)
        ArrayList<String> s1 = catalogue.partsCheck();
        ArrayList<String> s2 = currentBuild.parts();
        String ss = "";
        String s9 = "";
        String s6 = "";
        for (String s : s1) {
            if (!(s2.contains(s)) && (!s.equals("memory")) && !(s.equals("storage")) && (!s.equals("motherboard")))
                ss += "The build is missing a " + s + ".\n";
            else if (s.equals("motherboard") && !(s2.contains(s)))
                s9 = "The build is missing a motherboard.\n";
            else if (s.equals("memory") && !(s2.contains(s))) {
                s6 += "The build is missing RAM.\n";
            } else if (s.equals("storage") && !(s2.contains(s)))
                ss += "The build is missing " + s + ".\n";
        }
        if (ss == "")
        System.out.println("The build is functional.");
        else
            System.out.print(s9 + s6 + ss);
    }

    private void help3(){  // informs the user what the menu options do when they enter a non functional option.
        System.out.println("n = start a new build (clears old build)\na = add a part from the catalogue to the build\nr" +
                " = remove a part from the build\nv = show the current state of the build\nc = check if the build is a " +
                "functional computer\n? = this help message");
    }

}