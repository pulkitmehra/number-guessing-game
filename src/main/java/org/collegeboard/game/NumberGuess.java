package org.collegeboard.game;

/**
 * Abstraction for guessing next Higher or Lower numbers.
 *
 * @author pulkit.mehra
 * Created: Nov 2, 2015
 */
public interface NumberGuess {

    /**
     * Next high number.
     *
     * @param current the current
     * @return the long
     */
    public long nextHighNumber(long current);

    /**
     * Next low number.
     *
     * @param current the current
     * @return the long
     */
    public long nextLowNumber(long current);

    /**
     * Reset.
     * NOTE: This API is out of place It should have its own Interface.
     * Its mechanical rather than contract.
     */
    public void reset();

}
