public class Toidukomponent {
    Toiduaine toiduaine;
    int kogus; // grammides

    public Toidukomponent(Toiduaine toiduaine, int kogus) {
        this.toiduaine = toiduaine;
        this.kogus = kogus;
    }

    public int arvutaRasvaKogus() {
        return Math.round(kogus * toiduaine.rasvadeProtsent);
    }

    public int arvutaValkudeKogus() {
        return Math.round(kogus * toiduaine.valkudeProtsent);
    }

    public int arvutaSusivesikuteKogus() {
        return Math.round(kogus * toiduaine.susivesikuteProtsent);
    }
}
