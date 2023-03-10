import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    // fori = for loop
    // sout = System.out.println

    public static void main(String[] args) {
        System.out.println("Hello world!");

        /*

            String sonaline = "Sonaline muutuja";
            char taheline = 't';
            double komakohaga = 431.5315;
            float komakohaga2 = 313.34341f;
            boolean kahendv22rtus = true; // 0 ja 1
            byte pisikeNumber = 25;
            short lyhikeNumber = 312;
            long pikkNumber = 3141341341341L;

        */

        Scanner scanner = new Scanner(System.in);

        World world = new World(10, 5);

        Player player = new Player(world.width, world.height);
        Dragon dragon = new Dragon(world.width, world.height);
        Orc orc = new Orc(world.width, world.height);

        Item sword = new Item(10, 1, "Mõõk", world.width, world.height);
        Item hammer = new Item(5, 3, "Haamer", world.width, world.height);
        Item boot = new Item(1, 10, "Saabas", world.width, world.height);

        List<Item> items = new ArrayList<>(Arrays.asList(sword, hammer, boot));

        world.printMap(world.width, world.height,
                player.xCoordinate, player.yCoordinate, player.symbol,
                dragon.xCoordinate, dragon.yCoordinate, dragon.symbol,
                orc.xCoordinate, orc.yCoordinate, orc.symbol, items);

        System.out.println();
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            player.move(input, world);

            world.printMap(world.width, world.height,
                    player.xCoordinate, player.yCoordinate, player.symbol,
                    dragon.xCoordinate, dragon.yCoordinate, dragon.symbol,
                    orc.xCoordinate, orc.yCoordinate, orc.symbol, items);

            System.out.println();
            for (Item i:
                 items) {
                if (player.xCoordinate == i.xCoordinate && player.yCoordinate == i.yCoordinate) {
                    player.item = i;
                    System.out.println("Korjasid eseme: " + player.item.name);
                    break;
                }
            }
            input = scanner.nextLine();
        }
    }
}