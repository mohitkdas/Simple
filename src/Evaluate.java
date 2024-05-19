import java.util.Scanner;
import java.util.Stack;

public class Evaluate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> ops =  new Stack<>();
        Stack<Double> vals = new Stack<>();

        while (sc.hasNext()) {
            String s = sc.next();
            switch (s) {
                case "(" -> {}
                case "+", "-", "*", "/", "sqrt" -> ops.push(s);
                case ")" -> {
                    String op = ops.pop();
                    double v = vals.pop();
                    v = switch (op) {
                        case "+" -> vals.pop() + v;
                        case "-" -> vals.pop() - v;
                        case "*" -> vals.pop() * v;
                        case "/" -> vals.pop() / v;
                        case "sqrt" -> Math.sqrt(v);
                        default -> v;
                    };
                    vals.push(v);
                }
                default -> vals.push(Double.parseDouble(s));
            }
        }
        System.out.println(vals.pop());
    }
}
