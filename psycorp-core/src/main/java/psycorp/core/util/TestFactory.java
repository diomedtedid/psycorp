package psycorp.core.util;

import psycorp.core.model.Match;
import psycorp.core.model.Question;
import psycorp.core.model.Test;
import psycorp.core.model.TestCore;
import psycorp.core.model.enums.Area;
import psycorp.core.model.enums.Pair;
import psycorp.core.model.enums.Scale;
import java.util.*;

/**
 * Created by User on 18.11.2017.
 * TODO: прописать заполнения мапой разными локалями. Китайцу выдало английский, но в локали записался китаец (накопление разных локалей)
 */
public final class TestFactory {
    private static volatile TestFactory testFactory;
    private static String resourceBundlePath = "psycorp.core.util.questionsource.Questions" ;
    private static Map<Locale, Map<Area, Set<Question>>> questionMapByLanguage = new HashMap<>();

    private TestFactory() {
    }

    public static TestFactory getInctance () {
        if (testFactory == null) {
            synchronized (TestFactory.class) {
                if (testFactory == null) {
                    testFactory = new TestFactory();
                }
            }
        }
        return testFactory;
    }

    public Test getTest (Locale locale) {
        if (!questionMapByLanguage.containsKey(locale)) {
            fillQuestionMapByLanguage (locale);
        }
        Map<Area, Set<Question>> questionsMap = questionMapByLanguage.get(locale);
        Test test = new Test(getTestCore(), questionsMap);
        return test;
    }


    public Test getTest (TestCore testCore, Locale locale) {
        if (!questionMapByLanguage.containsKey(locale)) {
            fillQuestionMapByLanguage (locale);
        }
        Map<Area, Set<Question>> questionsMap = questionMapByLanguage.get(locale);
        Test test = new Test(testCore, questionsMap);
        return test;
    }


    public static TestCore getTestCore() {
        TestCore testCore = new TestCore();
        Set<Match> matches = new HashSet<Match>(45, 1);


        Area[] areas = Area.values();
        Pair[] pairs = Pair.values();

        for (Area area : areas) {
            for (Pair pair : pairs) {
                Match match = new Match(area, pair);
                matches.add(match);
            }
        }
        testCore.setMatches(matches);
        testCore.setTestResult(null);

        return testCore;
    }


    private void fillQuestionMapByLanguage(Locale locale) {
        Map<Area, Set<Question>> questionsMap = new EnumMap<>(Area.class);
        Area[] areas = Area.values();
        Scale [] scales = Scale.values();

        for (Area area : areas) {
            Set<Question> questionSet = new HashSet<>();
            ResourceBundle resourceBundle = ResourceBundle.getBundle(resourceBundlePath, locale);
            String areaString = area.toString().toLowerCase();

            for (Scale scale : scales) {
                String scaleString = scale.toString().toLowerCase();
                String value = resourceBundle.getString(areaString + "." + scaleString);
                Question question = new Question(area, locale, scale, value);
                questionSet.add(question);
            }

            questionsMap.put(area, questionSet);
        }

        questionMapByLanguage.put(locale, questionsMap);
    }


}
