package psycorp.core.util.resources;

import java.util.ListResourceBundle;

/**
 * Created by User on 19.11.2017.
 */
public class Questions_ru extends ListResourceBundle {
    private static final Object [] [] contents =  {
            {"goal.one", "цель.один"},
            {"goal.two", "цель.два"},
            {"goal.three", "цель.три"},
            {"goal.four", "цель.четыре"},
            {"goal.five", "цель.пять"},
            {"goal.six", "цель.щесть"},
            {"quality.one", "качество.один"},
            {"quality.two", "качество.два"},
            {"quality.three", "качество.три"},
            {"quality.four", "качество.четыре"},
            {"quality.five", "качество.пять"},
            {"quality.six", "качество.шесть"},
            {"state.one", "состояние.один"},
            {"state.two", "состояние.два"},
            {"state.three", "состояние.три"},
            {"state.four", "состояние.четыре"},
            {"state.five", "состояние.пять"},
            {"state.six", "состояние.шесть"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
