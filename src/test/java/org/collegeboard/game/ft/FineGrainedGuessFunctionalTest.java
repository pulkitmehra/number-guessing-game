package org.collegeboard.game.ft;

import org.collegeboard.game.FineGrainedGuess;
import org.collegeboard.game.RangeGenerator;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * The Class FineGrainedGuessFunctionalTest.
 *
 * @author pulkit.mehra
 * Created: Nov 2, 2015
 */
public class FineGrainedGuessFunctionalTest {

    /** The range generator. */
    private RangeGenerator rangeGenerator = new RangeGenerator(5);

    /** The fined grained guesser. */
    private FineGrainedGuess finedGrainedGuesser = new FineGrainedGuess(rangeGenerator.generateRange(5));

    /**
     * Fine grained guess test.
     */
    @Test
    public void fineGrainedGuessTest() {
        long current = 3125;
        long guess = 2100;

        current = finedGrainedGuesser.nextLowNumber(current);
        assertThat(current, is(1875L));

        current = finedGrainedGuesser.nextHighNumber(current);
        assertThat(current, is(2500L));

        current = finedGrainedGuesser.nextLowNumber(current);
        assertThat(current, is(2187L));

        current = finedGrainedGuesser.nextLowNumber(current);
        assertThat(current, is(2031L));

        current = finedGrainedGuesser.nextHighNumber(current);
        assertThat(current, is(2109L));

        current = finedGrainedGuesser.nextLowNumber(current);
        assertThat(current, is(2070L));

        current = finedGrainedGuesser.nextHighNumber(current);
        assertThat(current, is(2089L));

        current = finedGrainedGuesser.nextHighNumber(current);
        assertThat(current, is(2099L));

        current = finedGrainedGuesser.nextHighNumber(current);
        assertThat(current, is(2104L));

        current = finedGrainedGuesser.nextLowNumber(current);
        assertThat(current, is(2101L));

        current = finedGrainedGuesser.nextLowNumber(current);
        assertThat(current, is(guess));
    }

}
