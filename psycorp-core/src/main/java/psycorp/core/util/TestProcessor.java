package psycorp.core.util;

import psycorp.core.model.TestCore;
import psycorp.core.model.enums.Answer;

/**
 * Created by User on 19.11.2017.
 */
public class TestProcessor {
    public static boolean isPassed (TestCore test) {
        return test.getMatches().stream().noneMatch(match -> match.getAnswer() == Answer.NAN);
    }
}
