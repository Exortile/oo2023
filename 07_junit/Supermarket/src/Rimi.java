import java.util.Collections;

public class Rimi extends Store implements StoreFunctions {

    public Rimi(String location) {
        super("Rimi", location);
        this.greet();
    }

    @Override
    public void addProduct(Product product) {
        this.products.add(product);
    }

    @Override
    public void removeProduct(Product product) {
        this.products.remove(product);
    }

    @Override
    public void greet() {
        System.out.println("Tere tulemast Rimisse!");
    }

    @Override
    public void printProducts() {
        System.out.println("Hetke tooted:");
        for (var p:
             this.products) {
            System.out.printf("Nimi: %s, Hind: %.2f%n", p.name, p.price);
        }
    }

    @Override
    public double getTotalPrice() {
        double total = 0;

        for (var p:
             this.products) {
            total += p.price;
        }

        return total;
    }

    @Override
    public Product getLeastExpensive() {
        return Collections.min(this.products, new ProductComparator());
    }

    @Override
    public Product getMostExpensive() {
        return Collections.max(this.products, new ProductComparator());
    }
}
