package psycorp.core.util;

import org.junit.Before;
import org.junit.Test;
import psycorp.core.model.Match;
import psycorp.core.model.enums.Answer;

import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

import static org.junit.Assert.*;

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
    public void isPassed() throws Exception {
        assertFalse(TestProcessor.isPassed(test));
        test.getMatches().stream().forEach(match -> match.setAnswer(Answer.FIRST));
        assertTrue(TestProcessor.isPassed(test));

        Set<Match> matches = test.getMatches();
        Iterator<Match> iterator = matches.iterator();
        iterator.next().setAnswer(Answer.NAN);
        assertFalse(TestProcessor.isPassed(test));
    }

}