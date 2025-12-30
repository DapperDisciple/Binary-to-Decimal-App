import java.util.Scanner;

/*
 * Project: Bin2Dec (Binary to Decimal Converter)
 *
 * Author: NaDear Raymond
 * Date Created: December 30, 2025
 *
 * Copyright (c) 2025 NaDear Raymond
 *
 * Permission is granted to view, use, and modify this code
 * for personal, educational, or non-commercial purposes.
 *
 * This code may NOT be claimed as original work by anyone
 * other than the author listed above.
 *
 * If this code is reused or referenced, proper credit
 * must be given to NaDear Raymond.
 *
 * Description:
 * This program allows a user to enter a binary number (base 2)
 * and converts it into a decimal number (base 10).
 *
 * Rules followed:
 * - No arrays are used
 * - Only 0 and 1 are accepted as valid input
 * - Each binary digit is converted using a single math function (Math.pow)
 *
 * This project was created for learning purposes and to practice
 * understanding how binary numbers work.
 */

public class Bin2Dec {

    // Maximum number of binary digits allowed
    private static final int MAX_BINARY_LENGTH = 8;

    public static void main(String[] args) {
        // Scanner reads user input from the console
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Bin2Dec ===");
        System.out.println("Enter a binary number (up to 8 digits).");
        System.out.println("Only 0 and 1 are allowed.");
        System.out.println("Type 'quit' to exit.\n");

        while (true) {
            System.out.print("Enter binary: ");
            String input = scanner.nextLine().trim();

            // Allows the user to exit the program
            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Goodbye!");
                break;
            }

            // Check if the user entered anything
            if (input.length() == 0) {
                System.out.println("Error: No input entered.\n");
                continue;
            }

            // Check if the input is too long
            if (input.length() > MAX_BINARY_LENGTH) {
                System.out.println("Error: Maximum length is 8 digits.\n");
                continue;
            }

            // Validate that the input is binary
            if (!isValidBinary(input)) {
                System.out.println("Error: Only 0 and 1 are allowed.\n");
                continue;
            }

            // Convert binary to decimal and display result
            int decimalValue = binaryToDecimal(input);
            System.out.println("Decimal value: " + decimalValue + "\n");
        }

        // Close the scanner to free system resources
        scanner.close();
    }

    /*
     * Checks if the given string contains only
     * the characters '0' or '1'.
     */
    private static boolean isValidBinary(String binary) {
        for (int i = 0; i < binary.length(); i++) {
            char currentChar = binary.charAt(i);

            if (currentChar != '0' && currentChar != '1') {
                return false;
            }
        }
        return true;
    }

    /*
     * Converts a binary number into its decimal value.
     *
     * Example:
     * Binary: 1011
     * Math:
     * 1 × 2³ + 0 × 2² + 1 × 2¹ + 1 × 2⁰ = 11
     */
    private static int binaryToDecimal(String binary) {
        int result = 0;

        // The leftmost digit has the highest power of 2
        int exponent = binary.length() - 1;

        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                result += (int) Math.pow(2, exponent);
            }
            exponent--;
        }

        return result;
    }
}
