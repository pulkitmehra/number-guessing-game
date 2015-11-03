package org.collegeboard.game;

/**
 * Implementation of {@link NumberGuess}.
 * It guess in bigger chunks. It guesses exponentially.
 * 
 * NOTE: This is not a thread safe class. It contains state.
 *
 * @author pulkit.mehra
 * Created: Nov 2, 2015
 */
public class CoarseGrainedGuess implements NumberGuess {

    /** The range generator. */
    private RangeGenerator rangeGenerator;

    /** The fine grained guesser. */
    private FineGrainedGuess fineGrainedGuesser;

    /** The iteration. */
    private int iteration = 5;

    /**
     * Instantiates a new coarse grained guess.
     *
     * @param rangeGenerator the range generator
     */
    public CoarseGrainedGuess(RangeGenerator rangeGenerator) {
        this.rangeGenerator = rangeGenerator;
    }

    /**
     * Gets the range generator.
     *
     * @return the range generator
     */
    public RangeGenerator getRangeGenerator() {
        return rangeGenerator;
    }

    /**
     * Sets the range generator.
     *
     * @param rangeGenerator the new range generator
     */
    public void setRangeGenerator(RangeGenerator rangeGenerator) {
        this.rangeGenerator = rangeGenerator;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long nextHighNumber(long current) {
        if (fineGrainedGuesser == null || fineGrainedGuesser.moveToNextRange(current)) {
            Range range = rangeGenerator.generateRange(++iteration);
            fineGrainedGuesser = new FineGrainedGuess(range);
            return range.getUpper();
        }
        return fineGrainedGuesser.nextHighNumber(current);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long nextLowNumber(long current) {
        if (fineGrainedGuesser == null || fineGrainedGuesser.moveToPreviousRange(current)) {
            Range range = rangeGenerator.generateRange(--iteration);
            fineGrainedGuesser = new FineGrainedGuess(range);
            return range.getLower();
        }
        return fineGrainedGuesser.nextLowNumber(current);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void reset() {
        iteration = 5;
        fineGrainedGuesser = null;
    }

}
