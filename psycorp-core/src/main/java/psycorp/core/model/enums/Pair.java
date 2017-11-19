package psycorp.core.model.enums;

/**
 * Created by User on 10.11.2017.
 */
public enum Pair {
    ONE_TWO (Scale.ONE, Scale.TWO),
    ONE_THREE (Scale.ONE, Scale.THREE),
    ONE_FOUR (Scale.ONE, Scale.FOUR),
    ONE_FIVE (Scale.ONE, Scale.FIVE),
    ONE_SIX (Scale.ONE, Scale.SIX),
    TWO_THREE (Scale.TWO, Scale.THREE),
    TWO_FOUR (Scale.TWO, Scale.FOUR),
    TWO_FIVE (Scale.TWO, Scale.FIVE),
    TWO_SIX (Scale.TWO, Scale.SIX),
    THREE_FOUR (Scale.THREE, Scale.FOUR),
    THREE_FIVE (Scale.THREE, Scale.FIVE),
    THREE_SIX (Scale.THREE, Scale.SIX),
    FOUR_FIVE (Scale.FOUR, Scale.FIVE),
    FOUR_SIX (Scale.FOUR, Scale.SIX),
    FIVE_SIX (Scale.FIVE, Scale.SIX);

    private Scale firstScale;
    private Scale secondScale;

    Pair(Scale firstScale, Scale secondScale) {
        this.firstScale = firstScale;
        this.secondScale = secondScale;
    }

    public Scale getFirstScale() {
        return firstScale;
    }

    public Scale getSecondScale() {
        return secondScale;
    }
}
