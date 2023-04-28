import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RimiTest {

    @Test
    void getTotalPrice() {
        Rimi rimi = Main.createRimi();
        assertEquals(16.5, rimi.getTotalPrice());
    }

    @Test
    void getLeastExpensive() {
        Rimi rimi = Main.createRimi();
        Product leastExpensive = rimi.products.get(0);
        assertEquals(leastExpensive, rimi.getLeastExpensive());
    }

    @Test
    void getMostExpensive() {
        Rimi rimi = Main.createRimi();
        Product mostExpensive = rimi.products.get(3);
        assertEquals(mostExpensive, rimi.getMostExpensive());
    }
}