package ba.unsa.etf.rpr;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExpressionEvaulatorTest {
    @Test
    public void a(){
        //( 3 + ) 5 * ( 7 - 3 ) ) )
        String[] input= {"(", "+", ")", "5", "*", "(", "7", "-", "3", ")", ")", ")"};
assertThrows(RuntimeException.class,()->ba.unsa.etf.rpr.App.main(input));
    }

    @Test
    public void b(){

        String input= "( 3 + ( 5 * ( 7 - 3 ) ) )";
        assertEquals (23.0,new ba.unsa.etf.rpr.ExpressionEvaluator().evaluate(input));
    }
    @Test
    public void c(){

        String input= "( 1 + ( 5 * 20 ) )";
        assertEquals (101.0,new ba.unsa.etf.rpr.ExpressionEvaluator().evaluate(input));
    }

    @Test
    public void d(){

        String input= "( 6 - ( 6 / 2 ) )";
        assertEquals (3.0,new ba.unsa.etf.rpr.ExpressionEvaluator().evaluate(input));
    }

    @Test
    public void e(){

        String input= "( sqrt ( 4 )  + ( 5 * ( 7 - 3 ) ) )";
        assertEquals (22.0,new ba.unsa.etf.rpr.ExpressionEvaluator().evaluate(input));
    }


}
