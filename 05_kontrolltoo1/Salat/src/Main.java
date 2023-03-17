import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Toiduaine toiduaine1 = new Toiduaine("kartul", 0.2f, 0.3f, 0.5f);
        Toiduaine toiduaine2 = new Toiduaine("hapukoor", 0.3f, 0.4f, 0.3f);
        Toiduaine toiduaine3 = new Toiduaine("vorst", 0.1f, 0.5f, 0.4f);

        Toidukomponent toidukomponent1 = new Toidukomponent(toiduaine1, 100);
        Toidukomponent toidukomponent2 = new Toidukomponent(toiduaine2, 50);
        Toidukomponent toidukomponent3 = new Toidukomponent(toiduaine3, 400);

        System.out.printf("Toiduaine nimega %s sisalduv rasvakogus: %d g%n", toiduaine3.nimetus, toidukomponent3.arvutaRasvaKogus());
        System.out.println();

        Toiduained toiduained = new Toiduained();
        toiduained.lisa(toiduaine1);
        toiduained.lisa(toiduaine2);
        toiduained.lisa(toiduaine3);

        Toiduaine otsitav = toiduained.otsiNimeKaudu("kartul");
        if (otsitav != null) {
            System.out.printf("Leiti toiduaine %s. Rasvade protsent: %f%n", otsitav.nimetus, otsitav.rasvadeProtsent);
        } else {
            System.out.println("Nime kaudu otsitavat toiduainet ei leitud!");
        }
        System.out.println();

        List<Toiduaine> otsitavad = toiduained.otsiRasvaKaudu(0.3f, 0.5f);
        System.out.println("Leiti sellised toiduained rasva kaudu:");
        for (Toiduaine toiduaine:
             otsitavad) {
            System.out.printf("Nimetus: %s%n", toiduaine.nimetus);
        }
        System.out.println();

        List<Toidukomponent> toidukomponendid = new ArrayList<>(Arrays.asList(toidukomponent1, toidukomponent2, toidukomponent3));
        Toit toit = new Toit("kena toit", toidukomponendid);
        toit.naitaToiduaineteKogused();

        Toiduarvutaja toiduarvutaja = new Toiduarvutaja(toit);
        toiduarvutaja.arvutaToiduained(5000);
    }
}