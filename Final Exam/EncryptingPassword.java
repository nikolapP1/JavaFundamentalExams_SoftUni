package Exam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EncryptingPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String regex = "^(?<symbols>[^a-zA-Z0-9]*)>(?<numbers>\\d{3})\\|(?<lower>[a-z]{3})\\|(?<upper>[A-Z]{3})\\|(?<special>[^<>]{3})<\\k<symbols>$";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.matches()) {
                String encryptedPassword = matcher.group("numbers") + matcher.group("lower") + matcher.group("upper") + matcher.group("special");
                System.out.println("Password: " + encryptedPassword);
            } else {
                System.out.println("Try another password!");
            }
        }
    }
}

