public interface StoreFunctions {
    void addProduct(Product product);
    void removeProduct(Product product);
    void greet();
    void printProducts();
    double getTotalPrice();
    Product getLeastExpensive();
    Product getMostExpensive();
}
