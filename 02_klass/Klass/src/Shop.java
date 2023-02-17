import java.util.ArrayList;
import java.util.HashMap;

public class Shop {
    String name;
    HashMap<Item, Integer> productStock;
    ArrayList<Item> products;
    ShoppingCart shoppingCart;
    boolean isOpen;

    public Shop(String name) {
        this.shoppingCart = new ShoppingCart();
        this.productStock = new HashMap<>();
        this.products = new ArrayList<>();
        this.name = name;
        this.open();
    }

    private void open() {
        this.isOpen = true;
        this.greet();
    }

    private void close() {
        this.isOpen = false;
        this.farewell();
    }

    private void greet() {
        System.out.println("Tere tulemast poodi: " + this.name + "!");
        System.out.println();
    }

    private void farewell() {
        System.out.println("Aitäh külastamast!");
        System.out.println();
    }

    public void addProduct(Item product, int stock) {
        this.products.add(product);
        this.productStock.put(product, stock);
    }

    public void printAllProducts() {
        System.out.println("Hetkel poes kättesaadaval tooted:");

        for (int i = 0; i < this.products.size(); i++) {
            Item item = this.products.get(i);
            System.out.println("Toode " + (i + 1) + ": " + item.name + ", Hind: " + item.price + ", Kogus: " + this.productStock.get(item));
        }

        System.out.println();
    }

    public void payForProducts() {
        if (this.shoppingCart.items.isEmpty()) {
            System.out.println("Teie ostukorv on tühi!");
            System.out.println();
            return;
        }

        System.out.println("Te maksite ostukorvis olevate toodete eest " + String.format("%.2f", this.shoppingCart.totalPrice) + "€.");
        System.out.println();
        this.close();
    }

    public void takeProduct(Item item, int amount) {
        int stock = this.productStock.get(item);
        this.productStock.put(item, stock - amount);
    }

    public void giveProduct(Item item, int amount) {
        int stock = this.productStock.get(item);
        this.productStock.put(item, stock + amount);
    }

    public void leaveShop() {
        this.close();
    }
}
