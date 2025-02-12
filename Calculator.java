import java.math.BigInteger;
import java.util.Scanner;

public class LargeNumberCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first large number:");
        BigInteger num1 = new BigInteger(scanner.nextLine());

        System.out.println("Enter second large number:");
        BigInteger num2 = new BigInteger(scanner.nextLine());

        System.out.println("Choose operation (+, -, *):");
        char operation = scanner.next().charAt(0);

        BigInteger result;
        switch (operation) {
            case '+':
                result = num1.add(num2);
                break;
            case '-':
                result = num1.subtract(num2);
                break;
            case '*':
                result = num1.multiply(num2);
                break;
            default:
                System.out.println("Invalid operation!");
                scanner.close();
                return;
        }

        System.out.println("Result: " + result);
        scanner.close();
    }
}
