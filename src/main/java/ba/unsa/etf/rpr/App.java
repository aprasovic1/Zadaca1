package ba.unsa.etf.rpr;

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
     */



    public static void main(String[] args) {
        if(args[0].length()<1) throw new RuntimeException("Izraz nije validan1");


        String operacije = "+-*/sqrt";
        String izraz=args[0];
       int brOtvorenih=0,brZatvorenih=0; //zagrade
        String prethodni="";
        for(int i=0;i<izraz.length();i++){
            String znak ;
            if (izraz.charAt(i) == ' ') continue;
            else {

                int razmak = Math.max(izraz.indexOf(' ', i),i+1) ;//Na kraju nema razmaka pa stavlja da je "razmak" na sljedecem
                znak = izraz.substring(i, razmak);                    //indeksu zbog funkcije substr
                i = razmak;
            }
            boolean bacenExc=false;

            try{//probaj da li su oba znaka brojevi
                Double.parseDouble(znak);
                Double.parseDouble(prethodni);
            }
            catch (Exception e){
                //ako bar jedan znak nije broj desit ce se sljedeca naredba
                bacenExc=true;}
            //ako su oba brojevi, ili oba operatori , baci exception
            if(!bacenExc || (operacije.contains(znak)&&operacije.contains(prethodni))) throw new RuntimeException("Izraz nije validan2");


            if(znak.equals(prethodni)&&!znak.equals("(")&&!znak.equals(")"))
                throw new RuntimeException("Izraz nije validan3");

            if(znak.equals("(")) brOtvorenih++;
            else if(znak.equals(")"))brZatvorenih++;
            System.out.println("'"+znak+"'");
            prethodni=znak;
        }

        if (izraz.charAt(0)!='('  || izraz.charAt(izraz.length()-1)!=')' || brOtvorenih!=brZatvorenih)
            throw new RuntimeException("Izraz nije validan4");


        ExpressionEvaluator ex = new ExpressionEvaluator();
        System.out.println(ex.evaluate(izraz));

    }
}
