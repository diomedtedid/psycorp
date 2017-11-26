package org.proskura.psycorp.core.util;

import org.proskura.psycorp.core.model.Match;
import org.proskura.psycorp.core.model.TestCompareResult;
import org.proskura.psycorp.core.model.TestCore;
import org.proskura.psycorp.core.model.TestResult;
import org.proskura.psycorp.core.model.enums.Answer;
import org.proskura.psycorp.core.model.enums.Scale;


import java.util.*;

/**
 * Created by User on 19.11.2017.
 */
public final class TestProcessor {

    public static boolean isPassed (TestCore test) {
        return test.getMatches().stream().noneMatch(match -> match.getAnswer() == Answer.NAN);
    }

    public static TestResult countTest (TestCore test) {
        if (!isPassed(test)) {
            return null;
        }

        TestResult testResult = new TestResult();
        Map<Scale, Integer> testProfile = new EnumMap<>(Scale.class);
        //fill scaleIntegerMap with zero values
        Arrays.stream(Scale.values()).forEach(scale -> testProfile.put(scale, 0));

        Set<Match> matches = test.getMatches();
        for (Match match : matches) {
            Answer answer = match.getAnswer();
            Scale scale = null;
            switch (answer) {
                case FIRST:
                    scale = match.getPair().getFirstScale();
                    break;
                case SECOND:
                    scale = match.getPair().getSecondScale();
                    break;
            }

            Integer integer = testProfile.get(scale);
            testProfile.put(scale, integer + 1);
        }

        testResult.setTestProfile(testProfile);

        test.setTestResult(testResult);

        return testResult;
    }

    public static TestCompareResult compare (TestCore test1, TestCore test2) {
        boolean arePassed = isPassed(test1) && isPassed(test2);
        if (!arePassed){
            return null;
        }

        TestCompareResult testCompareResult = new TestCompareResult();
        int generalResult = 0;
        int goalResult = 0;
        int qualityResult = 0;
        int stateResult = 0;


        Set<Match> test1Matches = new HashSet<>(test1.getMatches());
        Set<Match> test2Matches = new HashSet<>(test2.getMatches());

        for (Match match1 : test1Matches) {
            Iterator<Match> matchIterator2 = test2Matches.iterator();
            while (matchIterator2.hasNext()) {
                Match match2 = matchIterator2.next();
                if (match1.getArea() == match2.getArea() && match1.getPair() == match2.getPair()) {
                    if (match1.getAnswer() == match2.getAnswer()) {
                        generalResult++;
                        switch (match1.getArea()) {
                            case QUALITY:
                                qualityResult++;
                                break;
                            case STATE:
                                stateResult++;
                                break;
                            case GOAL:
                                goalResult++;
                                break;
                        }
                    }
                    matchIterator2.remove();
                    break;
                }
            }
        }

        testCompareResult.setGeneralResult(generalResult);
        testCompareResult.setGoalResult(goalResult);
        testCompareResult.setQualityResult(qualityResult);
        testCompareResult.setStateResult(stateResult);

        return testCompareResult;
    }
}
