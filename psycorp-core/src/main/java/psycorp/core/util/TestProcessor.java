package psycorp.core.util;

import psycorp.core.model.*;
import psycorp.core.model.enums.Answer;
import psycorp.core.model.enums.Area;
import psycorp.core.model.enums.Scale;

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
        Map<Area, Map<Scale, Integer>> testResultMap = new EnumMap<>(Area.class);
        for (Area area : Area.values()) {
            Map<Scale, Integer> scaleIntegerMap = new EnumMap<>(Scale.class);
            //fill scaleIntegerMap with zero values
            Arrays.stream(Scale.values()).forEach(scale -> scaleIntegerMap.put(scale, 0));
            testResultMap.put(area, scaleIntegerMap);
        }

        for (Area area : Area.values()) {
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

                if (match.getArea() == area) {
                    Map<Scale, Integer> scaleIntegerMap = testResultMap.get(area);
                    scaleIntegerMap.put(scale, scaleIntegerMap.get(scale)+ 1);
                }
            }
        }

        testResult.setTestResultMap(testResultMap);

        return testResult;
    }

    public static TestCompareResult compare (TestResult testResult1, TestResult testResult2) {
        return null;
    }
}
