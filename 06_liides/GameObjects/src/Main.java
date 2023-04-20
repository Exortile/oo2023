public class Main {
    public static void main(String[] args) {
        Player player = new Player(5, 4);
        player.currentItem = "mõõk";

        Enemy enemy = new Enemy(3, 1);
        enemy.currentBuff = "double damage";

        enemy.damageOther(player, 20);
        player.heal(10);

        player.damageOther(enemy, 30);
        enemy.heal(20);

        player.changeState(Actions.Running);
        player.move(6, 7);

        enemy.changeState(Actions.Walking);
        enemy.move(5, 8);
    }
}