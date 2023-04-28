import java.util.ArrayList;
import java.util.List;

public class Store {
    String name;
    String location;
    List<Product> products;

    public Store(String name, String location) {
        this.name = name;
        this.location = location;
        this.products = new ArrayList<>();
    }
}
