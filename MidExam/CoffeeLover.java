import java.util.*;

public class CoffeeLover {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> coffees = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" ")));
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] commandParts = scanner.nextLine().split(" ");
            String command = commandParts[0];

            if (command.equals("Include")) {
                coffees.add(commandParts[1]);
            } else if (command.equals("Remove")) {
                String position = commandParts[1];
                int count = Integer.parseInt(commandParts[2]);
                if (count <= coffees.size()) {
                    if (position.equals("first")) {
                        coffees.subList(0, count).clear();
                    } else {
                        coffees.subList(coffees.size() - count, coffees.size()).clear();
                    }
                }
            } else if (command.equals("Prefer")) {
                int index1 = Integer.parseInt(commandParts[1]);
                int index2 = Integer.parseInt(commandParts[2]);
                if (index1 >= 0 && index1 < coffees.size() && index2 >= 0 && index2 < coffees.size()) {
                    String temp = coffees.get(index1);
                    coffees.set(index1, coffees.get(index2));
                    coffees.set(index2, temp);
                }
            } else if (command.equals("Reverse")) {
                Collections.reverse(coffees);
            }
        }

        System.out.println("Coffees:");
        for (String coffee : coffees) {
            System.out.print(coffee + " ");
        }
    }
}
