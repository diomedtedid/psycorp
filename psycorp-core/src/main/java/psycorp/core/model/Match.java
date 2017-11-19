package psycorp.core.model;

import psycorp.core.model.enums.Answer;
import psycorp.core.model.enums.Area;
import psycorp.core.model.enums.Pair;

/**
 * Created by DiomedTedid on 10.11.2017.
 * This class implements
 */
public class Match {
    private long id;
    private final Area area;
    private Answer answer = Answer.NAN;
    private final Pair pair;



    public Match(Area area, Pair pair) {
        this.area = area;
        this.pair = pair;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Area getArea() {
        return area;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Pair getPair() {
        return pair;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Match match = (Match) o;

        if (id != match.id) return false;
        if (area != match.area) return false;
        if (answer != match.answer) return false;
        return pair == match.pair;
    }

    @Override
    public int hashCode() {
        int result = area.hashCode();
        result = 31 * result + pair.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", area=" + area +
                ", answer=" + answer +
                ", pair=" + pair +
                '}';
    }
}
