import java.util.Scanner;
import java.lang.Math;

public class Zybook {
    public static void main (String [] args) {
        Scanner scnr = new Scanner(System.in);
        long sideLength;
        long cubeVolume;

        System.out.print("Enter cube's side length: ");
        sideLength = scnr.nextLong();

        cubeVolume = (sideLength) * (sideLength) * (sideLength);

        System.out.println("Cube's volume is: " + cubeVolume);
    }
}
