public interface Action {
    void changeState(Actions newState);
    void damage(int points);
    void damageOther(Action object, int points);
    void heal(int points);
    void move(int x, int y);
}
