public class GameObject {
    int x;
    int y;
    int hp;
    Actions currentAction;

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
        this.hp = 100;
        this.currentAction = Actions.Standing;
    }
}
