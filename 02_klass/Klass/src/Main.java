import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop("Peetri Külapood");
        generateProducts(shop);

        while (shop.isOpen) {
            interactWithShop(shop);
        }
    }

    private static void generateProducts(Shop shop) {
        ArrayList<Item> products = new ArrayList<>();

        products.add(new Item("Doktori vorst", 1.59, 2));
        products.add(new Item("Voimix", 0.89, 3));
        products.add(new Item("Ketšup", 1.29, 1));
        products.add(new Item("Laste vorst", 2.59, 1));
        products.add(new Item("Grillkana", 4.79, 2));

        for (Item product:
             products) {
            shop.addProduct(product, product.amount);
        }
    }

    private static void addProductsToBasket(Shop shop) {
        shop.printAllProducts();

        String itemIndexStr = askForInput("Missugust toodet soovite osta?: ");
        String amountStr = askForInput("Mitu tükki?: ");

        int itemIndex = Integer.parseInt(itemIndexStr) - 1;
        int amount = Integer.parseInt(amountStr);

        Item item = shop.products.get(itemIndex);

        shop.shoppingCart.addItem(item, shop, amount);
    }

    private static void removeProductsFromBasket(Shop shop) {
        shop.shoppingCart.printItems();

        String itemIndexStr = askForInput("Missugust toodet soovite tagasi panna?: ");
        String amountStr = askForInput("Mitu tükki?: ");

        int itemIndex = Integer.parseInt(itemIndexStr) - 1;
        int amount = Integer.parseInt(amountStr);

        Item item = shop.products.get(itemIndex);

        shop.shoppingCart.removeItem(item, shop, amount);
    }

    private static String askForInput(String message) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(message);
        String input = scanner.nextLine();
        System.out.println();

        return input;
    }

    private static void interactWithShop(Shop shop) {
        System.out.println("Mida soovite teha?");
        System.out.println("1. Lisada toodet ostukorvi");
        System.out.println("2. Eemaldada toodet ostukorvist");
        System.out.println("3. Näha poe kõikide toodete seisukorda");
        System.out.println("4. Maksta toodete eest ja lahkuda");
        System.out.println("5. Lahkuda poest ilma maksmata");
        System.out.println("6. Vaata ostukorvi seisu");

        String input = askForInput("Valik: ");

        switch (input) {
            case "1" -> addProductsToBasket(shop);
            case "2" -> removeProductsFromBasket(shop);
            case "3" -> shop.printAllProducts();
            case "4" -> shop.payForProducts();
            case "5" -> shop.leaveShop();
            case "6" -> shop.shoppingCart.printItems();
        }
    }
}