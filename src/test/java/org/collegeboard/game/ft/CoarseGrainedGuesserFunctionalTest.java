package org.collegeboard.game.ft;

import org.collegeboard.game.CoarseGrainedGuess;
import org.collegeboard.game.RangeGenerator;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

// TODO: Auto-generated Javadoc
/**
 * The Class CoarseGrainedGuesserFunctionalTest.
 *
 * @author pulkit.mehra
 * Created: Nov 2, 2015
 */
public class CoarseGrainedGuesserFunctionalTest {

    private RangeGenerator rangeGenerator = new RangeGenerator(2);
    private CoarseGrainedGuess coarseGrainedGuesser = new CoarseGrainedGuess(rangeGenerator);

    /**
     * Coarse grained guesser odd value test.
     */
    @Test
    public void coarseGrainedGuesserOddValueTest() {
        long guessNumber = 123;

        long current = coarseGrainedGuesser.nextHighNumber(0);
        assertThat(current, is(64L));

        current = coarseGrainedGuesser.nextHighNumber(current);
        assertThat(current, is(128L));

        current = coarseGrainedGuesser.nextLowNumber(current);
        assertThat(current, is(96L));

        current = coarseGrainedGuesser.nextHighNumber(current);
        assertThat(current, is(112L));

        current = coarseGrainedGuesser.nextHighNumber(current);
        assertThat(current, is(120L));

        current = coarseGrainedGuesser.nextHighNumber(current);
        assertThat(current, is(124L));

        current = coarseGrainedGuesser.nextLowNumber(current);
        assertThat(current, is(122L));

        current = coarseGrainedGuesser.nextHighNumber(current);
        assertThat(current, is(guessNumber));

    }

    /**
     * Coarse grained guesser even value test.
     */
    @Test
    public void coarseGrainedGuesserEvenValueTest() {
        long guessNumber = 94;

        long current = coarseGrainedGuesser.nextHighNumber(0);
        assertThat(current, is(64L));

        current = coarseGrainedGuesser.nextHighNumber(current);
        assertThat(current, is(128L));

        current = coarseGrainedGuesser.nextLowNumber(current);
        assertThat(current, is(96L));

        current = coarseGrainedGuesser.nextLowNumber(current);
        assertThat(current, is(80L));

        current = coarseGrainedGuesser.nextHighNumber(current);
        assertThat(current, is(88L));

        current = coarseGrainedGuesser.nextHighNumber(current);
        assertThat(current, is(92L));

        current = coarseGrainedGuesser.nextHighNumber(current);
        assertThat(current, is(guessNumber));

    }

    /**
     * Coarse grained guesser low value test.
     */
    @Test
    public void coarseGrainedGuesserLowValueTest() {
        long guessNumber = 1;

        long current = coarseGrainedGuesser.nextHighNumber(0);
        assertThat(current, is(64L));

        current = coarseGrainedGuesser.nextLowNumber(current);
        assertThat(current, is(48L));

        current = coarseGrainedGuesser.nextLowNumber(current);
        assertThat(current, is(40L));

        current = coarseGrainedGuesser.nextLowNumber(current);
        assertThat(current, is(36L));

        current = coarseGrainedGuesser.nextLowNumber(current);
        assertThat(current, is(34L));

        current = coarseGrainedGuesser.nextLowNumber(current);
        assertThat(current, is(33L));

        current = coarseGrainedGuesser.nextLowNumber(current);
        assertThat(current, is(32L));

        current = coarseGrainedGuesser.nextLowNumber(current);
        assertThat(current, is(16L));

        current = coarseGrainedGuesser.nextLowNumber(current);
        assertThat(current, is(8L));

        current = coarseGrainedGuesser.nextLowNumber(current);
        assertThat(current, is(4L));

        current = coarseGrainedGuesser.nextLowNumber(current);
        assertThat(current, is(2L));

        current = coarseGrainedGuesser.nextLowNumber(current);
        assertThat(current, is(guessNumber));
    }

    /**
     * Coarse grained guesser exact exponential high value test.
     */
    @Test
    public void coarseGrainedGuesserExactExponentialHighValueTest() {
        long guessNumber = 256;

        long current = coarseGrainedGuesser.nextHighNumber(0);
        assertThat(current, is(64L));

        current = coarseGrainedGuesser.nextHighNumber(current);
        assertThat(current, is(128L));

        current = coarseGrainedGuesser.nextHighNumber(current);
        assertThat(current, is(guessNumber));
    }

    /**
     * Coarse grained guesser exact exponential low value test.
     */
    @Test
    public void coarseGrainedGuesserExactExponentialLowValueTest() {
        long guessNumber = 4;

        long current = coarseGrainedGuesser.nextHighNumber(0);
        assertThat(current, is(64L));

        current = coarseGrainedGuesser.nextLowNumber(current);
        assertThat(current, is(48L));

        current = coarseGrainedGuesser.nextLowNumber(current);
        assertThat(current, is(40L));

        current = coarseGrainedGuesser.nextLowNumber(current);
        assertThat(current, is(36L));

        current = coarseGrainedGuesser.nextLowNumber(current);
        assertThat(current, is(34L));

        current = coarseGrainedGuesser.nextLowNumber(current);
        assertThat(current, is(33L));

        current = coarseGrainedGuesser.nextLowNumber(current);
        assertThat(current, is(32L));

        current = coarseGrainedGuesser.nextLowNumber(current);
        assertThat(current, is(16L));

        current = coarseGrainedGuesser.nextLowNumber(current);
        assertThat(current, is(8L));

        current = coarseGrainedGuesser.nextLowNumber(current);
        assertThat(current, is(guessNumber));

    }

}
