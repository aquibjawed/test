import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

// Strategy Interface
interface Operation {
    double execute(double a, double b);
}

// Concrete Strategies
class Addition implements Operation {
    public double execute(double a, double b) {
        return a + b;
    }
}

class Subtraction implements Operation {
    public double execute(double a, double b) {
        return a - b;
    }
}

class Multiplication implements Operation {
    public double execute(double a, double b) {
        return a * b;
    }
}

class Division implements Operation {
    public double execute(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return Double.NaN;
        }
        return a / b;
    }
}

// Context Class
class Calculator {
    private Operation operation;
    private static final Map<String, Operation> operations = new HashMap<>();
    
    static {
        operations.put("+", new Addition());
        operations.put("-", new Subtraction());
        operations.put("*", new Multiplication());
        operations.put("/", new Division());
    }

    public void setOperation(String operator) {
        this.operation = operations.get(operator);
    }

    public double executeOperation(double a, double b) {
        return operation.execute(a, b);
    }

    public static boolean isValidOperator(String operator) {
        return operations.containsKey(operator);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        
        System.out.println("Simple Calculator");
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        
        System.out.print("Enter an operator (+, -, *, /): ");
        String operator = scanner.next();
        
        if (!isValidOperator(operator)) {
            System.out.println("Invalid operator!");
            return;
        }
        
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();
        
        calculator.setOperation(operator);
        double result = calculator.executeOperation(num1, num2);
        System.out.println("Result: " + result);
        scanner.close();
    }
}
