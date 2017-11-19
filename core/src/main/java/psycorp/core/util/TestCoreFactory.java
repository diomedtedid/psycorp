package psycorp.core.util;


import psycorp.core.model.Match;
import psycorp.core.model.TestCore;
import psycorp.core.model.TestCoreImpl;
import psycorp.core.model.enums.Area;
import psycorp.core.model.enums.Pair;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 10.11.2017.
 */
public final class TestCoreFactory {

    private TestCoreFactory() {
    }

    public static TestCore getTest() {
        TestCore testCore = new TestCoreImpl();
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

        return testCore;
    }
}
