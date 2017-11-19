package psycorp.core.util.resources;

import java.util.ListResourceBundle;

/**
 * Created by User on 19.11.2017.
 */
public class Questions_ua extends ListResourceBundle {
    private static final Object [] [] contents =  {
            {"goal.one", "ціль.один"},
            {"goal.two", "ціль.два"},
            {"goal.three", "ціль.три"},
            {"goal.four", "ціль.чотири"},
            {"goal.five", "ціль.п'ять"},
            {"goal.six", "ціль.щість"},
            {"quality.one", "якість.один"},
            {"quality.two", "якість.два"},
            {"quality.three", "якість.три"},
            {"quality.four", "якість.чотири"},
            {"quality.five", "якість.п'ять"},
            {"quality.six", "якість.щість"},
            {"state.one", "стан.один"},
            {"state.two", "стан.два"},
            {"state.three", "стан.три"},
            {"state.four", "стан.чотири"},
            {"state.five", "стан.п'ять"},
            {"state.six", "стан.щість"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
