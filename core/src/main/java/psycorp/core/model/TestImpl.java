package psycorp.core.model;

import psycorp.core.model.enums.Area;

import java.util.Map;
import java.util.Set;

/**
 * Created by User on 10.11.2017.
 */
public class TestImpl implements Test {
    private final long id;
    private final TestCore testCore;
    private final Map<Area, Set<Question>> questions;

    public TestImpl(TestCore testCore, Map<Area, Set<Question>> questions) {
        this.testCore = testCore;
        this.id = testCore.getId();
        this.questions = questions;
    }

    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
    }

    @Override
    public Set<Match> getMatches() {
        return this.testCore.getMatches();
    }

    @Override
    public void setMatches(Set<Match> matches) {
        this.testCore.setMatches(matches);
    }

    public Map<Area, Set<Question>> getQuestions() {
        return questions;
    }

}
