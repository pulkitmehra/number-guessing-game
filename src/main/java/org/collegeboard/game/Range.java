package org.collegeboard.game;

/**
 * The Class Range.
 *
 * @author pulkit.mehra
 * Created: Nov 2, 2015
 */
public final class Range {

    /** The lower. */
    private final long lower;

    /** The upper. */
    private final long upper;

    /**
     * Instantiates a new range.
     *
     * @param lower the lower
     * @param upper the upper
     */
    public Range(long lower, long upper) {
        this.lower = lower;
        this.upper = upper;
    }

    /**
     * Gets the lower.
     *
     * @return the lower
     */
    public long getLower() {
        return lower;
    }

    /**
     * Gets the upper.
     *
     * @return the upper
     */
    public long getUpper() {
        return upper;
    }

}
