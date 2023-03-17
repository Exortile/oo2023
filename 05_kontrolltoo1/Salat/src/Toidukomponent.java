public class Toidukomponent {
    Toiduaine toiduaine;
    int kogus; // grammides

    public Toidukomponent(Toiduaine toiduaine, int kogus) {
        this.toiduaine = toiduaine;
        this.kogus = kogus;
    }

    public int arvutaRasvakogus() {
        return Math.round(kogus * toiduaine.rasvadeProtsent);
    }
}
