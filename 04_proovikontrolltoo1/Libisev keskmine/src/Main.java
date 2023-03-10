import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(kolmeArvuKeskmine(3.0, 5.0, 7.0));
        double[] arvud = new double[]{3.0, 4.0, 5.0, 6.0, 7.0};
        System.out.println(Arrays.toString(kolmeArvuMassiiviKeskmine(arvud)));

        LibisevKeskmine libisevKeskmine = new LibisevKeskmine(arvud);
        libisevKeskmine.naitaAlgArve();
        libisevKeskmine.naitaKeskmisiArve();
        libisevKeskmine.lisaArv(14.0);
        libisevKeskmine.lisaArv(15.0);
        libisevKeskmine.naitaAlgArve();
        libisevKeskmine.naitaKeskmisiArve();
    }

    private static double kolmeArvuKeskmine(double a, double b, double c) {
        return (a + b + c) / 3.0;
    }

    private static double[] kolmeArvuMassiiviKeskmine(double[] massiiv) {
        if (massiiv.length < 3)
            return new double[]{};

        double[] valjund = new double[massiiv.length - 2];

        for (int i = 0; i < (massiiv.length - 2); i++) {
            double keskmine = (massiiv[i] + massiiv[i + 1] + massiiv[i + 2]) / 3.0;
            valjund[i] = keskmine;
        }

        return valjund;
    }
}