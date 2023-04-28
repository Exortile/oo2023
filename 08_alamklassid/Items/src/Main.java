public class Main {
    public static void main(String[] args) {
        LongSword longSword = new LongSword(10, 3, "Diamond");
        Dagger dagger = new Dagger(5, 2);

        for (int i = 0; i < 5; i++) {
            System.out.printf("Rünne %d:%n", i + 1);

            longSword.attack(longSword.getFullDamage());
            dagger.attack(dagger.getFullDamage());

            System.out.println();
        }
    }
}