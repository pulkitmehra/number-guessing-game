package org.collegeboard.game;

import net.sf.oval.constraint.Min;

/**
 * Range generator. This class generates range exponentially.
 *
 * @author pulkit.mehra
 * Created: Nov 2, 2015
 */
public class RangeGenerator {

    /** The base number. */
    private int baseNumber;

    /**
     * Instantiates a new range generator.
     *
     * @param baseNumber the base number
     */
    public RangeGenerator(int baseNumber) {
        this.baseNumber = baseNumber;
    }

    /**
     * Generate range.
     *
     * @param iteration the iteration
     * @return the range
     */
    public Range generateRange(@Min(1) int iteration) {
        double start = Math.pow(baseNumber, iteration - 1);
        double end = Math.pow(baseNumber, iteration);
        return new Range((long) start, (long) end);
    }

}
