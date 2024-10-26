package Tugas;

public class WalkingZombie extends Zombie {
    public WalkingZombie(int health, int level) {
        this.health = health;
        this.level = level;
    }

    @Override
    public void heal() {
        health += health * switch (level) {
            case 1 -> 0.1;
            case 2 -> 0.3;
            case 3 -> 0.4;
            default -> 0;
        };
    }

    @Override
    public void destroyed() {
        health -= health * 0.183;
    }

    @Override
    public String getZombieInfo() {
        return "Walking Zombie Data =\n" + super.getZombieInfo();
    }
}
