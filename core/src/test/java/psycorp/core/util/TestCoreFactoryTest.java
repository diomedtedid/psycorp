package psycorp.core.util;

import org.junit.Before;
import org.junit.Test;
import psycorp.core.model.Match;
import psycorp.core.model.TestCore;
import psycorp.core.model.enums.Answer;
import psycorp.core.model.enums.Area;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by User on 12.11.2017.
 */
public class TestCoreFactoryTest {

    private TestCore testCore;

    @Before
    public void setUp() throws Exception {
        this.testCore = TestCoreFactory.getTest();
    }

    @Test
    public void getTestTest() throws Exception {
        Set<Match> matches = testCore.getMatches();

        assertEquals(45, matches.size());

        assertTrue(matches.stream().noneMatch(match -> match.getId() != 0));

        long answerCount = matches.stream().filter(match -> match.getAnswer()== Answer.NAN).count();
        assertEquals(45, answerCount);

        long goalAreaCount = matches.stream().filter(match -> match.getArea() == Area.GOAL).count();
        assertEquals(15, goalAreaCount);

        long qualityAreaCount = matches.stream().filter(match -> match.getArea() == Area.QUALITY).count();
        assertEquals(15, qualityAreaCount);

        long stateAreaCount = matches.stream().filter(match -> match.getArea() == Area.STATE).count();
        assertEquals(15, stateAreaCount);
    }

}