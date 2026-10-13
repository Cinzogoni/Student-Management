package utils;

import java.time.LocalDate;
import java.util.Scanner;

public class Utils {

    /*Mo ta tham so:
    1. desc: mo ta noi dung nhap
    2. mode: 
        + Aa - Ko dc rong
        + Bb - Cho phep bo qua khi Enter
        + Cc - Giu gia tri mac dinh
    3. defaultValue: dung cho mode Cc (Dung cho Update)
     */
    public static String checkInputString(String desc, Scanner scan,
            String mode, String defaultValue) {

        while (true) {
            System.out.print(desc);
            String input = scan.nextLine().trim();

            if (input.isEmpty()) {
                if ("Aa".equalsIgnoreCase(mode)) {
                    System.out.println("Khong duoc de trong!");
                    continue;
                } else if ("Bb".equalsIgnoreCase(mode)) {
                    return null;
                } else if ("Cc".equalsIgnoreCase(mode)) {
                    return defaultValue;
                }
            }

            return input;
        }
    }

    public static LocalDate checkInputDOB(String desc, Scanner scan,
            String mode, LocalDate defaultValue) {

        while (true) {
            System.out.print(desc);
            String input = scan.nextLine().trim();

            if (input.isEmpty()) {
                if ("dobA".equalsIgnoreCase(mode)) {
                    System.out.println("Khong duoc de trong!");
                    continue;
                } else if ("dobB".equalsIgnoreCase(mode)) {
                    return defaultValue;
                }
            }

            if (Validates.isValidDate(input)) {
                return LocalDate.parse(input, Validates.FMT);
            }
            System.out.println("Ngay sinh khong hop le!");
        }
    }

    public static double checkInputGPA(String desc, Scanner scan,
            String mode, double defaultValue) {

        while (true) {
            System.out.print(desc);
            String input = scan.nextLine().trim();

            if (input.isEmpty()) {
                if ("GPAa".equalsIgnoreCase(mode)) {
                    System.out.println("Khong duoc de trong!");
                    continue;
                } else if ("GPAb".equalsIgnoreCase(mode)) {
                    return defaultValue;
                }
            }

            try {
                double gpa = Double.parseDouble(input);

                if (Validates.isValidGPA(gpa)) {
                    return gpa;
                }
                System.out.println("Chua dung!");

            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so!");
            }
        }
    }
}
