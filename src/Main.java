/**
 * Created by tdrs on 1/10/16.
 */
public class Main {


    public static void main(String[] args) {
        Neighborhood neighborhood = new Neighborhood();
        RuleNinety ruleNinety = new RuleNinety();
        RuleThirty ruleThirty = new RuleThirty();
        String[] vector = neighborhood.evolve("00000000000000000000000000000000000000000000000001000000000000000000000000000000000000000000000000",ruleNinety,25);
        System.out.print(neighborhood.toString(vector));
    }


}
