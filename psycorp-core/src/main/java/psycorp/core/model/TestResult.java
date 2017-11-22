package psycorp.core.model;

import psycorp.core.model.enums.Area;
import psycorp.core.model.enums.Scale;

import java.util.Map;

/**
 * Created by User on 21.11.2017.
 */
public class TestResult {
    private long id;
    private TestCore testCore;
    private Map<Area, Map<Scale, Integer>> testResultMap;

    public TestCore getTestCore() {
        return testCore;
    }

    public void setTestCore(TestCore testCore) {
        this.testCore = testCore;
    }

    public void setTestResultMap(Map<Area, Map<Scale, Integer>> testResultMap) {
        this.testResultMap = testResultMap;
    }

    public Map<Area, Map<Scale, Integer>> getTestResultMap() {
        return testResultMap;
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
                "testCoreId=" + testCore.getId() +
                "testResultMap=" + testResultMap +
                '}';
    }
}
