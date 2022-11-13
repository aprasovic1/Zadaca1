package ba.unsa.etf.rpr;


public class App 
{
    public static void main( String[] args )
    {

        ExpressionEvaluator ex;
        ex = new ExpressionEvaluator();
        for(int i=0;i<args.length;i++)
        System.out.println(args[i]);
    }
}
