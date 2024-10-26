package Tugas;

public class JumpingZombie extends Zombie {
    public JumpingZombie(int health, int level) {
        this.health = health;
        this.level = level;
    }

    @Override
    public void heal() {
        health += health * switch (level) {
            case 1 -> 0.3;
            case 2 -> 0.4;
            case 3 -> 0.5;
            default -> 0;
        };
    }

    @Override
    public void destroyed() {
        health -= health * 0.0979;
    }

    @Override
    public String getZombieInfo() {
        return "Jumping Zombie Data =\n" + super.getZombieInfo();
    }
}
