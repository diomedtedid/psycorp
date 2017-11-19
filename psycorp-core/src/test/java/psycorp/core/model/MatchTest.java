package psycorp.core.model;

import org.junit.*;
import psycorp.core.model.enums.Answer;
import psycorp.core.model.enums.Area;
import psycorp.core.model.enums.Pair;
import psycorp.core.model.enums.Scale;

import static org.junit.Assert.*;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

/**
 * Created by User on 12.11.2017.
 */
public class MatchTest {
    private Match match1;
    private Match match2;

    @Before
    public void setUp() throws Exception {
        match1 = new Match(Area.GOAL, Pair.ONE_TWO);
        match2 = new Match(Area.GOAL, Pair.ONE_TWO);
    }

    @org.junit.Test
    public void creationTest() {
        assertEquals(0, match1.getId());
        match1.setId(1);
        assertEquals(1, match1.getId());


        assertEquals(Area.GOAL, match1.getArea());
        assertEquals(Answer.NAN, match1.getAnswer());
        match1.setAnswer(Answer.FIRST);
        assertEquals(Answer.FIRST, match1.getAnswer());

        assertEquals(Pair.ONE_TWO, match1.getPair());
        assertEquals(Scale.ONE, match1.getPair().getFirstScale());
        assertEquals(Scale.TWO, match1.getPair().getSecondScale());
    }

    @org.junit.Test
    public void equalsTest() throws Exception {
        assertEquals(match1, match2);
        assertReflectionEquals(match1, match2);
        assertTrue(match1.equals(match2));
        match2.setId(1L);
        assertFalse(match1.equals(match2));
    }

    @org.junit.Test
    public void hashCodeTest() throws Exception {
        assertEquals(match1.hashCode(), match2.hashCode());
        match2.setId(2L);
        assertEquals(match1.hashCode(), match2.hashCode());
        match2.setAnswer(Answer.FIRST);
        assertEquals(match1.hashCode(), match2.hashCode());
    }

}