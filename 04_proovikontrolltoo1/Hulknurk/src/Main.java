import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Double> xCoords = new ArrayList<>(Arrays.asList(1.0, 2.5, 3.5));
        ArrayList<Double> yCoords = new ArrayList<>(Arrays.asList(2.0, 4.5, 6.5));
        Hulknurk hulknurk = new Hulknurk(xCoords, yCoords);
    }
}