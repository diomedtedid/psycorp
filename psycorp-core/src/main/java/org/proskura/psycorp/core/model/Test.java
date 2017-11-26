package org.proskura.psycorp.core.model;

import org.proskura.psycorp.core.model.enums.Area;

import java.util.Map;
import java.util.Set;

/**
 * Created by User on 10.11.2017.
 */
public class Test extends TestCore {
    private final Map<Area, Set<Question>> questions;

    public Test(TestCore testCore, Map<Area, Set<Question>> questions) {
        this.questions = questions;
        setId(testCore.getId());
        setMatches(testCore.getMatches());
    }

    public Map<Area, Set<Question>> getQuestions() {
        return questions;
    }

}
