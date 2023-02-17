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

        int worldWidth = 10;
        int worldHeight = 5;

        Player player = new Player(worldWidth, worldHeight);
        Dragon dragon = new Dragon(worldWidth, worldHeight);
        Orc orc = new Orc(worldWidth, worldHeight);

        printMap(worldWidth, worldHeight,
                player.xCoordinate, player.yCoordinate, player.symbol,
                dragon.xCoordinate, dragon.yCoordinate, dragon.symbol,
                orc.xCoordinate, orc.yCoordinate, orc.symbol);

        System.out.println();
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            player.move(input);

            printMap(worldWidth, worldHeight,
                    player.xCoordinate, player.yCoordinate, player.symbol,
                    dragon.xCoordinate, dragon.yCoordinate, dragon.symbol,
                    orc.xCoordinate, orc.yCoordinate, orc.symbol);

            System.out.println();
            input = scanner.nextLine();
        }
    }

    private static void printMap(int worldWidth, int worldHeight, int playerXCoordinate, int playerYCoordinate, char playerSymbol, int dragonXCoordinate, int dragonYCoordinate, char dragonSymbol, int orcXCoordinate, int orcYCoordinate, char orcSymbol) {
        // algväärtus   kuni   iga tsükkel
        for (int y = 0; y < worldHeight; y++) {
            System.out.println();
            for (int x = 0; x < worldWidth; x++) {
                if (y == 0 || y == worldHeight - 1) {
                    System.out.print("-");
                } else if (x == 0 || x == worldWidth - 1) {
                    System.out.print("|");
                } else {
                    // ctrl + alt + m
                    // right click -> refactor -> extract method
                    printCharacters(playerXCoordinate, playerYCoordinate, playerSymbol,
                            dragonXCoordinate, dragonYCoordinate, dragonSymbol,
                            orcXCoordinate, orcYCoordinate, orcSymbol, y, x);
                }
            }
        }
    }

    private static int getRandomCoordinate(int worldDimension) {
        return (int) (Math.random() * (worldDimension - 2) + 1);
    }

    private static void printCharacters(int playerXCoordinate, int playerYCoordinate, char playerSymbol,
                                        int dragonXCoordinate, int dragonYCoordinate, char dragonSymbol,
                                        int orcXCoordinate, int orcYCoordinate, char orcSymbol, int mapY, int mapX) {
        if (playerXCoordinate == mapX && playerYCoordinate == mapY) {
            System.out.print(playerSymbol);
        } else if (dragonXCoordinate == mapX && dragonYCoordinate == mapY) {
            System.out.print(dragonSymbol);
        } else if (orcXCoordinate == mapX && orcYCoordinate == mapY) {
            System.out.print(orcSymbol);
        } else {
            System.out.print(" ");
        }
    }
}