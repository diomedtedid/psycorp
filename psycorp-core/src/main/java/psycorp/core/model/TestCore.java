package psycorp.core.model;


import java.util.Set;

/**
 * Created by User on 09.11.2017.
 * TODO: make processor for calculating dif val of test
 */
public class TestCore {
    private long id;
    private Set<Match> matches;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Match> getMatches() {
        return matches;
    }

    public void setMatches(Set<Match> matches) {
        this.matches = matches;
    }
}
