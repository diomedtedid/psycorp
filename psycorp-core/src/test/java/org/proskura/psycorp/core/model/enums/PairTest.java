package org.proskura.psycorp.core.model.enums;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by User on 12.11.2017.
 */
public class PairTest {
    @Test
    public void countOfEnumTest () {
        assertEquals(15, Pair.values().length);
    }

    @Test
    public void fillingOfScalesTest() {
        Scale[] scales = Scale.values();
        Pair[] pairs = Pair.values();
        int pairCount = 0;
        for (int i = 0; i < scales.length; i++) {
            for (int j = i+1; j < scales.length; j++) {
                Pair pair = pairs [pairCount];
                assertEquals(scales[i], pair.getFirstScale());
                assertEquals(scales[j], pair.getSecondScale());
                pairCount++;
            }
        }
    }
}