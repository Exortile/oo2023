public class Toiduaine {
    String nimetus;
    float valkudeProtsent;
    float rasvadeProtsent;
    float susivesikuteProtsent;

    public Toiduaine(String nimetus, float valkudeProtsent, float rasvadeProtsent, float susivesikuteProtsent) throws Exception {
        this.nimetus = nimetus;
        this.valkudeProtsent = valkudeProtsent;
        this.rasvadeProtsent = rasvadeProtsent;
        this.susivesikuteProtsent = susivesikuteProtsent;

        if (this.valkudeProtsent + this.rasvadeProtsent + this.susivesikuteProtsent > 1) {
            throw new Exception("Ainete protsent ületab 100%!");
        }
    }
}
