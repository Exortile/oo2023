public class World {
    int width;
    int height;

    public World(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void printMap(int worldWidth, int worldHeight, int playerXCoordinate, int playerYCoordinate, char playerSymbol, int dragonXCoordinate, int dragonYCoordinate, char dragonSymbol, int orcXCoordinate, int orcYCoordinate, char orcSymbol) {
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

    private void printCharacters(int playerXCoordinate, int playerYCoordinate, char playerSymbol,
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
