public class Player {
    int xCoordinate; // taisarvuline number
    int yCoordinate;
    char symbol;
    Direction direction;
    Item item;

    public Player(int worldWidth, int worldHeight) {
        this.xCoordinate = getRandomCoordinate(worldWidth);
        this.yCoordinate = getRandomCoordinate(worldHeight);
        this.symbol = 'X';
        this.direction = Direction.UP;
    }

    private static int getRandomCoordinate(int worldDimension) {
        return (int) (Math.random() * (worldDimension - 2) + 1);
    }

    public void move(String input, World world) {
        switch (input) {
            case "w" -> this.direction = Direction.UP;
            case "s" -> this.direction = Direction.DOWN;
            case "a" -> this.direction = Direction.LEFT;
            case "d" -> this.direction = Direction.RIGHT;
        }

        switch (this.direction) {
            case UP -> {
                if (this.yCoordinate > 1)
                    this.yCoordinate -= 1;
            }
            case DOWN -> {
                if (this.yCoordinate < world.height - 2)
                    this.yCoordinate += 1;
            }
            case LEFT -> {
                if (this.xCoordinate > 1)
                    this.xCoordinate -= 1;
            }
            case RIGHT -> {
                if (this.xCoordinate < world.width - 2)
                    this.xCoordinate += 1;
            }
        }
    }
}
