package psycorp.core.model;

import java.util.Set;

/**
 * Created by User on 12.11.2017.
 */
public interface TestCore {
    long getId();
    void setId(long id);
    Set<Match> getMatches();
    void setMatches(Set<Match> matches);
}
