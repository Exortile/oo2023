import java.util.Objects;

public class Enemy extends GameObject implements Action {
    String currentBuff;

    public Enemy(int x, int y) {
        super(x, y);
    }

    @Override
    public void changeState(Actions newState) {
        this.currentAction = newState;
    }

    @Override
    public void damage(int points) {
        this.hp -= points;
        System.out.printf("Vaenlast on kahjustatud %d punkti eest! Uus HP: %d%n", points, this.hp);
    }

    @Override
    public void damageOther(Action object, int points) {
        if (Objects.equals(this.currentBuff, "double damage")) {
            points *= 2;
        }

        if (this.currentAction == Actions.Running) {
            points += 5;
        }

        System.out.println("Vaenlane ründas!");
        object.damage(points);
    }

    @Override
    public void heal(int points) {
        this.hp += points;
    }

    @Override
    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
