import java.util.List;

public class World {
    int width;
    int height;

    public World(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void printMap(int worldWidth, int worldHeight,
                         int playerXCoordinate, int playerYCoordinate, char playerSymbol,
                         int dragonXCoordinate, int dragonYCoordinate, char dragonSymbol,
                         int orcXCoordinate, int orcYCoordinate, char orcSymbol, List<Item> items) {
        // algväärtus   kuni   iga tsükkel
        char symbol;

        for (int y = 0; y < worldHeight; y++) {
            System.out.println();
            symbol = ' ';
            for (int x = 0; x < worldWidth; x++) {

                if (y == 0 || y == worldHeight - 1) {
                    symbol = '-';
                } else if (x == 0 || x == worldWidth - 1) {
                    //System.out.print("|");
                    symbol = '|';
                } else {
                    // ctrl + alt + m
                    // right click -> refactor -> extract method

                    for (Item i:
                         items) {
                        if (i.xCoordinate == x && i.yCoordinate == y) {
                            // System.out.print("I");
                            symbol = 'I';

                            break;
                        }
                    }

                    if (playerXCoordinate == x && playerYCoordinate == y) {
                        //System.out.print(playerSymbol);
                        symbol = playerSymbol;
                    } else if (dragonXCoordinate == x && dragonYCoordinate == y) {
                        //System.out.print(dragonSymbol);
                        symbol = dragonSymbol;
                    } else if (orcXCoordinate == x && orcYCoordinate == y) {
                        //System.out.print(orcSymbol);
                        symbol = orcSymbol;
                    }


                }
                System.out.print(symbol);
                symbol = ' ';
            }
        }
    }

}
