public class Dagger extends Wieldable implements Wieldables {
    public Dagger(double sharpness, int drawTime) {
        super("Dagger", 5, 50, sharpness, drawTime);
    }

    public int getFullDamage() {
        double sharpnessDamage = this.sharpness * 0.25;
        return (int) ((this.durability / 100) * (sharpnessDamage + this.damage));
    }
}
