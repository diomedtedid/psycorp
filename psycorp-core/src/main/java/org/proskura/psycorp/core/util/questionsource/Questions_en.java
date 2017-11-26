package org.proskura.psycorp.core.util.questionsource;

import java.util.ListResourceBundle;

/**
 * Created by User on 19.11.2017.
 */
public class Questions_en extends ListResourceBundle {
    private static final Object [] [] contents =  {
            {"goal.one", "goal.one"},
            {"goal.two", "goal.two"},
            {"goal.three", "goal.three"},
            {"goal.four", "goal.four"},
            {"goal.five", "goal.five"},
            {"goal.six", "goal.six"},
            {"quality.one", "quality.one"},
            {"quality.two", "quality.two"},
            {"quality.three", "quality.three"},
            {"quality.four", "quality.four"},
            {"quality.five", "quality.five"},
            {"quality.six", "quality.six"},
            {"state.one", "state.one"},
            {"state.two", "state.two"},
            {"state.three", "state.three"},
            {"state.four", "state.four"},
            {"state.five", "state.five"},
            {"state.six", "state.six"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
