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
    TestFactory testFactory;

    @Before
    public void setUp() throws Exception {
        this.testFactory = TestFactory.getInctance();
        test = testFactory.getTest(new Locale(""));

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
        Map<Scale, Integer> testProfile = testResult.getTestProfile();

            assertEquals(6, testProfile.keySet().size());

            assertEquals(15, (int)testProfile.get(Scale.ONE));
            assertEquals(12, (int)testProfile.get(Scale.TWO));
            assertEquals(9, (int)testProfile.get(Scale.THREE));
            assertEquals(6, (int)testProfile.get(Scale.FOUR));
            assertEquals(3, (int)testProfile.get(Scale.FIVE));
            assertEquals(0, (int)testProfile.get(Scale.SIX));


        assertEquals(testResult, test.getTestResult());

    }

    private static void fillTest(TestCore test) {
        test.getMatches().stream().forEach(match -> match.setAnswer(Answer.FIRST));
    }

}