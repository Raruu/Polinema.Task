import java.util.Scanner;

public class DragonMain {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Height size: ");
        int height = scanner.nextInt();
        System.out.print("Enter Width size: ");
        int width = scanner.nextInt();
        scanner.nextLine();
        Dragon dragon = new Dragon(height, width);
        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("W/A/S/D + Enter to Move");
            System.out.println("Map Size (Height, Width): (" + height + ", " + width + ")");            
            dragon.printPosition();
            String input = scanner.next();
            if (input.equalsIgnoreCase("w")) {
                dragon.moveUp();
            }
            if (input.equalsIgnoreCase("a")) {
                dragon.moveLeft();
            }
            if (input.equalsIgnoreCase("s")) {
                dragon.moveDown();
            }
            if (input.equalsIgnoreCase("d")) {
                dragon.moveRight();
            }
        }

    }
}
