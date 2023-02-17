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

        world.printMap(world.width, world.height,
                player.xCoordinate, player.yCoordinate, player.symbol,
                dragon.xCoordinate, dragon.yCoordinate, dragon.symbol,
                orc.xCoordinate, orc.yCoordinate, orc.symbol);

        System.out.println();
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            player.move(input, world);

            world.printMap(world.width, world.height,
                    player.xCoordinate, player.yCoordinate, player.symbol,
                    dragon.xCoordinate, dragon.yCoordinate, dragon.symbol,
                    orc.xCoordinate, orc.yCoordinate, orc.symbol);

            System.out.println();
            input = scanner.nextLine();
        }
    }
}