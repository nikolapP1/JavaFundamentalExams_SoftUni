package Exam;

import java.util.Scanner;

public class DecryptingCommands {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String command;

        while (!(command = scanner.nextLine()).equals("Finish")) {
            String[] commandAction = command.split(" ");

            switch (commandAction[0]) {
                case "Replace":
                    char currentChar = commandAction[1].charAt(0);
                    char newChar = commandAction[2].charAt(0);
                    input = input.replace(currentChar, newChar);
                    System.out.println(input);
                    break;

                case "Cut":
                    int startIndex = Integer.parseInt(commandAction[1]);
                    int endIndex = Integer.parseInt(commandAction[2]);
                    if (isValidIndex(startIndex, input) && isValidIndex(endIndex, input) && startIndex <= endIndex) {
                        input= input.substring(0, startIndex) + input.substring(endIndex + 1);
                        System.out.println(input);
                    } else {
                        System.out.println("Invalid indices!");
                    }
                    break;

                case "Make":
                    if (commandAction[1].equals("Upper")) {
                        input = input.toUpperCase();
                    } else if (commandAction[1].equals("Lower")) {
                        input = input.toLowerCase();
                    }
                    System.out.println(input);
                    break;

                case "Check":
                    String substring = commandAction[1];
                    if (input.contains(substring)) {
                        System.out.println("Message contains " + substring);
                    } else {
                        System.out.println("Message doesn't contain " + substring);
                    }
                    break;

                case "Sum":
                    int sumStartIndex = Integer.parseInt(commandAction[1]);
                    int sumEndIndex = Integer.parseInt(commandAction[2]);
                    if (isValidIndex(sumStartIndex, input) && isValidIndex(sumEndIndex, input) && sumStartIndex <= sumEndIndex) {
                        int sum = 0;
                        for (int i = sumStartIndex; i <= sumEndIndex; i++) {
                            sum += input.charAt(i);
                        }
                        System.out.println(sum);
                    } else {
                        System.out.println("Invalid indices!");
                    }
                    break;

                default:
                    System.out.println("Invalid command!");
            }
        }
    }

    private static boolean isValidIndex(int index, String input) {
        return index >= 0 && index < input.length();
    }
}
