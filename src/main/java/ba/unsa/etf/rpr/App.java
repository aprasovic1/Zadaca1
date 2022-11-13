package ba.unsa.etf.rpr;




public class App
{
    public static void main( String[] args )
    {


        StringBuilder s1=new StringBuilder();

        for (String arg : args) s1.append(arg).append(' ');
        ExpressionEvaluator ex= new ExpressionEvaluator();
        System.out.println(ex.evaluate(s1.toString()));
    }
}
