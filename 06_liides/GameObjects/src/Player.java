import java.util.Objects;

public class Player extends GameObject implements Action {
    String currentItem;

    public Player(int x, int y) {
        super(x, y);
    }

    @Override
    public void changeState(Actions newState) {
        this.currentAction = newState;
        System.out.println("Playeri olek muudetud!");
    }

    @Override
    public void damage(int points) {
        this.hp -= points;
        this.currentItem = "none";
        System.out.printf("Playerit on kahjustatud %d punkti eest! Uus HP: %d%n", points, this.hp);
    }

    @Override
    public void damageOther(Action object, int points) {
        this.hp += points / 2;

        if (Objects.equals(this.currentItem, "mõõk")) {
            points += 10;
        }

        System.out.println("Player ründas!");
        object.damage(points);
    }

    @Override
    public void heal(int points) {
        this.hp += points;
        System.out.println("Playerit on tervendatud!");
    }

    @Override
    public void move(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.printf("Player asub nüüd x: %d ja y: %d%n", this.x, this.y);
    }
}
