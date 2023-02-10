public class Main {
    public static void main(String[] args) {
        String name = "Ville";
        String greeting = getNameGreeting(name);
        int randomPositiveNumber = (int) (Math.random() * 100);
        int randomNegativeNumber = (int) (Math.random() * -100);
        int result = addNumbers(randomPositiveNumber, randomNegativeNumber);

        System.out.println(greeting);
        System.out.println();

        System.out.println("Juhuslik positiivne arv: " + randomPositiveNumber);
        System.out.println("Juhuslik negatiivne arv: " + randomNegativeNumber);
        System.out.println();

        checkAndPrintNumberSign(randomPositiveNumber);
        checkAndPrintNumberSign(randomNegativeNumber);

        System.out.println(randomPositiveNumber + " + " + randomNegativeNumber + " = " + result);
    }

    private static String getNameGreeting(String name) {
        return "Tere tulemast, " + name + "!";
    }

    private static int addNumbers(int a, int b) {
        return a + b;
    }

    private static void checkAndPrintNumberSign(int number) {
        if (number < 0) {
            System.out.println("Arv " + number + " on negatiivne.");
        } else {
            System.out.println("Arv " + number + " on positiivne.");
        }
    }
}