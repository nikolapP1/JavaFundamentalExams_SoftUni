package Exam;

import java.util.*;

public class HeroRecruitment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> heroes = new LinkedHashMap<>();

        while (true) {
            String command = scanner.nextLine();
            if (command.equals("End")) {
                break;
            }

            String[] tokens = command.split(" ");
            String action = tokens[0];
            String heroName = tokens[1];

            switch (action) {
                case "Enroll":
                    if (heroes.containsKey(heroName)) {
                        System.out.println(heroName + " is already enrolled.");
                    } else {
                        heroes.put(heroName, new ArrayList<>());
                    }
                    break;

                case "Learn":
                    String spellName = tokens[2];
                    if (!heroes.containsKey(heroName)) {
                        System.out.println(heroName + " doesn't exist.");
                    } else if (heroes.get(heroName).contains(spellName)) {
                        System.out.println(heroName + " has already learnt " + spellName + ".");
                    } else {
                        heroes.get(heroName).add(spellName);
                    }
                    break;

                case "Unlearn":
                    spellName = tokens[2];
                    if (!heroes.containsKey(heroName)) {
                        System.out.println(heroName + " doesn't exist.");
                    } else if (!heroes.get(heroName).contains(spellName)) {
                        System.out.println(heroName + " doesn't know " + spellName + ".");
                    } else {
                        heroes.get(heroName).remove(spellName);
                    }
                    break;
            }
        }

        System.out.println("Heroes:");
        for (Map.Entry<String, List<String>> entry : heroes.entrySet()) {
            System.out.print("== " + entry.getKey() + ": ");
            System.out.println(entry.getValue().isEmpty() ? "" : String.join(", ", entry.getValue()));
        }
    }
}

