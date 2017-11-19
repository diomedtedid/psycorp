package psycorp.core.util.resources;

import java.util.ListResourceBundle;

/**
 * Created by User on 19.11.2017.
 */
public class Questions extends ListResourceBundle {
    private static final Object [] [] contents =  {
            {"goal.one", "goal.1"},
            {"goal.two", "goal.2"},
            {"goal.three", "goal.3"},
            {"goal.four", "goal.4"},
            {"goal.five", "goal.5"},
            {"goal.six", "goal.6"},
            {"quality.one", "quality.1"},
            {"quality.two", "quality.2"},
            {"quality.three", "quality.3"},
            {"quality.four", "quality.4"},
            {"quality.five", "quality.5"},
            {"quality.six", "quality.6"},
            {"state.one", "state.1"},
            {"state.two", "state.2"},
            {"state.three", "state.3"},
            {"state.four", "state.4"},
            {"state.five", "state.5"},
            {"state.six", "state.6"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
