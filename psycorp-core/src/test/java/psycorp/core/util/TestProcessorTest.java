package psycorp.core.util;

import org.junit.Before;
import org.junit.Test;
import psycorp.core.model.Match;
import psycorp.core.model.TestCore;
import psycorp.core.model.TestResult;
import psycorp.core.model.enums.Answer;
import psycorp.core.model.enums.Area;
import psycorp.core.model.enums.Scale;

import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

/**
 * Created by User on 21.11.2017.
 */
public class TestProcessorTest {

    psycorp.core.model.Test test;

    @Before
    public void setUp() throws Exception {
        test = TestFactory.getTest(new Locale(""));

    }

    @Test
    public void isPassedTest() throws Exception {
        assertFalse(TestProcessor.isPassed(test));
        fillTest(test);
        assertTrue(TestProcessor.isPassed(test));

        Set<Match> matches = test.getMatches();
        Iterator<Match> iterator = matches.iterator();
        iterator.next().setAnswer(Answer.NAN);
        assertFalse(TestProcessor.isPassed(test));
    }

    @Test
    public void countTestTest() {
        assertNull(TestProcessor.countTest(test));
        fillTest(test);

        TestResult testResult = TestProcessor.countTest(test);
        assertReflectionEquals (test, testResult.getTestCore());
        Map<Area, Map<Scale, Integer>> testResultMap = testResult.getTestResultMap();
        assertEquals(3, testResultMap.keySet().size());
        for (Area area : Area.values()) {
            Map<Scale, Integer> scaleIntegerMap = testResultMap.get(area);
            assertEquals(6, scaleIntegerMap.keySet().size());

            assertEquals(5, (int)scaleIntegerMap.get(Scale.ONE));
            assertEquals(4, (int)scaleIntegerMap.get(Scale.TWO));
            assertEquals(3, (int)scaleIntegerMap.get(Scale.THREE));
            assertEquals(2, (int)scaleIntegerMap.get(Scale.FOUR));
            assertEquals(1, (int)scaleIntegerMap.get(Scale.FIVE));
            assertEquals(0, (int)scaleIntegerMap.get(Scale.SIX));
        }
    }

    private static void fillTest(TestCore test) {
        test.getMatches().stream().forEach(match -> match.setAnswer(Answer.FIRST));
    }

}