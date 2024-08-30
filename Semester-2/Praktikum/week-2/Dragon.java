public class Dragon {
    int x, y;
    int width, height;

    public Dragon(int height, int width) {
        this.height = height;
        this.width = width;
        x = width / 2;
        y = height / 2;
    }

    void moveLeft() {
        x -= 1;
        if(x < 0 || x > width){
            detectCollision(x, y);
        }
    }

    void moveRight() {
        x += 1;
        if(x < 0 || x > width){
            detectCollision(x, y);
        }
    }

    void moveUp() {
        y -= 1;
        if(y < 0 || y > height){
            detectCollision(x, y);
        }
    }

    void moveDown() {
        y += 1;
        if(y < 0 || y > height){
            detectCollision(x, y);
        }
    }

    void printPosition() {
        System.out.println("Posisi: (" + x + ", " + y + ")");
    }

    void detectCollision(int x, int y) {
        System.out.println("Collision detected!\nGAME OVER!");
        System.exit(0);
    }

}
