import java.util.ArrayList;

public class Hulknurk {
    ArrayList<Double> xCoords;
    ArrayList<Double> yCoords;

    public Hulknurk(ArrayList<Double> xCoords, ArrayList<Double> yCoords) {
        this.xCoords = xCoords;
        this.yCoords = yCoords;
    }

    public double lisaKoordinaadiPaar(double x, double y) {
        this.xCoords.add(x);
        this.yCoords.add(y);
    }

    public double umbermoot() {
        double umbermoot = 0;
        int n = xCoords.size();
        for (int i = 0; i < n; i++) {
            double x1 = xCoords.get(i);
            double y1 = yCoords.get(i);
            double x2 = xCoords.get((i + 1) % n);
            double y2 = yCoords.get((i + 1) % n);
            umbermoot += Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        }
    }
}
