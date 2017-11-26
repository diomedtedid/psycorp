package org.proskura.psycorp.core.model;

import org.proskura.psycorp.core.model.enums.Scale;

import java.util.Map;

/**
 * Created by User on 21.11.2017.
 */
public class TestResult {
    private long id;
    private Map<Scale, Integer> testProfile;

    public void setTestProfile(Map<Scale, Integer> testProfile) {
        this.testProfile = testProfile;
    }

    public Map<Scale, Integer> getTestProfile() {
        return testProfile;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TestResult{" +
                "id=" + id +
                "testProfile=" + testProfile +
                '}';
    }
}
