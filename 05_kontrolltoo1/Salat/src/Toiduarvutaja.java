import java.util.ArrayList;
import java.util.List;

public class Toiduarvutaja {
    Toit toit;

    public Toiduarvutaja(Toit toit) {
        this.toit = toit;
    }

    public void arvutaToiduained(int kogus) {
        int koguKogus = 0;

        for (Toidukomponent toidukomponent:
                toit.toidukomponendid) {
            koguKogus += toidukomponent.kogus;
        }
        
        int koguseVahe = kogus - koguKogus;
        float koguseKoefitsient = koguseVahe / (float)toit.toidukomponendid.size();

        List<Toidukomponent> uuedKomponendid = new ArrayList<>();
        for (Toidukomponent toidukomponent:
             toit.toidukomponendid) {
            uuedKomponendid.add(new Toidukomponent(toidukomponent.toiduaine, (int)(toidukomponent.kogus + koguseKoefitsient)));
        }

        System.out.printf("Vajalikud kogused %d g jaoks:%n", kogus);
        for (Toidukomponent toidukomponent:
             uuedKomponendid) {
            System.out.printf("%s: %d g%n", toidukomponent.toiduaine.nimetus, toidukomponent.kogus);
        }
    }
}
