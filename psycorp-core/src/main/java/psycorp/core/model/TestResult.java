package psycorp.core.model;

import psycorp.core.model.enums.Area;
import psycorp.core.model.enums.Scale;

import java.util.Map;

/**
 * Created by User on 21.11.2017.
 */
public class TestResult {
    private Map<Area, Map<Scale, Integer>> testResultMap;

    public Map<Area, Map<Scale, Integer>> getTestResultMap() {
        return testResultMap;
    }

    public void setTestResultMap(Map<Area, Map<Scale, Integer>> testResultMap) {
        this.testResultMap = testResultMap;
    }
}
