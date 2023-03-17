import java.util.ArrayList;
import java.util.List;

public class Toit {
    String nimetus;
    List<Toidukomponent> toidukomponendid;

    public Toit(String nimetus, List<Toidukomponent> toidukomponendid) {
        this.nimetus = nimetus;
        this.toidukomponendid = toidukomponendid;
    }

    public Toit(String nimetus) {
        this.nimetus = nimetus;
        this.toidukomponendid = new ArrayList<>();
    }

    public void naitaToiduaineteKogused() {
        int valgud = 0;
        int rasvad = 0;
        int susivesikud = 0;

        for (Toidukomponent toidukomponent:
             toidukomponendid) {
            valgud += toidukomponent.arvutaValkudeKogus();
            rasvad += toidukomponent.arvutaRasvaKogus();
            susivesikud += toidukomponent.arvutaSusivesikuteKogus();
        }

        System.out.printf("Valkude kogus: %d, rasvade kogus: %d, susivesikute kogus: %d%n", valgud, rasvad, susivesikud);
    }


}
