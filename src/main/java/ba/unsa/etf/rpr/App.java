package ba.unsa.etf.rpr;


import java.util.Arrays;

/**
 * Class App only has one method Main
 * @author aprasovic1
 */
public class App {
    /**
     * Method Main is parsing array of arithmetic operators and numbers from console, saved in String[] args,
     * validating it, and building a string of those operators and numbers so that each
     * character or operation "sqrt" is separated by a space.
     * <p>
     * Then it prints a computed value of given expression.
     *
     *
     */
    public static void main(String[] args) {
       // if(args.length<3) throw new RuntimeException("Izraz nije validan1");
        String operacije = new String("+-*/");

        // System.out.println("'"+args[0]+"'"+args[args.length-1]+"'");
        //( sqrt ( 4 ) + ( 7 * 2.54 ) )
        if (!args[0].equals("(") || !args[args.length - 1].equals(")"))
            throw new RuntimeException("Izraz nije validan2");

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("(") && (operacije.contains(args[i + 1]) ))
                throw new RuntimeException("Izraz nije validan3");
            else if(operacije.contains(args[i]) &&operacije.contains(args[i+1]))
                throw new RuntimeException("Izraz nije validan4");
            else if(!args[i].equals("(")&&!args[i].equals(")") &&!operacije.contains(args[i]) && !args[i].equals("sqrt")) {
                try {
                    Double.parseDouble(args[i]);
                } catch (NumberFormatException nfe) {
                    throw new RuntimeException("Izraz nije validan5");
                }

            }

        }

        StringBuilder s1 = new StringBuilder();
int otvorene=0,zatvorene=0;
        for (String arg : args) {
            s1.append(arg).append(' ');
            if(arg.equals("(")) otvorene++;
            else if(arg.equals(")")) zatvorene++;
        }
        if(otvorene!=zatvorene) throw new RuntimeException("Izraz nije validan6");


        ExpressionEvaluator ex = new ExpressionEvaluator();
        System.out.println(ex.evaluate(s1.toString()));

    }
}
