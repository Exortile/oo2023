import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingCart {
    ArrayList<Item> items;
    HashMap<Item, Integer> itemAmount;
    double totalPrice;

    public ShoppingCart() {
        this.items = new ArrayList<>();
        this.itemAmount = new HashMap<>();
        this.totalPrice = 0;
    }

    public void addItem(Item item, Shop shop, int amount) {
        if (amount > shop.productStock.get(item)) {
            System.out.println("Vabandust, see toode on otsas või pole piisavas koguses!");
            return;
        }

        shop.takeProduct(item, amount);

        if (this.items.contains(item)) {
            int currentAmount = this.itemAmount.get(item);
            this.itemAmount.put(item, currentAmount + amount);
        } else {
            this.items.add(item);
            this.itemAmount.put(item, amount);
        }

        this.totalPrice += item.price * amount;
    }

    public void removeItem(Item item, Shop shop, int amount) {
        int currentAmount = this.itemAmount.get(item);

        if (amount >= currentAmount) {
            amount = currentAmount; // igaks juhuks kui kasutaja poolt antud amount on liiga suur
            this.items.remove(item);
            this.itemAmount.remove(item);
        } else {
            this.itemAmount.put(item, currentAmount - amount);
        }

        this.totalPrice -= item.price * amount;
        shop.giveProduct(item, amount);
    }

    public void printItems() {
        if (this.items.isEmpty()) {
            System.out.println("Teie ostukorv on tühi!");
            System.out.println();
            return;
        }

        System.out.println("Hetkel ostukorvis olevad tooted:");

        for (int i = 0; i < this.items.size(); i++) {
            Item item = this.items.get(i);
            System.out.println("Toode " + (i + 1) + ": " + item.name + ", Hind: " + item.price + ", Kogus: " + this.itemAmount.get(item));
        }

        System.out.println("Kokku: " + String.format("%.2f", this.totalPrice) + "€");
        System.out.println();
    }
}
