public class Player {
    int xCoordinate; // taisarvuline number
    int yCoordinate;
    char symbol;

    public Player(int worldWidth, int worldHeight) {
        this.xCoordinate = getRandomCoordinate(worldWidth);
        this.yCoordinate = getRandomCoordinate(worldHeight);
        this.symbol = 'X';
    }

    private static int getRandomCoordinate(int worldDimension) {
        return (int) (Math.random() * (worldDimension - 2) + 1);
    }

    public void move(String input) {
        switch (input) {
            case "w" -> this.yCoordinate -= 1;
            case "s" -> this.yCoordinate += 1;
            case "a" -> this.xCoordinate -= 1;
            case "d" -> this.xCoordinate += 1;
        }
    }
}
