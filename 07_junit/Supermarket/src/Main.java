public class Main {
    public static void main(String[] args) {
        Rimi rimi = createRimi();

        rimi.printProducts();
    }

    public static Rimi createRimi() {
        Rimi rimi = new Rimi("Tallinn");

        rimi.addProduct(new Product("Vorst", 2.50));
        rimi.addProduct(new Product("Piim", 4.50));
        rimi.addProduct(new Product("Keefir", 3.50));
        rimi.addProduct(new Product("Juust", 6.00));

        return rimi;
    }
}