
import java.util.Scanner;

public class TheAngryCat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int[] items = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            items[i] = Integer.parseInt(input[i]);
        }

        int entryPoint = Integer.parseInt(scanner.nextLine());
        String itemType = scanner.nextLine();

        int entryValue = items[entryPoint];
        int leftDamage = 0;
        int rightDamage = 0;

        for (int i = 0; i < entryPoint; i++) {
            if ((itemType.equals("cheap") && items[i] < entryValue) ||
                    (itemType.equals("expensive") && items[i] >= entryValue)) {
                leftDamage += items[i];
            }
        }

        for (int i = entryPoint + 1; i < items.length; i++) {
            if ((itemType.equals("cheap") && items[i] < entryValue) ||
                    (itemType.equals("expensive") && items[i] >= entryValue)) {
                rightDamage += items[i];
            }
        }

        if (leftDamage >= rightDamage) {
            System.out.println("Left - " + leftDamage);
        } else {
            System.out.println("Right - " + rightDamage);
        }
    }
}