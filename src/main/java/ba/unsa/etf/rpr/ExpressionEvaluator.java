package ba.unsa.etf.rpr;

import java.util.Stack;
import java.util.Scanner;


/**
 * Class ExpressionEvaluator has only one
 * method "evaluate"
 * @author aprasovic1
 */
public class ExpressionEvaluator {

    /**
     * <p>Method evaluate computes the value of an arithmetic expression</p>
     * @param exp arithmetic expression as a string
     * @return computed value of an arithmetic expression
     *
     *
     */
    protected double evaluate(String exp) {
        Stack<String> operator = new Stack<String>();
        Stack<Double> operand = new Stack<Double>();



        for (int i = 0; i < exp.length(); i++) {
            String znak ;
            if (exp.charAt(i) == ' ') continue;
            else {
                int razmak = exp.indexOf(' ', i);
                znak = exp.substring(i,razmak);
                i=razmak;
            }

            if (znak.equals("(")) ;
            else if (znak.equals("+")) operator.push(znak);
            else if (znak.equals("-")) operator.push(znak);
            else if (znak.equals("*")) operator.push(znak);
            else if (znak.equals("/")) operator.push(znak);
            else if (znak.equals("sqrt")) operator.push(znak);
            else if (znak.equals(")")) {
                String op = operator.pop();
                double broj = operand.pop();
                if (op.equals("+")) broj = operand.pop() + broj;
                else if (op.equals("-")) broj = operand.pop() - broj;
                else if (op.equals("*")) broj = operand.pop() * broj;
                else if (op.equals("/")) broj = operand.pop() / broj;
                else if (op.equals("sqrt")) broj = Math.sqrt(broj);
                operand.push(broj);
                if(i==exp.length()-1 && !operator.isEmpty())i-=2;
            } else operand.push(Double.parseDouble(znak));

        }


        return operand.pop();
    }
}
