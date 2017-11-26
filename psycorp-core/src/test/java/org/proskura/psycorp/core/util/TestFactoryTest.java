package org.proskura.psycorp.core.util;

import org.junit.Before;
import org.junit.Test;
import org.proskura.psycorp.core.model.Question;
import org.proskura.psycorp.core.model.TestCore;
import org.proskura.psycorp.core.model.enums.Answer;
import org.proskura.psycorp.core.model.enums.Area;
import org.proskura.psycorp.core.model.Match;
import org.proskura.psycorp.core.model.enums.Scale;

import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by User on 19.11.2017.
 */
public class TestFactoryTest {
    private TestFactory testFactory;

    @Before
    public void setUp() {
        testFactory = TestFactory.getInctance();
    }

    @Test
    public void getTestDefaultTest() throws Exception {
        org.proskura.psycorp.core.model.Test test = testFactory.getTest(new Locale(""));
        Map<Area, Set<Question>> questions = test.getQuestions();
        assertEquals(3, questions.size());
        Area[] areas = Area.values();
        Scale[] scales = Scale.values();

        for (Area area : areas) {
            String areaString = area.toString().toLowerCase();
            Set<Question> questions1 = questions.get(area);
            for (Scale scale : scales) {
                String scaleString = "";
                switch (scale) {
                    case ONE:
                        scaleString = "1";
                        break;
                    case TWO:
                        scaleString = "2";
                        break;
                    case THREE:
                        scaleString = "3";
                        break;
                    case FOUR:
                        scaleString = "4";
                        break;
                    case FIVE:
                        scaleString = "5";
                        break;
                    case SIX:
                        scaleString = "6";
                        break;
                }
                Question question = new Question(area, new Locale(""), scale, areaString + "." + scaleString);
                assertTrue(questions1.contains(question));
            }
        }
    }

    @Test
    public void getTestRuTest() throws Exception {
        org.proskura.psycorp.core.model.Test test = testFactory.getTest(new Locale("ru"));
        Map<Area, Set<Question>> questions = test.getQuestions();
        assertEquals(3, questions.size());
        Area[] areas = Area.values();
        Scale[] scales = Scale.values();

        for (Area area : areas) {
            String areaString = "";
            switch (area) {
                case GOAL:
                    areaString = "цель";
                    break;
                case STATE:
                    areaString = "качество";
                    break;
                case QUALITY:
                    areaString = "состояние";
                    break;
            }
            Set<Question> questions1 = questions.get(area);
            for (Scale scale : scales) {
                String scaleString = "";
                switch (scale) {
                    case ONE:
                        scaleString = "один";
                        break;
                    case TWO:
                        scaleString = "два";
                        break;
                    case THREE:
                        scaleString = "три";
                        break;
                    case FOUR:
                        scaleString = "четыре";
                        break;
                    case FIVE:
                        scaleString = "пять";
                        break;
                    case SIX:
                        scaleString = "шесть";
                        break;
                }
                Question question = new Question(area, new Locale("ru"), scale, areaString + "." + scaleString);
                assertTrue(questions1.contains(question));
            }
        }
    }

    @Test
    public void getTestUaTest() throws Exception {
        org.proskura.psycorp.core.model.Test test = testFactory.getTest(new Locale("ua"));
        Map<Area, Set<Question>> questions = test.getQuestions();
        assertEquals(3, questions.size());
        Area[] areas = Area.values();
        Scale[] scales = Scale.values();

        for (Area area : areas) {
            String areaString = "";
            switch (area) {
                case GOAL:
                    areaString = "ціль";
                    break;
                case STATE:
                    areaString = "якість";
                    break;
                case QUALITY:
                    areaString = "стан";
                    break;
            }
            Set<Question> questions1 = questions.get(area);
            for (Scale scale : scales) {
                String scaleString = "";
                switch (scale) {
                    case ONE:
                        scaleString = "один";
                        break;
                    case TWO:
                        scaleString = "два";
                        break;
                    case THREE:
                        scaleString = "три";
                        break;
                    case FOUR:
                        scaleString = "чотири";
                        break;
                    case FIVE:
                        scaleString = "п'ять";
                        break;
                    case SIX:
                        scaleString = "щість";
                        break;
                }
                Question question = new Question(area, new Locale("ua"), scale, areaString + "." + scaleString);
                assertTrue(questions1.contains(question));
            }
        }
    }

    @Test
    public void getTestEnTest() throws Exception {
        org.proskura.psycorp.core.model.Test test = testFactory.getTest(new Locale("en"));
        Map<Area, Set<Question>> questions = test.getQuestions();
        assertEquals(3, questions.size());
        Area[] areas = Area.values();
        Scale[] scales = Scale.values();

        for (Area area : areas) {
            String areaString = "";
            switch (area) {
                case GOAL:
                    areaString = "goal";
                    break;
                case STATE:
                    areaString = "quality";
                    break;
                case QUALITY:
                    areaString = "state";
                    break;
            }
            Set<Question> questions1 = questions.get(area);
            for (Scale scale : scales) {
                String scaleString = "";
                switch (scale) {
                    case ONE:
                        scaleString = "one";
                        break;
                    case TWO:
                        scaleString = "two";
                        break;
                    case THREE:
                        scaleString = "three";
                        break;
                    case FOUR:
                        scaleString = "four";
                        break;
                    case FIVE:
                        scaleString = "five";
                        break;
                    case SIX:
                        scaleString = "six";
                        break;
                }
                Question question = new Question(area, new Locale("en"), scale, areaString + "." + scaleString);
                assertTrue(questions1.contains(question));
            }
        }
    }

    @Test
    public void getTestWithTestCore() throws Exception {
        TestCore testCore = TestFactory.getTestCore();
        testCore.setId(1);

        Iterator<Match> iterator = testCore.getMatches().iterator();
        while (iterator.hasNext()) {
            iterator.next().setAnswer(Answer.FIRST);
        }

        org.proskura.psycorp.core.model.Test test = testFactory.getTest(testCore, new Locale("ru"));

        assertEquals(1, test.getId());

        Iterator<Match> iterator1 = test.getMatches().iterator();
        while (iterator1.hasNext()) {
            assertEquals(Answer.FIRST, iterator1.next().getAnswer());
        }
    }

    @Test
    public void getTestCoreTest() throws Exception {
        TestCore testCore = TestFactory.getTestCore();
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