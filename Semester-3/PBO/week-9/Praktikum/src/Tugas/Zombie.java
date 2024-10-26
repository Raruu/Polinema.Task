package Tugas;

public class Zombie implements Destroyable {
    protected int level;
    protected double health;

    public void heal() {
        health += 1;
    }

    @Override
    public void destroyed() {
        health -= Math.max(14.5 - ((level-1) * 6), 0.00000000001);
    }

    public String getZombieInfo() {
        return "Health = " + (int) health + "\nLevel = " + level + "\n";
    }
}
