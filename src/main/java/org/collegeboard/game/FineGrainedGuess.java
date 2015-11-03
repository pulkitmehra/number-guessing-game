package org.collegeboard.game;

import net.sf.oval.constraint.Min;
import net.sf.oval.constraint.NotNull;

/**
 * Implementation of {@link NumberGuess}.
 * It guess in fine grained ranges. It is binary search algorithm.
 * 
 * NOTE: This class is not Thread Safe.
 *
 * @author pulkit.mehra
 * Created: Nov 2, 2015
 */
public class FineGrainedGuess implements NumberGuess {

    /** The range. */
    private Range range;

    /** The tentative lower. */
    private long tentativeLower;

    /** The tentative upper. */
    private long tentativeUpper;

    /**
     * Instantiates a new fine grained guess.
     *
     * @param range the range
     */
    public FineGrainedGuess(@NotNull Range range) {
        this.range = range;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long nextHighNumber(@Min(1) long current) {
        tentativeLower = current;
        long start = current;
        long end = tentativeUpper > 0 ? tentativeUpper : range.getUpper();
        return doHalf(start, end);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long nextLowNumber(@Min(1) long current) {
        tentativeUpper = current;
        long start = tentativeLower > 0 ? tentativeLower : range.getLower();
        long end = current;
        return doHalf(start, end);
    }

    /**
     * Do half.
     *
     * @param start the start
     * @param end the end
     * @return the long
     */
    private long doHalf(long start, long end) {
        return start + ((end - start) / 2);
    }

    /**
     * Move to next range.
     *
     * @param current the current
     * @return true, if successful
     */
    public boolean moveToNextRange(@Min(1) long current) {
        return current == range.getUpper() || tentativeLower == range.getUpper() || isDifferenceByOne() ||
            isEqualButNotZero();
    }

    /**
     * Move to previous range.
     *
     * @param current the current
     * @return true, if successful
     */
    public boolean moveToPreviousRange(@Min(1) long current) {
        return current == range.getLower() || tentativeUpper == range.getLower() || isDifferenceByOne() ||
            isEqualButNotZero();

    }

    /**
     * Checks if is difference by one.
     *
     * @return true, if is difference by one
     */
    private boolean isDifferenceByOne() {
        if (tentativeLower > tentativeUpper) {
            return tentativeLower - tentativeUpper == 1;
        }
        return tentativeUpper - tentativeLower == 1;
    }

    /**
     * Checks if is equal but not zero.
     *
     * @return true, if is equal but not zero
     */
    private boolean isEqualButNotZero() {
        if (tentativeLower == 0 || tentativeUpper == 0) {
            return false;
        }
        return tentativeLower == tentativeUpper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void reset() {
        tentativeLower = 0;
        tentativeUpper = 0;

    }

}
