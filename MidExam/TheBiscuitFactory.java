import java.util.Scanner;

import static java.lang.Math.abs;

public class TheBiscuitFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input values
        int biscuitsPerWorkerPerDay = Integer.parseInt(scanner.nextLine());
        int workersCount = Integer.parseInt(scanner.nextLine());
        int competitorProduction = Integer.parseInt(scanner.nextLine());

        int totalBiscuits = 0;


        for (int day = 1; day <= 30; day++)
        {
            if (day % 3 == 0)
            {
                totalBiscuits += (biscuitsPerWorkerPerDay * workersCount * 0.75);
            } else {
                totalBiscuits += biscuitsPerWorkerPerDay * workersCount;
            }
        }

        System.out.println("You have produced " + totalBiscuits + " biscuits for the past month.");

        double difference = ((double) totalBiscuits - competitorProduction) / competitorProduction * 100;
        double result = Math.round(Math.abs(difference) * 100) / 100.0;

        System.out.println("You produce " + result + " percent " + (totalBiscuits > competitorProduction ? "more" : "less") + " biscuits.");


    }
}
