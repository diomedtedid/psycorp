package psycorp.core.model;

import org.junit.*;
import org.junit.Test;
import psycorp.core.model.enums.Area;
import psycorp.core.model.enums.Scale;

import java.util.Locale;

import static org.junit.Assert.*;

/**
 * Created by User on 12.11.2017.
 */
public class QuestionTest {
    private Question question1;
    private Question question2;

    @Before
    public void setUp() throws Exception {
        question1 = new Question(Area.GOAL, Locale.ENGLISH, Scale.ONE, "one");
        question2 = new Question(Area.GOAL, Locale.ENGLISH, Scale.ONE, "one");
    }

    @Test
    public void equalsTest() throws Exception {
    }

    @Test
    public void hashCodeTest() throws Exception {
    }

}