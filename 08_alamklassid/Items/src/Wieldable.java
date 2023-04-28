public class Wieldable extends Item {
    double sharpness;
    int drawTime;
    double durability;

    public Wieldable(String name, int damage, double weight) {
        super(name, damage, weight);
        this.sharpness = 0;
        this.drawTime = 1;
        this.durability = 100;
    }

    public Wieldable(String name, int damage, double weight, double sharpness, int drawTime) {
        super(name, damage, weight);
        this.sharpness = sharpness;
        this.drawTime = drawTime;
        this.durability = 100;
    }

    public void attack(int damage) {
        this.durability -= 5;

        System.out.printf("Ründasid %d punkti eest! Uus vastupidavus protsent: %.1f%n", damage, this.durability);
    }
}
