import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class NeighborhoodShoul {

    private final Neighborhood neighborhood = new Neighborhood();
    private final RuleThirty ruleThirty = new RuleThirty();
    private final RuleNinety ruleNinety = new RuleNinety();


    @Test
    public void evolveCurrentStateWithStringWithLengthOne (){
        assertArrayEquals(new String[] {"0", "1"}, neighborhood.evolve("0", ruleThirty, 1));
    }

    @Test
    public void evolveCurrentStateWithStringWithLengthTwo(){
        assertArrayEquals(new String[] {"01", "11"}, neighborhood.evolve("01", ruleThirty, 1));
    }

    @Test
    public void evolveCurrentStateTwiceWithStringWithLengthTwo(){
        assertArrayEquals(new String[] {"01", "11", "10"}, neighborhood.evolve("01", ruleThirty, 2));
    }

    @Test
    public void giveTheCorrectString (){
        String expectedString = " X\nXX\nX \n";
        String [] result = neighborhood.evolve("01", ruleNinety, 2);
        assertEquals(expectedString, neighborhood.toString(result));
    }

    @Test
    public void giveTheCorrectStringFinal (){
        String expectedString = " X\nXX\nX \n";
        String [] result = neighborhood.evolve("000000000000000000000000000000000000000000000000010000000000000000" +
                "00000000000000000000000000000000", ruleNinety, 2);
        assertEquals(expectedString, neighborhood.toString(result));
    }

    @Test
    public void foo (){
        String source = "00000000000000000000000000000000000000000000000001000000000000000000000000000000000000000000000000";
        String f = source.replaceAll("0", " ");
        String firstElement = f.replaceAll("1", "X");
        String[] result2 = neighborhood.evolve(source, ruleNinety, 1);
        String secondElement = result2[1].replaceAll("0", " ").replaceAll("1", "X");

        assertEquals(firstElement + "\n" + secondElement + "\n", neighborhood.toString(result2));
    }
}

