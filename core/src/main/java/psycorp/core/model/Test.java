package psycorp.core.model;

import psycorp.core.model.enums.Area;

import java.util.Map;
import java.util.Set;

/**
 * Created by User on 18.11.2017.
 */
public interface Test extends TestCore {
    Map<Area, Set<Question>> getQuestions();
}
