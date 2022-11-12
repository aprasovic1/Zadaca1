package ba.unsa.etf.rpr;

import java.util.Stack;
import java.util.Scanner;

public class ExpressionEvaluator {
    double evaluate(String exp) {
        Stack<String> operator = new Stack<String>();
        Stack<Double> operand = new Stack<Double>();
//System.out.println(exp.charAt(1));

        for (int i = 0; i < exp.length(); i++) {
            String znak ;
            if (exp.charAt(i) == ' ') continue;
            else
                znak = String.valueOf(exp.charAt(i));
            if (znak.equals("(")) ;
            else if (znak.equals("+")) operator.push(znak);
            else if (znak.equals("-")) operator.push(znak);
            else if (znak.equals("*")) operator.push(znak);
            else if (znak.equals("/")) operator.push(znak);
            else if (znak.equals(")")) {
                String op = operator.pop();
                double broj = operand.pop();
                if (op.equals("+")) broj = operand.pop() + broj;
                else if (op.equals("-")) broj = operand.pop() - broj;
                else if (op.equals("*")) broj = operand.pop() * broj;
                else if (op.equals("/")) broj = operand.pop() / broj;
                operand.push(broj);
            } else operand.push(Double.parseDouble(znak));

        }


        return operand.pop();
    }
}
