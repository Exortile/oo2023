public class LongSword extends Wieldable implements Wieldables {
    String bladeType;

    public LongSword(double sharpness, int drawTime, String bladeType) {
        super(bladeType + " Long Sword", 10, 320.5, sharpness, drawTime);
        this.bladeType = bladeType;
    }

    public int getFullDamage() {
        double sharpnessDamage = this.sharpness * 0.5;
        return (int) ((this.durability / 100) * (sharpnessDamage + this.damage));
    }
}
