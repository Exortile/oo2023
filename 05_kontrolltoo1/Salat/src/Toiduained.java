import java.util.ArrayList;
import java.util.List;

public class Toiduained {
    List<Toiduaine> toiduained;

    public Toiduained(List<Toiduaine> toiduained) {
        this.toiduained = toiduained;
    }

    public Toiduained() {
        this.toiduained = new ArrayList<>();
    }

    public void lisa(Toiduaine toiduaine) {
        toiduained.add(toiduaine);
    }

    public void kustuta(Toiduaine toiduaine) {
        toiduained.remove(toiduaine);
    }

    public Toiduaine otsiNimeKaudu(String nimetus) {
        Toiduaine otsitav = null;

        for (Toiduaine toiduaine:
             toiduained) {
            if (toiduaine.nimetus.contains(nimetus)) {
                otsitav = toiduaine;
                break;
            }
        }

        return otsitav;
    }

    public List<Toiduaine> otsiRasvaKaudu(float rasvaProtsentMin, float rasvaProtsentMax) {
        List<Toiduaine> otsitavad = new ArrayList<>();

        for (Toiduaine toiduaine:
                toiduained) {
            if (toiduaine.rasvadeProtsent >= rasvaProtsentMin && toiduaine.rasvadeProtsent <= rasvaProtsentMax) {
                otsitavad.add(toiduaine);
            }
        }

        return otsitavad;
    }
}
